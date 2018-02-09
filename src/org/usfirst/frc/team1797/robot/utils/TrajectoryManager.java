package org.usfirst.frc.team1797.robot.utils;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

/**
 *
 */
public class TrajectoryManager {
	private List<File> folder;
	private HashMap<String, Trajectory> trajectories;
	
	public TrajectoryManager() {
		File x = new File("/trajectories");
		folder = Arrays.asList(x.listFiles());
		for(File f : folder) {
			trajectories.put(f.getName(), Pathfinder.readFromCSV(f));
		}
	}
	
	public Trajectory readPointsData(String trajectoryName) {
		return trajectories.get(trajectoryName);
	}
	
	public void writeRioFile(String fileName, Trajectory traj) {
		Pathfinder.writeToCSV(new File("/trajectories/" + fileName), traj);
		System.out.println("File has been written.");
	}
}