package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnCommand extends Command {
	private double currentAngle, finalAngle;
	private static final double speed = .5;
	private boolean bool;
	private AHRS gyro;
    public TurnCommand(double ang, AHRS gyro, boolean b) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DRIVE_TRAIN);
    	currentAngle = gyro.getAngle();
    	double temp = b? ang:-ang;
    	finalAngle = gyro.getAngle() + temp;
    	bool = b;
    	this.gyro = gyro;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(bool) Robot.DRIVE_TRAIN.tankDrive(speed, -speed);
    	else Robot.DRIVE_TRAIN.tankDrive(-speed, speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(bool) {
    		return gyro.getAngle()>=finalAngle;
    	}
    	return gyro.getAngle()<=finalAngle;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
