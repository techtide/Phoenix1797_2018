package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ramp extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private DoubleSolenoid pistonOne, pistonTwo, pistonThree;
	
	private boolean isOneExtended, isTwoExtended, isThreeExtended;
	
	private double lastActuationOne, lastActuationTwo, lastActuationThree;
	
	private long pistonOneActuation, pistonTwoActuation, pistonThreeActuation; 
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    		pistonOne = new DoubleSolenoid(RobotMap.getPort("ramp_piston_1"), RobotMap.getPort("ramp_piston_1"));
		pistonTwo = new DoubleSolenoid(RobotMap.getPort("ramp_piston_2"), RobotMap.getPort("ramp_piston_2"));
		pistonThree = new DoubleSolenoid(RobotMap.getPort("ramp_piston_3"), RobotMap.getPort("right_piston_3"));
    }
    
    public boolean isOneExtended() {
    		return isOneExtended;
    }
	
    public boolean isTwoExtended() {
	    	return isTwoExtended;
	}
	
	public boolean isThirdExtended() {
		return isThreeExtended;
	}
	
	public void extendPistonOne() {
		pistonOne.set(DoubleSolenoid.Value.kForward);
		lastActuationOne = System.currentTimeMillis();
		isOneExtended = true;
	}
	
	public void stopPistonOne() {
		pistonOne.set(DoubleSolenoid.Value.kOff);
		lastActuationOne = Long.MAX_VALUE;
	}
	
	public void extendPistonTwo() {
		pistonTwo.set(DoubleSolenoid.Value.kForward);
		lastActuationTwo = System.currentTimeMillis();
		isTwoExtended = true;
	}
	
	public void stopPistonTwo() {
		pistonOne.set(DoubleSolenoid.Value.kOff);
		lastActuationTwo = Long.MAX_VALUE;
	}
	
	public void extendPistonThree() {
		pistonOne.set(DoubleSolenoid.Value.kForward);
		lastActuationOne = System.currentTimeMillis();
		isOneExtended = true;
	}
	
	public void stopPistonThree() {
		pistonOne.set(DoubleSolenoid.Value.kOff);
		lastActuationOne = Long.MAX_VALUE;
	}
	
	public long getPistonOneActuation() {
	 	return pistonOneActuation;
	}
	
	public long getPistonTwoActuation() {
	 	return pistonTwoActuation;
	}
	
	public long getPistonThirdActuation() {
	 	return pistonThreeActuation;
	}
	
	public void retractPistonOne() {
		pistonOne.set(DoubleSolenoid.Value.kReverse);
		lastActuationOne = System.currentTimeMillis();
		isOneExtended = false;
	}
	
	public void retractPistonTwo() {
		pistonTwo.set(DoubleSolenoid.Value.kReverse);
		lastActuationTwo = System.currentTimeMillis();
		isTwoExtended = false;
	}
	
	public void retractPistonThree() {
		pistonThree.set(DoubleSolenoid.Value.kReverse);
		lastActuationThree = System.currentTimeMillis();
		isThreeExtended = false;
	}
	
}