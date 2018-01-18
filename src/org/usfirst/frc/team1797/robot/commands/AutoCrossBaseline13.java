package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCrossBaseline13 extends Command {

	private static final double DRIVE_LENGTH = 2; //the time for the command to run for (in seconds)
	private static final double DRIVE_SPEED = 0.3; // Speed for motors to run at while executing
	
	private long startTime = Long.MAX_VALUE; //Similar to last actuation but used for timing motors.
	
    public AutoCrossBaseline13() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.DRIVE_TRAIN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		startTime = System.currentTimeMillis();
    		Robot.DRIVE_TRAIN.arcadeDrive(DRIVE_SPEED, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime >= (DRIVE_LENGTH * 1000);
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