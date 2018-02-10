package org.usfirst.frc.team1797.robot.testauto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveStraight extends Command {

	private Direction direction;
	private double driveSpeed;
	private double maxDistance;
	
    public MoveStraight(Direction d, double speed, double distance) {
    		this.direction = d;
    		this.driveSpeed = speed;
    		this.maxDistance = distance;
    		requires(Robot.DRIVE_TRAIN);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    		System.out.println("[INFO] Initializing moving command!");
    		
    		//Resetting encoders to allow precise measurements
    		Robot.DRIVE_TRAIN.resetEncoders();
    		
    		//Inverts the drive speed to allow the robot to go backwards
    		driveSpeed *= direction == Direction.BACKWARD ? -1 : 1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		//Updates the drivetrain to move
    	
    		System.out.println(RobotMap.gyro.isConnected());
    		System.out.println(RobotMap.gyro.getAngle());
    		Robot.DRIVE_TRAIN.arcadeDrive(-driveSpeed, 0);
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
