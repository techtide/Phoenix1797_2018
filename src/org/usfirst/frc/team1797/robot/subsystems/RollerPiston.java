package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RollerPiston extends Subsystem {
	
	private DoubleSolenoid piston;
	private long lastActuation;
	public boolean isUp, isDown;
	
	public RollerPiston() {
		piston = new DoubleSolenoid(RobotMap.getPort("rp_forward"), RobotMap.getPort("rp_reverse"));
		lastActuation = Long.MAX_VALUE;
		isUp = false;
		isDown = true;
	}
	
	public void raise() {
		piston.set(DoubleSolenoid.Value.kForward);
		lastActuation = System.currentTimeMillis() - lastActuation;
	}
	
	public void reverse() {
		piston.set(DoubleSolenoid.Value.kReverse);
		lastActuation = System.currentTimeMillis() - lastActuation;
	}
	
	public void stop() {
		piston.set(DoubleSolenoid.Value.kOff);
		lastActuation = Long.MAX_VALUE;
	}
	
	public long getLastActuation() {
		return lastActuation;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

