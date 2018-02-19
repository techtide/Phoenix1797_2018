package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.commands.teleoputils.RampDeploy;
import org.usfirst.frc.team1797.robot.commands.teleoputils.RampLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RampCommand extends CommandGroup {

    public RampCommand() {
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
    	
    	if(Robot.RAMP.isDeployed) {
    		addSequential(new RampLift());
    	} else {
    		addSequential(new RampDeploy());
    	}
    }
}
