package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flipper extends Subsystem {
	
	private DoubleSolenoid leftPiston, rightPiston, mainPiston;
	private long lastActuationLeft, lastActuationRight, lastActuationMain;
	
	private boolean isLeftExtended, isRightExtended;
	public boolean isMainExtended;
	
	public Flipper() {
		leftPiston = new DoubleSolenoid(RobotMap.getPort("f_left_piston_1"), RobotMap.getPort("f_left_piston_2"));
		rightPiston = new DoubleSolenoid(RobotMap.getPort("f_right_piston_1"), RobotMap.getPort("f_right_piston_2"));
		mainPiston = new DoubleSolenoid(RobotMap.getPort("f_main_piston_1"), RobotMap.getPort("f_main_piston_2"));
		lastActuationLeft = Long.MAX_VALUE;
		lastActuationRight = Long.MAX_VALUE;
		lastActuationMain = Long.MAX_VALUE;
		isLeftExtended = false;
		isRightExtended = false;
		isMainExtended = false;
	}
	
	public boolean isLeftExtended() {
		return isLeftExtended;
	}

	public boolean isRightExtended() {
		return isRightExtended;
	}
	
	public void stopMain() {
		mainPiston.set(DoubleSolenoid.Value.kOff);
		lastActuationMain = Long.MAX_VALUE;
	}
	
	public void extendMain() {
		mainPiston.set(DoubleSolenoid.Value.kForward);
		lastActuationMain = System.currentTimeMillis();
	}
	
	public void retractMain() {
		mainPiston.set(DoubleSolenoid.Value.kReverse);
		lastActuationMain = System.currentTimeMillis();
		isMainExtended = false;
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
    
    public long getLastActuationMain() {
		return lastActuationMain;
}
    
    public long getLastActuationRight() {
		return lastActuationRight;
}
}

