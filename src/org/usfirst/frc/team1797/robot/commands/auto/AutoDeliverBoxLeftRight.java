package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.Direction;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.MoveStraight;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDeliverBoxLeftRight extends CommandGroup {

    public AutoDeliverBoxLeftRight() {
        /*MOVE 228.735 
         * turn 90 deg right
         * move forward 192
         * turn right 90 deg
         * move forward 60.735 */
    	
    		requires(Robot.DRIVE_TRAIN);
    		addSequential(new MoveStraight(Direction.FORWARD, 0.8, 228.735));
    		addSequential(new TurnCommand(Direction.RIGHT, 0.75, 90));
    		addSequential(new MoveStraight(Direction.FORWARD, 0.8, 192));
    		addSequential(new TurnCommand(Direction.RIGHT, 0.75, 90));
    		addSequential(new MoveStraight(Direction.FORWARD, 0.8, 60.735));
    }
}
