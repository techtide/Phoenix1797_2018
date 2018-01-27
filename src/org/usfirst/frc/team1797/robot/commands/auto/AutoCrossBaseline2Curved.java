package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class AutoCrossBaseline2Curved extends Command {

	private EncoderFollower leftFollower, rightFollower;
	
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
    	if(gameData.charAt(0)=='L') {
    		points[1] = new Waypoint( -3.05, 3.35, Pathfinder.d2r(0));
    	} else {
    		points[1] = new Waypoint( 3.05, 3.35, Pathfinder.d2r(0));
    	}
    	
    	// Time Step:           0.02 Seconds
    	// Max Velocity:        2.0 m/s
    	// Max Acceleration:    2.0 m/s/s
    	// Max Jerk:            60.0 m/s/s/s
    	Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
    			Trajectory.Config.SAMPLES_HIGH, 0.02, 2.0, 2.0, 60.0);

    	// Generate the trajectory
    	Trajectory trajectory = Pathfinder.generate(points, config);
    	TankModifier modifier = new TankModifier(trajectory);
    	modifier.modify(RobotMap.WHEELBASE_WIDTH);
    	
    	Trajectory left = modifier.getLeftTrajectory();
    	Trajectory right = modifier.getRightTrajectory();
    	
    	leftFollower = new EncoderFollower(left);
    	rightFollower = new EncoderFollower(right);
    	
    	leftFollower.configureEncoder(Robot.DRIVE_TRAIN.leftEncoder.get(), 1000, .015);
    	rightFollower.configureEncoder(Robot.DRIVE_TRAIN.rightEncoder.get(), 1000, .015);
    	
    	leftFollower.configurePIDVA(1.0, 0.0, 0.0, .5, 0.0);
    	rightFollower.configurePIDVA(1.0, 0.0, 0.0, .5, 0.0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double l = leftFollower.calculate(Robot.DRIVE_TRAIN.leftEncoder.get());
    	double r = rightFollower.calculate(Robot.DRIVE_TRAIN.rightEncoder.get());
    	
    	double gyroHeading = RobotMap.gyro.getAngle();
    	double desiredHeading = Pathfinder.r2d(leftFollower.getHeading());
    	double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading-gyroHeading);
    	double turn = 0.8*(-1/80.0)*angleDifference;
    	
    	Robot.DRIVE_TRAIN.tankDrive(l+turn, r-turn);
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
