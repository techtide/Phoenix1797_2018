

package org.usfirst.frc.team1797.robot;


import org.usfirst.frc.team1797.robot.commands.auto.AutoCrossBaseline13;
import org.usfirst.frc.team1797.robot.commands.auto.AutoCrossBaseline2Curved;
import org.usfirst.frc.team1797.robot.commands.auto.AutoDoNothing;
// import org.usfirst.frc.team1797.robot.commands.auto.AutoCrossBaseline2Curved;
import org.usfirst.frc.team1797.robot.subsystems.Drivetrain;
// import org.usfirst.frc.team1797.robot.subsystems.Flipper;
// import org.usfirst.frc.team1797.robot.subsystems.Ramp;
import org.usfirst.frc.team1797.robot.subsystems.Roller;
import org.usfirst.frc.team1797.robot.subsystems.RollerPiston;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final DriveTrain DRIVE_TRAIN = new DriveTrain();
	public static final Drivetrain DRIVE_TRAIN = new Drivetrain();
	public static final Roller ROLLER = new Roller();
	public static final RollerPiston ROLLER_PISTON = new RollerPiston();
	// public static final Flipper FLIPPER = new Flipper();
	// public static final Ramp RAMP = new Ramp();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	SendableChooser autonomousChooser;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
//		Just for one auto command.
//		autonomousCommand = new AutoCrossBaseline13();
		autonomousChooser = new SendableChooser();
		autonomousChooser.addDefault("Do Nothing (Default)", new AutoDoNothing());
		autonomousChooser.addObject("Cross Baseline 1 or 3", new AutoCrossBaseline13());
		autonomousChooser.addObject("Cross Baseline 2 Curved", new AutoCrossBaseline2Curved());
		SmartDashboard.putData("Autonomous Routine Selector", autonomousChooser);
		SmartDashboard.putBoolean( "IMU_Connected", RobotMap.gyro.isConnected());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		if (autonomousCommand != null)
			autonomousCommand.start();
		autonomousCommand = (Command) autonomousChooser.getSelected();
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
