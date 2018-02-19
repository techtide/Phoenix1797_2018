package org.usfirst.frc.team1797.robot;

import org.usfirst.frc.team1797.robot.commands.auto.AutoDeliverBoxLeftRight;
import org.usfirst.frc.team1797.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1797.robot.subsystems.Flipper;
import org.usfirst.frc.team1797.robot.subsystems.IntakeMotors;
import org.usfirst.frc.team1797.robot.subsystems.IntakeWheelPistons;
import org.usfirst.frc.team1797.robot.subsystems.Ramp;

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
	public static final Drivetrain DRIVE_TRAIN = new Drivetrain();
	public static final IntakeMotors intakeMotors = new IntakeMotors();
	public static final IntakeWheelPistons intakePistons = new IntakeWheelPistons();
	public static final Ramp RAMP = new Ramp();
	public static final Flipper flipper = new Flipper();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	@SuppressWarnings("deprecation")
	
	SendableChooser autonomousChooser;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
// 		p = new PowerDistributionPanel();
		oi = new OI();
		autonomousChooser = new SendableChooser();
		RobotMap.gyro.reset();
		RobotMap.gyro.resetDisplacement();
		autonomousChooser.addDefault("Box L to R ", new AutoDeliverBoxLeftRight());
		// autonomousChooser.addDefault("box test", new TestDepositBox());
		
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
		//System.out.println("Left Distance: " + Robot.DRIVE_TRAIN.leftEncoder.getDistance()
		//	+ "Right Distance: " + Robot.DRIVE_TRAIN.rightEncoder.getDistance());
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