package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final VictorSP left1 = new VictorSP(0);
	private final VictorSP left2 = new VictorSP(1);
	private final VictorSP right1 = new VictorSP(2);
	private final VictorSP right2 = new VictorSP(3);
	
	private final SpeedControllerGroup left = new SpeedControllerGroup(left1, left2);
	private final SpeedControllerGroup right = new SpeedControllerGroup(right1, right2);
	
	private final DifferentialDrive DifferentialDrive = new DifferentialDrive(left, right);

	public void arcadeDrive(double x, double z){
		DifferentialDrive.arcadeDrive(x, z);
	}
	
	public void stopDrive() {
		DifferentialDrive.stopMotor();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
