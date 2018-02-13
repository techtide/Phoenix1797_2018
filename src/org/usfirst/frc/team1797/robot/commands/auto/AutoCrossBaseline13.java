package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCrossBaseline13 extends Command {
	private static final double DRIVE_DISTANCE = 100;
	private static final double DRIVE_SPEED = 0.7;

	public AutoCrossBaseline13() {
		// Cross the baseline from the first or third alliance position.
		requires(Robot.DRIVE_TRAIN);
	}

	protected void initialize() {
		RobotMap.delay();
		Robot.DRIVE_TRAIN.resetEncoders();
	}

	protected void execute() {
		Robot.DRIVE_TRAIN.arcadeDrive(-DRIVE_SPEED, 0);
	}

	protected boolean isFinished() {
		return Robot.DRIVE_TRAIN.getAverageEncoderDistance() > DRIVE_DISTANCE;
	}
	
	protected void end() {
		Robot.DRIVE_TRAIN.stopDrive();
	}
	
	protected void interrupted() {
		end();
	}
}