package org.usfirst.frc.team1797.robot.utils;

import org.usfirst.frc.team1797.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

// @version 2

public class PathfinderUtils {
	
	private static final double TIME_STEP = 2.0;
	private static final double MAX_VELOCITY = 2.0;
	private static final double MAX_ACCELERATION = 1.0;
	private static final double MAX_JERK = 1.0;
	
	private static final int TPR = 1000;
	
	
	private static final Trajectory.FitMethod FIT_METHOD = Trajectory.FitMethod.HERMITE_CUBIC;
	
	private EncoderFollower left;
	private EncoderFollower right;
	
	private Trajectory initialTrajectory;
	
	public PathfinderUtils(Waypoint[] waypoints, Encoder leftEncoder, Encoder rightEncoder) {
		Trajectory.Config configuration = new Trajectory.Config(FIT_METHOD, Trajectory.Config.SAMPLES_HIGH, TIME_STEP, MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK);
		Trajectory trajectory = Pathfinder.generate(waypoints, configuration);
		this.initialTrajectory = trajectory;
		TankModifier modifier = new TankModifier(trajectory);
		modifier.modify(RobotMap.ROBOT_BASE_WIDTH);
		
		Trajectory leftTraj = modifier.getLeftTrajectory();
		Trajectory rightTraj = modifier.getRightTrajectory();
		left = new EncoderFollower(leftTraj);
		right = new EncoderFollower(rightTraj);
		
		left.configureEncoder(leftEncoder.get(), TPR, RobotMap.ROBOT_WHEEL_WIDTH);
		right.configureEncoder(rightEncoder.get(), TPR, RobotMap.ROBOT_WHEEL_WIDTH);
		
		left.configurePIDVA(1, 0, 0, 1 / MAX_VELOCITY, 0);
		right.configurePIDVA(1, 0, 0, 1 / MAX_VELOCITY, 0);
	}
	
	public PathfinderUtils(Waypoint[] waypoints) {
		Trajectory.Config configuration = new Trajectory.Config(FIT_METHOD, Trajectory.Config.SAMPLES_HIGH, TIME_STEP, MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK);
		Trajectory trajectory = Pathfinder.generate(waypoints, configuration);
		this.initialTrajectory = trajectory;
	}
	
	public PathfinderUtils(Trajectory trajectory, Encoder leftEncoder, Encoder rightEncoder) {
		this.initialTrajectory = trajectory;
		TankModifier modifier = new TankModifier(trajectory);
		modifier.modify(RobotMap.ROBOT_BASE_WIDTH);
		
		Trajectory leftTraj = modifier.getLeftTrajectory();
		Trajectory rightTraj = modifier.getRightTrajectory();
		left = new EncoderFollower(leftTraj);
		right = new EncoderFollower(rightTraj);
		
		left.configureEncoder(leftEncoder.get(), TPR, RobotMap.ROBOT_WHEEL_WIDTH);
		right.configureEncoder(rightEncoder.get(), TPR, RobotMap.ROBOT_WHEEL_WIDTH);
		
		left.configurePIDVA(1, 0, 0, 1 / MAX_VELOCITY, 0);
		right.configurePIDVA(1, 0, 0, 1 / MAX_VELOCITY, 0);
	}
	
	public double[] update(Encoder leftEncoder, Encoder rightEncoder, AHRS gyro) {
		double l = left.calculate(leftEncoder.get());
		double r = right.calculate(rightEncoder.get());
		
		double gyroHeading = gyro.getAngle();
		double desiredHeading = Pathfinder.r2d(left.getHeading());
		double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - gyroHeading);
		double turn = 0.8 * (-1 / 80.0) * angleDifference;
		
		double[] values = {(l + turn), (r - turn)};
		return values;
	}

	public Trajectory getInitialTrajectory() {
		return initialTrajectory;
	}
	
}
