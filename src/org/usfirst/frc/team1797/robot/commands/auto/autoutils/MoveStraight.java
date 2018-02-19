package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @version 2.0, changes by techtide, to allow PID and straight driving.
 */

public class MoveStraight extends Command {
	private Direction direction;
	private double driveSpeed;
	private double driveSpeedL, driveSpeedR;
	private double maxDistance;
	
    public MoveStraight(Direction d, double speed, double distance) {
    		this.direction = d;
    		this.driveSpeed = speed;
    		this.maxDistance = distance;
    		requires(Robot.DRIVE_TRAIN);
    }
    
    protected void initialize() {
    		Robot.DRIVE_TRAIN.resetEncoders();
    		
    		// Uses a terenary operator to reverse the direction for backwards speeds.
    		driveSpeed = (direction == Direction.BACKWARD) ? (driveSpeed) : (-driveSpeed);
    		driveSpeedL = driveSpeed;
    		driveSpeedR = -driveSpeed;
    }

    protected void execute() {
    		// Calls the error correction drive (uses PID) to correct driving straight.
    		Robot.DRIVE_TRAIN.errorCorrectionDrive(driveSpeed);
//    	Robot.DRIVE_TRAIN.tankDrive(driveSpeedL, driveSpeedR);
    }

    protected boolean isFinished() {
    		return Robot.DRIVE_TRAIN.getAverageEncoderDistance() > maxDistance;
    }

    protected void end() {
    		Robot.DRIVE_TRAIN.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    		end();
    }
}
