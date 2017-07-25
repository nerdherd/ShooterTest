package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends Command {

    public ShootCommand() {
        requires(Robot.shooter);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	Robot.shooter.shootCommand();
    }
    
	@Override
	protected boolean isFinished() {
		return false;
	}
}
