/**
 * 
 */
package org.usfirst.frc.team1797.robot.utils;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * @author Arman
 * Quaternions are the native unit of the sensor. 
 */

public class QuaternionAssist {
	
	private char[] getLatestGameData() {
		return DriverStation.getInstance().getGameSpecificMessage().toLowerCase().toCharArray();
	}
}
