package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCrossBaseline2 extends Command {

    public AutoCrossBaseline2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.DRIVE_TRAIN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		//Does the stuff
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		//do this stuff more than once
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //when youve had enough of it
    }

    // Called once after isFinished returns true
    protected void end() {
    		//clean up all your mess
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		//when its interrupted do this
    }
}
