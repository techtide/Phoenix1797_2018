//package org.usfirst.frc.team1797.robot.commands;
//
//import org.usfirst.frc.team1797.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class ReverseRollerPiston extends Command {
//
//    public ReverseRollerPiston() {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    		requires(Robot.ROLLER_PISTON);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    		Robot.ROLLER_PISTON.reverse();
//    		Robot.ROLLER_PISTON.stop();	
//    }
//    
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return System.currentTimeMillis() - Robot.ROLLER_PISTON.getLastActuation() >= 1000;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    		Robot.ROLLER_PISTON.stop();
//    		Robot.ROLLER_PISTON.isDown = true;
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    		end();
//    }
//}
