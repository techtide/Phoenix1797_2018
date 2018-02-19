//package org.usfirst.frc.team1797.robot.subsystems;
//
//import org.usfirst.frc.team1797.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */
//public class Ramp extends Subsystem {
//
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//
//	private DoubleSolenoid deployPiston, liftPiston;
//			
//	private long lastActuation;
//	
//	public boolean isDeployed = false;
//	
//	public Ramp() {
//		deployPiston = new DoubleSolenoid(RobotMap.getPort("deploy_piston_1"),
//				RobotMap.getPort("deploy_piston_2"));
//		liftPiston = new DoubleSolenoid(RobotMap.getPort("lift_piston_1"),
//				RobotMap.getPort("lift_piston_2"));
////		pistonThree = new DoubleSolenoid(RobotMap.getPort("ramp_piston_3"),
////				RobotMap.getPort("right_piston_3"));
//	}
//	
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    }
//    public long getLastActuation() {
//    	return lastActuation;
//    }
//    public void deploy() {
//    	deployPiston.set(DoubleSolenoid.Value.kForward);
//    	lastActuation = System.currentTimeMillis();
////    	pistonTwo.set(DoubleSolenoid.Value.kForward);
////    	pistonThree.set(DoubleSolenoid.Value.kForward);
//    }
////    public void retract() {
////    	deployPiston.set(DoubleSolenoid.Value.kReverse);
//////    	pistonTwo.set(DoubleSolenoid.Value.kReverse);
//////    	pistonThree.set(DoubleSolenoid.Value.kReverse);
////    }
//    public void lift() {
//    	liftPiston.set(DoubleSolenoid.Value.kForward);
//    	lastActuation = System.currentTimeMillis();
//    }
//    public void stop() {
//    	deployPiston.set(DoubleSolenoid.Value.kOff);
//    	liftPiston.set(DoubleSolenoid.Value.kOff);
//    	lastActuation = Long.MAX_VALUE;
////    	pistonTwo.set(DoubleSolenoid.Value.kOff);
////    	pistonThree.set(DoubleSolenoid.Value.kOff);
//    }
//}