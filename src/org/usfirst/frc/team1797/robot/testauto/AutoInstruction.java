package org.usfirst.frc.team1797.robot.testauto;

public class AutoInstruction {

	private String instructionName;
	private Direction direction;
	private double speed;
	private int distance;
	
	public AutoInstruction(String instructionName, Direction direction, double speed, int distance) {
		super();
		this.instructionName = instructionName;
		this.direction = direction;
		this.speed = speed;
		this.distance = distance;
	}

	public String getInstructionName() {
		return instructionName;
	}

	public Direction getDirection() {
		return direction;
	}

	public double getSpeed() {
		return speed;
	}

	public int getDistance() {
		return distance;
	}
	
}
