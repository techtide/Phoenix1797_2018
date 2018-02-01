package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCrossBaseline13 extends Command {

	// These variables will stay here because they just regard this stuff
	private static final double DRIVE_DISTANCE = 24; // the distance for the command to run for (in inches)
	private static final double DRIVE_SPEED = 0.85; // Speed for motors to run at while executing

	public AutoCrossBaseline13() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.DRIVE_TRAIN);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.delay();
		Robot.DRIVE_TRAIN.resetEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.DRIVE_TRAIN.arcadeDrive(DRIVE_SPEED, 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.DRIVE_TRAIN.getAverageEncoderDistance() > DRIVE_DISTANCE;
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