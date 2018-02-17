package org.usfirst.frc.team1797.robot;

<<<<<<< HEAD
import org.usfirst.frc.team1797.robot.commands.auto.AutoCrossBaseline2;
import org.usfirst.frc.team1797.robot.subsystems.Drivetrain;
=======
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.usfirst.frc.team1797.robot.auto.AutoCrossBaseline13;
import org.usfirst.frc.team1797.robot.auto.AutoCrossBaseline2;
import org.usfirst.frc.team1797.robot.auto.AutoDoNothing;
import org.usfirst.frc.team1797.robot.commands.RollerLeft;
import org.usfirst.frc.team1797.robot.commands.RollerRight;
// import org.usfirst.frc.team1797.robot.commands.auto.AutoCrossBaseline2Curved;
import org.usfirst.frc.team1797.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1797.robot.subsystems.IntakeMotors;
>>>>>>> 8186c012937798cf292664f33738833fba748948
import org.usfirst.frc.team1797.robot.subsystems.Roller;
import org.usfirst.frc.team1797.robot.subsystems.RollerPiston;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
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

	public static final Drivetrain DRIVE_TRAIN = new Drivetrain();
	public static final Roller ROLLER = new Roller();
	// public static final IntakeMotors intakeMotors = new IntakeMotors();
	//public static final IntakePistons intakePistons = new IntakePistons();
	// public static final Roller ROLLER = new Roller();
	// public static final RollerPiston ROLLER_PISTON = new RollerPiston();
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
		System.out.println("testing 2 see if code is working");
		oi = new OI();
		autonomousChooser = new SendableChooser();
		
<<<<<<< HEAD
		autonomousChooser.addDefault("test", new AutoCrossBaseline2());
=======
//		// plez jus dis unce
//		TrajectoryManager manager = new TrajectoryManager();
//		System.out.println(System.getProperty("user.dir"));
//		File f = new File("/Users/Arman/Trajectories");
//		List<File> list = Arrays.asList(f.listFiles());
//		System.out.println("List size: " +list.size());
//		for(int i = 0; i < list.size(); i++) {
//			manager.waypointCSVToTrajectory(list.get(i));
//			System.out.println(Arrays.deepToString(manager.folder));
//		}
		
		
		// Please stay away from the architecture unless it does not work; only use Routine enums and not strings. Kthx. ~ab
		// autonomousChooser.addObject("Deposit Single Box 13 [Left]", new AutoRunner(AutoRunner.Routines.DEPOSITSINGLEBOX13L));
		// autonomousChooser.addObject("Deposit Single Box 13 [Right]", new AutoRunner(AutoRunner.Routines.DEPOSITSINGLEBOX13L));
//		autonomousChooser.addObject("Autonomous Do Nothing", new AutoDoNothing());
//		autonomousChooser.addDefault("Autonomous Cross Baseline 13", new AutoCrossBaseline13());
//		autonomousChooser.addObject("Autonomous Cross Baseline 2 Curved", new AutoRunner(AutoRunner.Routines.BASELINECURVED2));
//		autonomousChooser.addObject("Autonomous Deposit Single Box 1", new AutoRunner(AutoRunner.Routines.DEPOSITBOX1));
//		autonomousChooser.addObject("Autonomous Deposit Single Box 2", new AutoRunner(AutoRunner.Routines.DEPOSITBOX2));
//		autonomousChooser.addObject("Autonomous Deposit Single Box 3", new AutoRunner(AutoRunner.Routines.DEPOSITBOX3));
		//autonomousChooser.addDefault("test", new AutoCrossBaseline2());
		autonomousChooser.addDefault("crossbaseline2", new AutoCrossBaseline2());
>>>>>>> 8186c012937798cf292664f33738833fba748948
		
		SmartDashboard.putData("Autonomous Routine Selector", autonomousChooser);
		// SmartDashboard.putBoolean("Gyro Status", RobotMap.gyro.isConnected());
		SmartDashboard.putString("Gyro Status", RobotMap.gyro.isConnected()? "connected":"not connected");
		SmartDashboard.putNumber("Gyro Angle (deg)", RobotMap.gyro.getAngle());
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
		autonomousCommand = (Command) autonomousChooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		System.out.println("Left Distance: " + Robot.DRIVE_TRAIN.leftEncoder.getDistance()
					  + "Right Distance: " + Robot.DRIVE_TRAIN.rightEncoder.getDistance());
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