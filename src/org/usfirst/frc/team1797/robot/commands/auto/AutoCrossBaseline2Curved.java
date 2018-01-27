package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;
import org.usfirst.frc.team1797.robot.utils.PathfinderUtils;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

/**
 *
 */
public class AutoCrossBaseline2Curved extends Command {

	private PathfinderUtils pathfinderUtils;
	
	public AutoCrossBaseline2Curved() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.DRIVE_TRAIN);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.delay();
		
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		Waypoint[] points = new Waypoint[2];
		points[0] = new Waypoint(0, 0, Pathfinder.d2r(0));
		
		if (gameData.charAt(0) == 'L') {
			points[1] = new Waypoint(-3.05, 3.35, Pathfinder.d2r(0));
		} else {
			points[1] = new Waypoint(3.05, 3.35, Pathfinder.d2r(0));
		}

		pathfinderUtils = new PathfinderUtils(points, Robot.DRIVE_TRAIN.leftEncoder, Robot.DRIVE_TRAIN.rightEncoder);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double[] speeds = pathfinderUtils.update(Robot.DRIVE_TRAIN.leftEncoder, Robot.DRIVE_TRAIN.rightEncoder, RobotMap.gyro);

		Robot.DRIVE_TRAIN.tankDrive(speeds[0], speeds[1]);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
