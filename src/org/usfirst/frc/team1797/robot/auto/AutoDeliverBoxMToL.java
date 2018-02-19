package org.usfirst.frc.team1797.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.*;

/**
 * @author techtide
 * @see The path of the different autonomous routines, on the Github routine.
 */

public class AutoDeliverBoxMToL extends CommandGroup {
    public AutoDeliverBoxMToL() {
    		// Here, the robot begins backwards and moves ~70 units backwards.
    		addSequential(new MoveStraight(Direction.BACKWARD, 0.5, 70));
    		// Turn right at an angle measure of approximately 90 degrees.
    		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
    		// Move ~81 units forward after this.
    		addSequential(new MoveStraight(Direction.FORWARD, 0.5, 81));
    		// Move right again, so then we can move backwards and hit the switch.
    		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
    		// Move backwards ~70 units.
    		addSequential(new MoveStraight(Direction.BACKWARD, 0.5, 70));
    }
}