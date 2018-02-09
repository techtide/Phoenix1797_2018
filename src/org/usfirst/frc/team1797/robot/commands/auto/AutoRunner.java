package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;
import org.usfirst.frc.team1797.robot.utils.TrajectoryManager;
import org.usfirst.frc.team1797.robot.utils.PathfinderUtils;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Trajectory;

/**
 *
 */
public class AutoRunner extends Command {

	private Routines currentAutoRoutine;
	private PathfinderUtils pathfinderUtils;
	private TrajectoryManager localTrajectoryManager;
	
	public enum Routines {
		BASELINECURVED2, DEPOSITBOX1, DEPOSITBOX2, DEPOSITBOX3
	}

	public AutoRunner(Routines routine) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.currentAutoRoutine = routine;
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
<<<<<<< HEAD
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		
=======
>>>>>>> pr/24
		Robot.DRIVE_TRAIN.resetEncoders();
		pathfinderUtils = new PathfinderUtils(getTrajectory(gameData.charAt(0)), Robot.DRIVE_TRAIN.leftEncoder, Robot.DRIVE_TRAIN.rightEncoder);
	}

<<<<<<< HEAD
	protected Trajectory getTrajectory(char side) {
		return localTrajectoryManager.readPointsData(currentAutoRoutine.toString() + side);
=======
	protected Trajectory getTrajectory() {
		if(DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L') {
			return localTrajectoryManager.readPointsData(currentAutoRoutine, "L");
		} else if(DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R') {
			return localTrajectoryManager.readPointsData(currentAutoRoutine, "R");
		} else {
			return localTrajectoryManager.readPointsData(currentAutoRoutine, "");
		}
>>>>>>> pr/24
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double[] speeds = pathfinderUtils.update(Robot.DRIVE_TRAIN.leftEncoder, Robot.DRIVE_TRAIN.rightEncoder,
				RobotMap.gyro);
		Robot.DRIVE_TRAIN.tankDrive(-speeds[0], -speeds[1]);
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
