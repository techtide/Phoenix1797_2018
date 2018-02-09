package org.usfirst.frc.team1797.robot.utils;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

/**
 *
 */
public class TrajectoryManager {
	private List<File> folder;
	private HashMap<String, Trajectory> trajectories;
	
	public TrajectoryManager() {
		// TODO Auto-generated constructor stub
		Map<String, String> env = System.getenv();
		File x = new File(env.get("HOME") + "/trajectories");
		folder = Arrays.asList(x.listFiles());
		for(File f : folder) {
			trajectories.put(f.getName(), Pathfinder.readFromCSV(f));
		}
	}
	
	private Routines fileToRoutine(String name) {
		return AutoRunner.Routines.valueOf(name);
	}
	
	public Trajectory readPointsData(AutoRunner.Routines routine, String direction) {
		return trajectories.get(routine.toString() + direction);
	}
	
	public void writeRioFile(File fileToWrite, Trajectory traj) {
		Pathfinder.writeToCSV(fileToWrite, traj);
		System.out.println("File has been written.");
	}
}