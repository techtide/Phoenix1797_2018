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

	private DoubleSolenoid pistonOne;
			
	private long lastActuation;
	
	public Ramp() {
		pistonOne = new DoubleSolenoid(RobotMap.getPort("ramp_piston_1"),
				RobotMap.getPort("ramp_piston_2"));
//		pistonTwo = new DoubleSolenoid(RobotMap.getPort("ramp_piston_2"),
//				RobotMap.getPort("ramp_piston_2"));
//		pistonThree = new DoubleSolenoid(RobotMap.getPort("ramp_piston_3"),
//				RobotMap.getPort("right_piston_3"));
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public long getLastActuation() {
    	return lastActuation;
    }
    public void extend() {
    	pistonOne.set(DoubleSolenoid.Value.kForward);
//    	pistonTwo.set(DoubleSolenoid.Value.kForward);
//    	pistonThree.set(DoubleSolenoid.Value.kForward);
    }
    public void retract() {
    	pistonOne.set(DoubleSolenoid.Value.kReverse);
//    	pistonTwo.set(DoubleSolenoid.Value.kReverse);
//    	pistonThree.set(DoubleSolenoid.Value.kReverse);
    }
    public void stop() {
    	pistonOne.set(DoubleSolenoid.Value.kOff);
//    	pistonTwo.set(DoubleSolenoid.Value.kOff);
//    	pistonThree.set(DoubleSolenoid.Value.kOff);
    }
}