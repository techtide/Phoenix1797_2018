package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.OI;
import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.DRIVE_TRAIN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		double x = Robot.oi.driverInput.getRawAxis(3);
    		double y = Robot.oi.driverInput.getRawAxis(1);
    		
    		x *= Math.abs(x);
    		y *= Math.abs(y);
    		
    		Robot.DRIVE_TRAIN.setLeft(y+x);
    		Robot.DRIVE_TRAIN.setRight(-y+x);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.DRIVE_TRAIN.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
