package org.usfirst.frc.team1797.robot.auto;

import org.usfirst.frc.team1797.robot.commands.auto.autoutils.Direction;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.MoveStraight;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossBaseline2 extends CommandGroup {
    public AutoCrossBaseline2() {
    		// Cross the baseline from the second alliance position.
	    	addSequential(new MoveStraight(Direction.FORWARD, .75, 50));
//	    	addSequential(new TurnCommand(Direction.RIGHT, .5, 85));
//	    	addSequential(new MoveStraight(Direction.FORWARD, .75, 25));
    }
}