package org.usfirst.frc.team1797.robot.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.commands.ExtendRollerPiston;
import org.usfirst.frc.team1797.robot.commands.RollerRight;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.AutoRollerRight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestDepositBox extends CommandGroup {

    public TestDepositBox() {
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
    	requires(Robot.ROLLER);
    	addSequential(new ExtendRollerPiston());
    	long lastAct = System.currentTimeMillis();
    	addSequential(new AutoRollerRight());
    }
}
