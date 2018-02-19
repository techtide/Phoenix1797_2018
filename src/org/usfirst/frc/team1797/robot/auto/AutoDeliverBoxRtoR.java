package org.usfirst.frc.team1797.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.commands.FlipCommand;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.*;;

/**
 * @author techtide
 * @see The path of the different autonomous routines, on the Github routine.
 */

public class AutoDeliverBoxRToR extends CommandGroup {
	public AutoDeliverBoxRToR() {
		// Move forward ~150 units till the robot is past the switch.
		addSequential(new MoveStraight(Direction.FORWARD, 0.5, 150));
		// Now, turn at a right angle and hit the fence opposite the switch to wall align with it.
		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
		// Reverse so the robot hits the fence.
		addSequential(new MoveStraight(Direction.BACKWARD, 0.5, 85.25));
		// Deliver the box and throw it backwards.
		addSequential(new FlipCommand());
	}
}