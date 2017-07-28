package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDEjectorInitiate extends Command {

    public PIDEjectorInitiate() {
        requires(Robot.shooter);
    }

    @Override
    protected void initialize() {
    	
    }

    @Override
    protected void execute() {
    	Robot.shooter.initEjector();
    }
    
	@Override
	protected boolean isFinished() {
		return !Robot.oi.articulationButtonState(5);
	}
}
