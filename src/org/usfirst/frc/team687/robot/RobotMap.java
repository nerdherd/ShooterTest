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
	public static int eject_port = 2;
	
	//Tuned Constants
	public static double shooter_kP = 0.1100;
	public static double shooter_kI = 0.0;	
	public static double shooter_kD = 0.0;	
	public static double shooter_kF = 0.025;
	
	public static double eject_kP = 0.00625;
	public static double eject_kI = 0.0;	
	public static double eject_kD = 0.0;
	public static double eject_kF = 0.02875;
	
	//Desired Values
	public static double desired_shooter_RPM = 3432;
	public static double desired_ejector_RPM = 2000;
	//BANG BANG TESTING VALS
//	public static double desiredTestRPM = 1500;
}
