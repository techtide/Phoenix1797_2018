//package org.usfirst.frc.team1797.robot.commands.teleoputils;
//
//import org.usfirst.frc.team1797.robot.Robot;
//import org.usfirst.frc.team1797.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class RampLift extends Command {
//
//    public RampLift() {
//        // Use requires() here to declare subsystem dependencies
//        requires(Robot.RAMP);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//			Robot.RAMP.lift();
//	}
//	
//	// Called repeatedly when this Command is scheduled to run
//	protected void execute() {
//	}
//	
//	// Make this return true when this Command no longer needs to run execute()
//	protected boolean isFinished() {
//	    return Robot.RAMP.getLastActuation() - System.currentTimeMillis() >= 1000;
//	}
//	
//	// Called once after isFinished returns true
//	protected void end() {
//			Robot.RAMP.stop();
//	}
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    		end();
//    }
//    
//}