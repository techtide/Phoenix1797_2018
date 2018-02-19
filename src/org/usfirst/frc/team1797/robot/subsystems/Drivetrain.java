package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;
import org.usfirst.frc.team1797.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final VictorSP left1 = new VictorSP(RobotMap.getPort("left_motor_1"));
	private final VictorSP left2 = new VictorSP(RobotMap.getPort("left_motor_2"));
	private final VictorSP right1 = new VictorSP(RobotMap.getPort("right_motor_1"));
	private final VictorSP right2 = new VictorSP(RobotMap.getPort("right_motor_2"));
	
//	private final WPI_VictorSPX left1 = new WPI_VictorSPX(RobotMap.getPort("left_motor_1"));
//	private final WPI_VictorSPX right1 = new WPI_VictorSPX(RobotMap.getPort("right_motor_1"));
//	private final WPI_VictorSPX left2 = new WPI_VictorSPX(RobotMap.getPort("left_motor_2"));
//	private final WPI_VictorSPX right2 = new WPI_VictorSPX(RobotMap.getPort("right_motor_2"));
	
	private final SpeedControllerGroup left = new SpeedControllerGroup(left1, left2);
	private final SpeedControllerGroup right = new SpeedControllerGroup(right1, right2);
	
	private final DifferentialDrive DifferentialDrive = new DifferentialDrive(left, right);
	
	private double drive_kp;
	
	
	@SuppressWarnings("deprecation")
	// public final RobotDrive robotDrive = new RobotDrive(left, right);
	
	// encoders
	public final Encoder leftEncoder = new Encoder(RobotMap.getPort("left_encoder_1"),
			RobotMap.getPort("left_encoder_2"), false, Encoder.EncodingType.k4X);
	public final Encoder rightEncoder = new Encoder(RobotMap.getPort("right_encoder_1"),
			RobotMap.getPort("right_encoder_2"), false, Encoder.EncodingType.k4X);

	public Drivetrain() {
		resetEncoders();
		
		leftEncoder.setMaxPeriod(.1);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(RobotMap.ROBOT_ENCODER_DPP);
		leftEncoder.setReverseDirection(false);
		leftEncoder.setSamplesToAverage(7);
		leftEncoder.reset();
		
		rightEncoder.setMaxPeriod(.1);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(RobotMap.ROBOT_ENCODER_DPP);
		rightEncoder.setReverseDirection(true);
		rightEncoder.setSamplesToAverage(7);
		leftEncoder.reset();
		
		drive_kp = 0.01;
		
//		left1.setSafetyEnabled(false);
//		left2.setSafetyEnabled(false);
//		right1.setSafetyEnabled(false);
//		right2.setSafetyEnabled(false);
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public void arcadeDrive(double x, double z){
		DifferentialDrive.arcadeDrive(x, z);
	}
	public void tankDrive(double leftSpeed, double rightSpeed) {
		DifferentialDrive.tankDrive(leftSpeed, rightSpeed);
	}
	
	public void stopDrive() {
		DifferentialDrive.stopMotor();
	}
	
	public double getAverageEncoderDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}
	
	public double getLeftEncoderDistance() {
		return leftEncoder.getDistance();
	}
	
	public double getRightEncoderDistance() {
		return rightEncoder.getDistance();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    		setDefaultCommand(new DriveCommand());
    }
    
    public void errorCorrectionDrive(double moveValue) {
    		double left = leftEncoder.getRate();
		double right = rightEncoder.getRate();
		double error = right - left;
		double result = drive_kp * error;
		DifferentialDrive.tankDrive(moveValue + result, moveValue - result);
    }
    
    public void errorConnectionTurn(double tr1, double tr2) {
		double left = leftEncoder.getRate();
		double right = rightEncoder.getRate();
		double error = right - left;
		double result = drive_kp * error;
		DifferentialDrive.tankDrive(tr1 + result, tr2 - result);
    }
}