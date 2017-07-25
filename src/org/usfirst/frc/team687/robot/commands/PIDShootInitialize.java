package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;
import org.usfirst.frc.team687.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDShootInitialize extends Command {

    public PIDShootInitialize() {
        requires(Robot.shooter);
    }
    
    @Override
    protected void initialize(){
    	
    }
    
    @Override
    protected void execute() {
    	Robot.shooter.initShooter();
    }

    @Override
	protected boolean isFinished() {
    	return false;
//		return Robot.shooter.getAtTarget();
	}
}
