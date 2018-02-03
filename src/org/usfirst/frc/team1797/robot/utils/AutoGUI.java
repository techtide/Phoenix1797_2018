<<<<<<< HEAD
/**
 * 
 */
package org.usfirst.frc.team1797.robot.utils;

/**
 * @author Arman
 * This script will serve as an alternate GUI in the case that SmartDashboard fails on us.
 */
public class AutoGUI {
	// Abandoned till further uses, see my changes in auto. I just need to check if it works.
}
=======
/**
 * 
 */
package org.usfirst.frc.team1797.robot.utils;

import java.util.HashMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Arman 
 * An alternate GUI for SmartDashboard, which displays the autonomous commands.
 */

public class AutoGUI {
	private HashMap<String, Command> autonomousCommandList = new HashMap<>();
	
	public void listAsCommand(String routineName, Command routineCommand) {
		autonomousCommandList.put(routineName, routineCommand);
	}
	
	public void removeCommand(String routineName) {
		autonomousCommandList.remove(routineName);
	}
}
>>>>>>> branch 'master' of https://github.com/SarahCovey/Phoenix1797_2018.git
