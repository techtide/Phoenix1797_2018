//package org.usfirst.frc.team1797.robot.commands;
//
//import org.usfirst.frc.team1797.robot.Robot;
//import org.usfirst.frc.team1797.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class FlipperActivateLeft extends Command {
//
//    public FlipperActivateLeft() {
//        // Use requires() here to declare subsystem dependencies
//        requires(Robot.FLIPPER);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    		Robot.FLIPPER.extendLeft(); //Extends the left piston
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() { //After {var} seconds of lift the piston will stop and then retract
//    		if(System.currentTimeMillis() - Robot.FLIPPER.getLastActuationLeft() >= RobotMap.FLIPPER_PISTON_TIME && Robot.FLIPPER.isLeftExtended()) {
//    			Robot.FLIPPER.stopRight();
//    			Robot.FLIPPER.retractLeft();
//    		}
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() { // after the piston has come down for {var} seconds stop the robot.
//    		//!Flipper extended ensures this IS NOT CALLED when the piston becomes extended
//    		return(System.currentTimeMillis() - Robot.FLIPPER.getLastActuationLeft() >= RobotMap.FLIPPER_PISTON_TIME) && !Robot.FLIPPER.isLeftExtended();
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    		Robot.FLIPPER.stopLeft();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	Robot.FLIPPER.retractLeft();
//    		/*boolean notStopped = true;
//		while(notStopped) {
//			if(System.currentTimeMillis() - Robot.FLIPPER.getLastActuationLeft() >= 1000 && Robot.FLIPPER.isLeftExtended()) {
//    			Robot.FLIPPER.stopLeft();
//    			notStopped = false;
//			}
//		}*/
//    }
//}
