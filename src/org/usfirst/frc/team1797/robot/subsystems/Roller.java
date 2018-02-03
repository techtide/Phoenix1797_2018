package org.usfirst.frc.team1797.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final double MOTOR_SPEED = 1;
	
	private VictorSP motor1;
	
	public Roller() {
		motor1 = new VictorSP(0);
	}
	
	public void intake() {
		motor1.set(MOTOR_SPEED);
	}
	
	public void outtake() {
		motor1.set(-MOTOR_SPEED);
	}
	
	public void stop() {
		motor1.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

