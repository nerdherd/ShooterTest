package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDShootInitiate extends Command {

    public PIDShootInitiate() {
        requires(Robot.shooter);
    }
    
    @Override
    protected void initialize(){
    	
    }
    
    @Override
    protected void execute() {
    	Robot.shooter.initShooter();
    }
    
    protected void end() {
    	Robot.shooter.stopShooter();
    }

    @Override
	protected boolean isFinished() {
    	return false;
	}
}
