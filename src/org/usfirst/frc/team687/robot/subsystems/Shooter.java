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

	private final CANTalon flywheel, ejector;
	private final PowerDistributionPanel pdp;
	
	public Shooter(){
		// Initialize ports
		flywheel = new CANTalon(RobotMap.flywheel_port);
		ejector = new CANTalon(RobotMap.eject_port);
		pdp = new PowerDistributionPanel();
		
		SmartDashboard.putNumber("eject_kP: ", RobotMap.eject_kP);
		SmartDashboard.putNumber("eject_kD: ", RobotMap.eject_kF);
		SmartDashboard.putNumber("shooter_kP: ", RobotMap.shooter_kP);
		SmartDashboard.putNumber("shooter_kF: ", RobotMap.shooter_kF);
		SmartDashboard.putNumber("RPM Desired value: ", RobotMap.desired_RPM);

    	flywheel.changeControlMode(CANTalon.TalonControlMode.Speed);
    	
		flywheel.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		
		flywheel.setF(RobotMap.shooter_kF);
    	flywheel.setP(RobotMap.shooter_kP);
    	flywheel.setI(RobotMap.shooter_kI);
    	flywheel.setD(RobotMap.shooter_kD);
    	
    	flywheel.reverseOutput(true);
    	flywheel.configPeakOutputVoltage(0, -12);
    	
    	ejector.setF(RobotMap.eject_kF);
    	ejector.setP(RobotMap.eject_kP);
    	ejector.setI(RobotMap.eject_kI);
    	ejector.setD(RobotMap.eject_kD);
    	
    	ejector.reverseOutput(true);
    	ejector.configPeakOutputVoltage(0, -12);
    	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void initShooter(){
    	flywheel.changeControlMode(CANTalon.TalonControlMode.Speed);
    	flywheel.set(RobotMap.desired_RPM);
    }
    
    public void initEjector(){
    	ejector.changeControlMode(CANTalon.TalonControlMode.Speed);
    	ejector.set(RobotMap.desired_RPM);
    }
    
//    public void BangBangCheck() {
//    	flywheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
//    	if (flywheel.getSpeed() >= flywheel.getSpeed()) {
//    		flywheel.set(1);
//    	} else {
//    		flywheel.set(0);
//    	}
//    	ejector.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
//    	if (ejector.getSpeed() >= ejector.getSpeed()) {
//    		ejector.set(1);
//    	} else {
//    		ejector.set(0);
//    	}
//    }
    
    public void shooterUpdate() {
		SmartDashboard.putNumber("Current RPM", flywheel.getSpeed());
		SmartDashboard.putNumber("Get Voltage: ", pdp.getVoltage());
		SmartDashboard.putNumber("Get Current: ", pdp.getCurrent(1));
		RobotMap.eject_kP = SmartDashboard.getNumber("eject_kP: ", RobotMap.eject_kP);
		RobotMap.eject_kF = SmartDashboard.getNumber("eject_kD: ", RobotMap.eject_kF);
		RobotMap.shooter_kP = SmartDashboard.getNumber("shooter_kP: ", RobotMap.shooter_kP);
		RobotMap.shooter_kF = SmartDashboard.getNumber("shooter_kF: ", RobotMap.shooter_kF);
		RobotMap.desired_RPM = SmartDashboard.getNumber("RPM Desired value: ", RobotMap.desired_RPM);
    }
    
}