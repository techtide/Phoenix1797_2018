package org.usfirst.frc.team1797.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

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
	public static final VictorSP left1 = new VictorSP(0);
	public static final VictorSP left2 = new VictorSP(1);
	public static final VictorSP right1 = new VictorSP(1);
	public static final VictorSP right2 = new VictorSP(1);
	
	public static final SpeedControllerGroup left = new SpeedControllerGroup(left1, left2);
	public static final SpeedControllerGroup right = new SpeedControllerGroup(right1, right2);
}
