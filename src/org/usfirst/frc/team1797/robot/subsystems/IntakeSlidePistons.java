package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSlidePistons extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private DoubleSolenoid piston;
	
	public IntakeSlidePistons() {
		piston = new DoubleSolenoid(RobotMap.getPort("intake_slide_piston_1"), 
				RobotMap.getPort("intake_slide_piston_2"));
	}
	
	public void extend() {
		piston.set(DoubleSolenoid.Value.kForward);
	}
	public void retract() {
		piston.set(DoubleSolenoid.Value.kReverse);
	}
	public void stop() {
		piston.set(DoubleSolenoid.Value.kOff);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

