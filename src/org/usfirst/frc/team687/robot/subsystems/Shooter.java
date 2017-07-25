package org.usfirst.frc.team687.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import org.usfirst.frc.team687.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {

	private final CANTalon flywheel, eject;
	private boolean at_target = false;
	private final PowerDistributionPanel pdp;
	
	public Shooter(){
		// Initialize ports
		flywheel = new CANTalon(RobotMap.flywheel_port);
		eject = new CANTalon(RobotMap.eject_port);
		pdp = new PowerDistributionPanel();
		SmartDashboard.putNumber("RPM Desired value: ", RobotMap.desired_shooter_RPM);

		
		
//		flywheel.set(0.5);

    	flywheel.changeControlMode(CANTalon.TalonControlMode.Speed);
		//PID initialization
//    	flywheel.changeControlMode(CANTalon.TalonControlMode.Speed);
		flywheel.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		
		flywheel.setF(RobotMap.shooter_kF);
    	flywheel.setP(RobotMap.shooter_kP);
    	flywheel.setI(0);
    	flywheel.setD(RobotMap.shooter_kD);
    	
    	flywheel.reverseOutput(true);
    	flywheel.configPeakOutputVoltage(0, -12);
    	
//    	flywheel.enable();    	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void initShooter(){
    	flywheel.changeControlMode(CANTalon.TalonControlMode.Speed);
    	flywheel.set(RobotMap.desired_shooter_RPM);
    }
    
    public void shootCommand(){
    	flywheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	eject.set(RobotMap.eject_speed);
    }
    
    public boolean getAtTarget(){
    	return at_target;
    }
    
    public void setAtTarget(boolean value){
    	targetDetection();
    	at_target = value;
    }
    
    private void targetDetection(){
    	if(RobotMap.percent_tolerance >= flywheel.getSpeed()/RobotMap.desired_shooter_RPM){
    		at_target = true;
    	} else {
    		at_target = false;
    	}
    }
    
    public double getRPM(){
    	return flywheel.getSpeed();
    }
    
    public void endFly() {
    	flywheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	flywheel.set(0);
    }
    public void endEject() {
    	eject.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	eject.set(0);
    }
    
    public void BangBangCheck(double desired, double current) {
    	flywheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	if (desired >= current) {
    		flywheel.set(1);
    	} else {
    		flywheel.set(0);
    	}
    }
    
    public void shooterUpdate() {
		SmartDashboard.putNumber("RPM", getRPM());
		SmartDashboard.putBoolean("At Target: ", getAtTarget());
		SmartDashboard.putNumber("Get Voltage: ", pdp.getVoltage());
		SmartDashboard.putNumber("Get Current: ", pdp.getCurrent(1));
		RobotMap.desired_shooter_RPM = SmartDashboard.getNumber("RPM Desired value: ", RobotMap.desired_shooter_RPM);
    }
    
}