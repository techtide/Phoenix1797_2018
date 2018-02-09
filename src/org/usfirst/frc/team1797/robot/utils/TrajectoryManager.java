package org.usfirst.frc.team1797.robot.utils;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.commands.auto.AutoRunner;
import org.usfirst.frc.team1797.robot.commands.auto.AutoRunner.Routines;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

/**
 *
 */
public class TrajectoryManager {
	public File[] folder;
	private HashMap<String, File> trajectories;
	
	public TrajectoryManager() {
		// TODO Auto-generated constructor stub
		trajectories = new HashMap<>();
		File x = new File("/home/lvuser/trajectories/");
		
		folder = x.listFiles();
//		
//		/* 
//		 * The CSV files need to be on the roboRIO, and need to include the alliance number and direction (at the end).
//		 * For instance, it could be "BASELINECURVED2L"; the title also needs to be in all capitals.
//		*/
//		
		for(File f : folder) {
			trajectories.put(f.getName(), f);
		}
		System.out.println(trajectories);
	}
	
	public Trajectory getTrajectoryFromFile(String trajectoryName) {
		return Pathfinder.readFromCSV(trajectories.get(trajectoryName));
	}
	// uncomment for writing files, etc
//	public void waypointCSVToTrajectory(File waypointCSV) {
//		Trajectory trajectory = Pathfinder.readFromCSV(waypointCSV);
//		Trajectory traj = new PathfinderUtils(trajectory, Robot.DRIVE_TRAIN.leftEncoder, Robot.DRIVE_TRAIN.rightEncoder).getInitialTrajectory();
//		File f = new File("/home/lvuser/trajectories/" + waypointCSV.getName());
//		Pathfinder.writeToCSV(f, traj);
//		System.out.println("File has been written as: " + f.getName() + ", at the location: " + f.getAbsolutePath() + ".");
//	}
	
	/*public void saveTrajectoryCSV(File trajectoryCSV) {
		File f = new File("/trajectorycsv/");
		File folder[] = f.listFiles();
		for(File file : folder) {
			Files.copy("", out);
		}
	} */
}