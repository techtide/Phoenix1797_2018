package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendRollerPiston extends Command {

    public ExtendRollerPiston() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.ROLLER_PISTON);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.ROLLER_PISTON.raise();
    		Robot.ROLLER_PISTON.isDown = false;
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - Robot.ROLLER_PISTON.getLastActuation() >= 1000;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.ROLLER_PISTON.stop();
    		Robot.ROLLER_PISTON.isUp = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
