package org.usfirst.frc.team1797.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// delay method
	private static final double DELAY_SECONDS = 0;

	public static void delay() {
		long startTime = System.currentTimeMillis();
		while (DELAY_SECONDS * 1000 + startTime > System.currentTimeMillis()) {}
	}

	// Robot controls
	public static final int DRIVER_FORWARD_AXIS = 1;
	public static final int DRIVER_HORIZONTAL_AXIS = 4;

	public static final int DRIVER_CONTROLLER_PORT = 0;
	public static final int OPERATOR_CONTROLLER_PORT = 1;

	// Physical multiplier of motors
	public static final double DRIVETRAIN_SENSITIVITY = 1;
	public static final double INTAKE_MOTOR_SPEED = 1;

	// Time before pistons stop extending/retracting
	public static final double FLIPPER_PISTON_TIME = 1000; // in milliseconds

	// Time before ramp stops extending/retracting
	public static final double RAMP_PISTON_TIME = 1000; // in milliseconds
	
	// Distance between left and right wheels
	public static final double ROBOT_BASE_WIDTH = 0.63;
	public static final double ROBOT_WHEEL_WIDTH = 0.15;
	private static final double ROBOT_WHEEL_CIRCUMFERENCE = 37.699;
	private static final int ROBOT_ENCODER_PULSES = 256;
	public static final double ROBOT_ENCODER_DPP = ROBOT_WHEEL_CIRCUMFERENCE / ROBOT_ENCODER_PULSES;

	// Gyro
	 public static final Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

	// Add hardware ports here with an id and port number.
	// Ex. ROBOT_HARDWARE_PORTS.put(<port id>, port number);
	private static HashMap<String, Integer> ROBOT_HARDWARE_PORTS = new HashMap<>();
	static {
		// Motors
		ROBOT_HARDWARE_PORTS.put("left_motor_1", 0);
		ROBOT_HARDWARE_PORTS.put("left_motor_2", 1);
		ROBOT_HARDWARE_PORTS.put("right_motor_1", 3);
		ROBOT_HARDWARE_PORTS.put("right_motor_2", 5);
		ROBOT_HARDWARE_PORTS.put("intake_motor_1", 6);
		ROBOT_HARDWARE_PORTS.put("intake_motor_2", 7);

<<<<<<< HEAD
		// Pistons
//		ROBOT_HARDWARE_PORTS.put("f_left_piston_1", 0);
//		ROBOT_HARDWARE_PORTS.put("f_left_piston_2", 1);
//		ROBOT_HARDWARE_PORTS.put("f_right_piston_1", 2);
//		ROBOT_HARDWARE_PORTS.put("f_right_piston_2", 3);
//		ROBOT_HARDWARE_PORTS.put("f_main_piston_1", 4);
//		ROBOT_HARDWARE_PORTS.put("f_main_piston_2", 5);
		ROBOT_HARDWARE_PORTS.put("intake_piston_1", 0);
		ROBOT_HARDWARE_PORTS.put("intake_piston_2", 1);
=======
		/* Flipper Subsystem
		ROBOT_HARDWARE_PORTS.put("f_left_piston_1", 0);
		ROBOT_HARDWARE_PORTS.put("f_left_piston_2", 1);
		ROBOT_HARDWARE_PORTS.put("f_right_piston_1", 2);
		ROBOT_HARDWARE_PORTS.put("f_right_piston_2", 3);
		ROBOT_HARDWARE_PORTS.put("f_main_piston_1", 4);
		ROBOT_HARDWARE_PORTS.put("f_main_piston_2", 5); */
		
		// Roller Subsystem
		ROBOT_HARDWARE_PORTS.put("roller_motor", 6);
		
		// Roller Piston/Raise Subsystem
		ROBOT_HARDWARE_PORTS.put("rp_forward", 7);
		ROBOT_HARDWARE_PORTS.put("rp_reverse", 8);
>>>>>>> branch 'master' of https://github.com/SarahCovey/Phoenix1797_2018.git

		// Encoders
		ROBOT_HARDWARE_PORTS.put("left_encoder_1", 0);
		ROBOT_HARDWARE_PORTS.put("left_encoder_2", 1);
		ROBOT_HARDWARE_PORTS.put("right_encoder_1", 2);
		ROBOT_HARDWARE_PORTS.put("right_encoder_2", 3);

//		// Ramp Subsystem
//		// ROBOT_HARDWARE_PORTS = new HashMap<String, Integer>();
//		ROBOT_HARDWARE_PORTS.put("ramp_piston_1", 0);
	}

	public static int getPort(String id) {
		return ROBOT_HARDWARE_PORTS.get(id);
	}

}
