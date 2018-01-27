package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RampPistonExtend extends Command {

    public RampPistonExtend() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.RAMP);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.RAMP.extendPistonOne(); //Extends the left piston
    		Robot.RAMP.extendPistonTwo();
    		Robot.RAMP.extendPistonThree();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { //After {var} seconds of lift the piston will stop and then retract
    		if(System.currentTimeMillis() - Robot.RAMP.getPistonOneActuation() >= RobotMap.RAMP_PISTON_TIME) {
    			Robot.RAMP.stopPistonOne();
    			Robot.RAMP.stopPistonTwo();
    			Robot.RAMP.stopPistonThree();
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { // after the piston has come down for {var} seconds stop the robot.
    		return(System.currentTimeMillis() - Robot.RAMP.getPistonOneActuation() >= RobotMap.RAMP_PISTON_TIME);
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.RAMP.stopPistonOne();
    		Robot.RAMP.stopPistonTwo();
    		Robot.RAMP.stopPistonThree();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
    
}