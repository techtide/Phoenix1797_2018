package org.usfirst.frc.team1797.robot.testauto;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class InstructionalAuto extends Command {

	private List<AutoInstruction> autoInstructions = new ArrayList<>();
	
    public InstructionalAuto(AutoCommands command) {
    		if(command == AutoCommands.TEST_COMMAND) {
			autoInstructions = InstructionLoader.loadTestInst();
		} else {
			autoInstructions = InstructionLoader.loadTestInst();
		}
    		requires(Robot.DRIVE_TRAIN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		for(AutoInstruction i : autoInstructions) {
			if(i.getInstructionName().equals("move")) {
				Scheduler.getInstance().add(new MoveStraight(i.getDirection(), i.getSpeed(), i.getDistance()));
			} else if(i.getInstructionName().equals("turn")) {
				Scheduler.getInstance().add(new TurnCommand(i.getDirection(), i.getSpeed(), i.getDistance()));
			}
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
