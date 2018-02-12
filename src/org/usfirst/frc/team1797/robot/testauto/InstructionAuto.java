package org.usfirst.frc.team1797.robot.testauto;

import java.util.List;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class InstructionAuto extends CommandGroup {

    public InstructionAuto() {
    		requires(Robot.DRIVE_TRAIN);
    		
    		List<AutoInstruction> autoInstructions = InstructionLoader.loadMoveTurnInst();
    		
    		for(AutoInstruction i : autoInstructions) {
    			if(i.getInstructionName().equals("move")) {
    				addSequential(new MoveStraight(i.getDirection(), i.getSpeed(), i.getDistance()));
    			} else if(i.getInstructionName().equals("turn")) {
    				addSequential(new TurnCommand(i.getDirection(), i.getSpeed(), i.getDistance()));
    			}
    		}
    }
}
