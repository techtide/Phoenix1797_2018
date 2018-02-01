package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {
	
	public DriveCommand() {
        //Use requires() here to declare subsystem dependencies
		requires(Robot.DRIVE_TRAIN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    		double z = Robot.oi.driverInput.getRawAxis(4);
//    		double x = Robot.oi.driverInput.getRawAxis(1);
    		
//    		x *= Math.abs(x);
//    		z *= Math.abs(z);
    		//gets the raw value from the controllers.
    		double x = Robot.oi.driverInput.getRawAxis(RobotMap.DRIVER_FORWARD_AXIS);
    		double z = Robot.oi.driverInput.getRawAxis(RobotMap.DRIVER_HORIZONTAL_AXIS);
    		
    		//function used to alter values
    		x *= Math.abs(x);
    		z *= Math.abs(z);
    		
    		//Input to drive
    		System.out.println(Robot.oi.driverInput.getRawAxis(RobotMap.DRIVER_FORWARD_AXIS));
    		Robot.DRIVE_TRAIN.arcadeDrive(x * RobotMap.DRIVETRAIN_SENSITIVITY, z * RobotMap.DRIVETRAIN_SENSITIVITY);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
