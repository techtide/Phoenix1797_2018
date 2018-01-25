package org.usfirst.frc.team1797.robot;

import java.util.HashMap;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int DRIVER_FORWARD_AXIS = 1;
	public static final int DRIVER_HORIZONTAL_AXIS = 3;
	public static final int DRIVER_CONTROLLER_PORT = 0;
	public static final int OPERATOR_CONTROLLER_PORT = 1;
	
	public static final double DRIVETRAIN_SENSITIVITY = 0.25;
	
	public static final double FLIPPER_PISTON_TIME = 1000; // in milliseconds
	
	public static HashMap<String, Integer> DRIVETRAIN_MOTOR_PORTS = new HashMap<>();
	static
    {
		DRIVETRAIN_MOTOR_PORTS = new HashMap<String, Integer>();
		DRIVETRAIN_MOTOR_PORTS.put("left_motor_1", 0);
		DRIVETRAIN_MOTOR_PORTS.put("left_motor_2", 1);
		DRIVETRAIN_MOTOR_PORTS.put("right_motor_1", 2);
		DRIVETRAIN_MOTOR_PORTS.put("right_motor_2", 3);
    }
	
	public static HashMap<String, Integer> FLIPPER_PISTON_PORTS = new HashMap<>();
	static
    {
		DRIVETRAIN_MOTOR_PORTS = new HashMap<String, Integer>();
		DRIVETRAIN_MOTOR_PORTS.put("left_piston_1", 0);
		DRIVETRAIN_MOTOR_PORTS.put("left_piston_2", 1);
		DRIVETRAIN_MOTOR_PORTS.put("right_piston_1", 2);
		DRIVETRAIN_MOTOR_PORTS.put("right_piston_2", 3);
    }
	
}
