package org.usfirst.frc.team1797.robot.testauto;

import java.util.List;
import java.util.ArrayList;

public class InstructionLoader {

	public static List<AutoInstruction> loadTestInst() {
		List<AutoInstruction> testInst = new ArrayList<>();
		
		testInst.add(new AutoInstruction("move", Direction.FORWARD, 0.5, 30));
		testInst.add(new AutoInstruction("turn", Direction.RIGHT, 0.5, 90));
		//testInst.add(new AutoInstruction("move", Direction.BACKWARD, 0.5, 30));
		
		return testInst;
	}
	
	public static List<AutoInstruction> loadMoveTurnInst() {
		List<AutoInstruction> testInst = new ArrayList<>();
		
		testInst.add(new AutoInstruction("move", Direction.FORWARD, 0.5, 30));
		testInst.add(new AutoInstruction("turn", Direction.RIGHT, 0.5, 90));
		//testInst.add(new AutoInstruction("move", Direction.BACKWARD, 0.5, 30));
		
		return testInst;
	}
	
}
