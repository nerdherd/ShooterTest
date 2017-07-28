package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BangBangShooter extends Command {

    public BangBangShooter() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
//    	Robot.shooter.BangBangCheck();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
