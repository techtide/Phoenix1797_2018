package org.usfirst.frc.team1797.robot.commands.auto;

//import org.usfirst.frc.team1797.robot.commands.ExtendRollerPiston;
//import org.usfirst.frc.team1797.robot.commands.ReverseRollerPiston;
//import org.usfirst.frc.team1797.robot.commands.RollerLeft;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.Direction;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.MoveStraight;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDeliverBoxRtoR extends CommandGroup {

    public AutoDeliverBoxRtoR() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    		addSequential(new MoveStraight(Direction.FORWARD, .75, 140));
    		addSequential(new TurnCommand(Direction.RIGHT, .5, 5));
//    		addSequential(new ExtendRollerPiston());
//    		addSequential(new RollerLeft());
//    		addSequential(new ReverseRollerPiston());
    }
}
