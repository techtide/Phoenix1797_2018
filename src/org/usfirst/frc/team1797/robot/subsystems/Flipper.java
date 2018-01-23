package org.usfirst.frc.team1797.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flipper extends Subsystem {
	
	private DoubleSolenoid leftPiston, rightPiston;
	private long lastActuationLeft, lastActuationRight;
	
	private boolean isLeftExtended, isRightExtended;
	
	public Flipper() {
		leftPiston = new DoubleSolenoid(0, 1);
		rightPiston = new DoubleSolenoid(2, 3);
		lastActuationLeft = Long.MAX_VALUE;
		lastActuationRight = Long.MAX_VALUE;
	}
	
	public boolean isLeftExtended() {
		return isLeftExtended;
	}

	public boolean isRightExtended() {
		return isRightExtended;
	}

	public void stopLeft() {
		leftPiston.set(DoubleSolenoid.Value.kOff);
		lastActuationLeft = Long.MAX_VALUE;
	}
	
	public void extendLeft() {
		leftPiston.set(DoubleSolenoid.Value.kForward);
		lastActuationLeft = System.currentTimeMillis();
		isLeftExtended = true;
	}
	
	public void retractLeft() {
		leftPiston.set(DoubleSolenoid.Value.kReverse);
		lastActuationLeft = System.currentTimeMillis();
		isLeftExtended = false;
	}
	
	public void stopRight() {
		rightPiston.set(DoubleSolenoid.Value.kOff);
		lastActuationRight = Long.MAX_VALUE;
	}
	
	public void extendRight() {
		rightPiston.set(DoubleSolenoid.Value.kForward);
		lastActuationRight = System.currentTimeMillis();
		isRightExtended = true;
	}
	
	public void retractRight() {
		rightPiston.set(DoubleSolenoid.Value.kReverse);
		lastActuationRight = System.currentTimeMillis();
		isRightExtended = false;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public long getLastActuationLeft() {
    		return lastActuationLeft;
    }
    
    public long getLastActuationRight() {
		return lastActuationRight;
}
}

