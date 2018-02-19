//package org.usfirst.frc.team1797.robot.subsystems;
//
//import org.usfirst.frc.team1797.robot.RobotMap;
//
//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.VictorSP;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */
//public class Flipper extends Subsystem {
//
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//	
//	// private VictorSP motor;
//	private WPI_VictorSPX motor;
//	private DigitalInput back, front;
//	
//	public Flipper() {
//		motor = new WPI_VictorSPX(RobotMap.getPort("flipper_motor"));
//		back = new DigitalInput(RobotMap.getPort("flipper_switch_back"));
//		front = new DigitalInput(RobotMap.getPort("flipper_switch_front"));
//	}
//	public void set(double x) {
//		motor.set(x);
//	}
//	public boolean isBack() {
//		return back.get();
//	}
//	public boolean isForward() {
//		return front.get();
//	}
//
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    }
//}
//
