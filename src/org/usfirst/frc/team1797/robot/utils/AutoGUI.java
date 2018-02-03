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