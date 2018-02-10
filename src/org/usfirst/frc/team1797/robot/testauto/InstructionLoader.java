package org.usfirst.frc.team1797.robot.testauto;

import java.util.List;
import java.util.ArrayList;

public class InstructionLoader {

	public static List<AutoInstruction> loadTestInst() {
		List<AutoInstruction> testInst = new ArrayList<>();
		
		testInst.add(new AutoInstruction("move", Direction.FORWARD, 0.75, 50));
		testInst.add(new AutoInstruction("turn", Direction.RIGHT, 0.5, 90));
		testInst.add(new AutoInstruction("move", Direction.FORWARD, 0.75, 50));
		
		return testInst;
	}
	
}
