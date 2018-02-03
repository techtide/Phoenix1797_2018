/**
 * 
 */
package org.usfirst.frc.team1797.robot.utils;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * @author greenie
 * Displays a map of the current game and annotates game info in the map.
 */

public class MapViewer {
	
	private char[] getLatestGameData() {
		return DriverStation.getInstance().getGameSpecificMessage().toLowerCase().toCharArray();
	}
}
