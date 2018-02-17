//package org.usfirst.frc.team1797.robot.subsystems;
//
//import org.usfirst.frc.team1797.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.VictorSP;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */
//public class IntakeMotors extends Subsystem {
//
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//	
//	private VictorSP motor1, motor2;
//	
//	public IntakeMotors() {
//		motor1 = new VictorSP(RobotMap.getPort("intake_motot_1"));
//		motor2 = new VictorSP(RobotMap.getPort("intake_motot_2"));
//	}
//	
//	public void intake() {
//		motor1.set(RobotMap.INTAKE_MOTOR_SPEED);
//		motor2.set(-RobotMap.INTAKE_MOTOR_SPEED);
//	}
//	public void outtake() {
//		motor1.set(-RobotMap.INTAKE_MOTOR_SPEED);
//		motor2.set(RobotMap.INTAKE_MOTOR_SPEED);
//	}
//	public void stop() {
//		motor1.set(0);
//		motor2.set(0);
//	}
//	
//	public boolean hasBox() {
//		return true;
//	}
//	
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    }
//}
//
