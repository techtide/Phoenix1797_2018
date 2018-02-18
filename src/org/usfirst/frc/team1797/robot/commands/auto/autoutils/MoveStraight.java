package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
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
    
    // Called just before this Command runs the first time
    protected void initialize() {
    		System.out.println();
    		System.out.println("[INFO] Initializing moving command!");
    		
    		//Resetting encoders to allow precise measurements
    		Robot.DRIVE_TRAIN.resetEncoders();
    		
    		//Inverts the drive speed to allow the robot to go backwards
    		driveSpeed *= direction == Direction.BACKWARD ? -1 : 1;
    		driveSpeedL = driveSpeed;
    		driveSpeedR = -driveSpeed;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		//Updates the drivetrain to move
    	
    		// System.out.println("Distance: " + Robot.DRIVE_TRAIN.getAverageEncoderDistance());
//    		System.out.println("Left: "+Robot.DRIVE_TRAIN.leftEncoder.getDistance()+"\t"
//    				+ "Right: "+Robot.DRIVE_TRAIN.rightEncoder.getDistance());
//    		
    		// System.out.println("∠: " + RobotMap.gyro.getAngle() + "˚");
    		// Robot.DRIVE_TRAIN.arcadeDrive(-driveSpeed, 0);
    		System.out.println(driveSpeedL+"\t"+driveSpeedR);
    		Robot.DRIVE_TRAIN.tankDrive(driveSpeedL, driveSpeedR);
//    		if(Robot.DRIVE_TRAIN.leftEncoder.getDistance()<Robot.DRIVE_TRAIN.rightEncoder.getDistance()) {
//    			driveSpeedL += .02;
//    		} else {
//    			driveSpeedR -= .02;
//    		}
//    		driveSpeedL -= .01;
//    		driveSpeedR += .01;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		//checks to see if the robot has passed the difference
        return Robot.DRIVE_TRAIN.getAverageEncoderDistance() > maxDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
    		//stops the motors.
    		Robot.DRIVE_TRAIN.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
