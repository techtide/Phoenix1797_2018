package org.usfirst.frc.team1797.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.*;

/**
 * @author techtide
 * @see The path of the different autonomous routines, on the Github routine.
 * @
 */

public class AutoDeliverBoxLToR extends CommandGroup {
    public AutoDeliverBoxLToR() {
    		// Move forward ~209 units.
    		addSequential(new MoveStraight(Direction.FORWARD, 0.5, 209));
    		// Turn approximately 90 degrees to the right.
    		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
    		// Move forward ~148 units.
    		addSequential(new MoveStraight(Direction.FORWARD, 0.5, 148));
    		// Turn right approximately 90 degrees to the right.
    		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
    		// Move forward ~41 units.
    		addSequential(new MoveStraight(Direction.FORWARD, 0.5, 41));
    	}
}