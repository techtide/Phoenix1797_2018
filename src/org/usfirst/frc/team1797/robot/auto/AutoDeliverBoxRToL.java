package org.usfirst.frc.team1797.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.*;

/**
 * @author techtide
 * @see The path of the different autonomous routines, on the Github routine.
 */

public class AutoDeliverBoxRToL extends CommandGroup {
    public AutoDeliverBoxRToL() {
    		// Move straight ~209 units.
    		addSequential(new MoveStraight(Direction.FORWARD, 0.6, 30));
    		// Turn approximately 90 degrees left.
    		addSequential(new TurnCommand(Direction.LEFT, 0.6, 90));
    		// Move forward  ~148 units.
    		addSequential(new MoveStraight(Direction.FORWARD, 0.6, 10));
    		// Turn approximately 90 degrees to the left.
    		addSequential(new TurnCommand(Direction.LEFT, 0.6, 90));
    		// Move forward ~41 units.
    		addSequential(new MoveStraight(Direction.FORWARD, 0.6, 10));
    }
}