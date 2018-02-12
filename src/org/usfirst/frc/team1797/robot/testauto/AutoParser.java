package org.usfirst.frc.team1797.robot.testauto;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

public class AutoParser extends CommandGroup {
	
	List<AutoInstruction> autoInstructions = new ArrayList<>();
	
	public AutoParser(AutoCommands command) {
		if(command == AutoCommands.TEST_2_COMMAND) {
			autoInstructions = InstructionLoader.loadMoveTurnInst();
		} else if(command == AutoCommands.TEST_COMMAND) {
			autoInstructions = InstructionLoader.loadTestInst();
		}
	}
	
	public void runInstructions() {
		for(AutoInstruction i : autoInstructions) {
			if(i.getInstructionName().equals("move")) {
				Scheduler.getInstance().add(new MoveStraight(i.getDirection(), i.getSpeed(), i.getDistance()));
			} else if(i.getInstructionName().equals("turn")) {
				Scheduler.getInstance().add(new TurnCommand(i.getDirection(), i.getSpeed(), i.getDistance()));
			}
		}
	}
	
}
