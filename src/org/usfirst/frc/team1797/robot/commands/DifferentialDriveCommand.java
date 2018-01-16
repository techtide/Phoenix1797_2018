package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DifferentialDriveCommand extends Command {
	public DifferentialDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		// no subsystem needed
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		double x = Robot.oi.driverInput.getRawAxis(3);
    		double y = Robot.oi.driverInput.getRawAxis(1);
    		
    		x *= Math.abs(x);
    		y *= Math.abs(y);
    		
    		/*Robot.DRIVE_TRAIN.setLeft(y+x);
    		Robot.DRIVE_TRAIN.setRight(-y+x); */
    		// 1 (X), 3 (Y) = SPEED, ROTATION
    		Robot.DRIVE_TRAIN.arcadeDrive(x, y);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.DRIVE_TRAIN.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
