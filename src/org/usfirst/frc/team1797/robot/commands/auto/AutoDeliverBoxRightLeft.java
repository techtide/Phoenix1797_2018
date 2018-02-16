package org.usfirst.frc.team1797.robot.commands.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.Direction;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.MoveStraight;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDeliverBoxRightLeft extends CommandGroup {

    public AutoDeliverBoxRightLeft() {
    		/*MOVE 80,
         * turn right 20 deg
         * move 29.238
         * turn left 20 deg
         * move 121.26
         * turn 90 deg left
         * move forward 192.50
         * turn left 90 deg
         * move forward 60.735 */
    	
       requires(Robot.DRIVE_TRAIN);
       addSequential(new MoveStraight(Direction.FORWARD, 0.8, 228.735));
       addSequential(new TurnCommand(Direction.RIGHT, 0.5, 250));
       addSequential(new MoveStraight(Direction.FORWARD, 0.8, 192.5));
       addSequential(new TurnCommand(Direction.RIGHT, 0.5, 190));
       addSequential(new MoveStraight(Direction.FORWARD, 0.8, 60.735));
//       addSequential(new ExtendRollerPiston());
//       addSequential(new RollerLeft());
//       addSequential(new ReverseRollerPiston());
    }
}
