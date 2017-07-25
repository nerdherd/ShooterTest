package org.usfirst.frc.team687.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Actuator Ports
	public static int flywheel_port = 1;
	public static int eject_port = 0;
	
	//Tuned Constants
	public static double shooter_kP = .1100;
	public static double shooter_kD = 0.0;	
	public static double shooter_kF = 0.025;
	
	//Desired Values
	public static double desired_shooter_RPM = 3425;
	public static double percent_tolerance = 0.001;
	public static double eject_speed = -0.5;
	
	//TESTING VALS
	public static double testing_incr = 0.0001;
	public static double desiredTestRPM = 1500; //BANG BANG
}
