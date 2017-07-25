package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team687.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	private Joystick left_joystick, right_joystick, articulation_joystick;
	private Button initiate_shooter, shoot;
	
	public OI(){
		//Joy Sticks
//		left_joystick = new Joystick(0);
//		right_joystick = new Joystick(1);
		articulation_joystick = new Joystick(2);
		
		//Buttons
		initiate_shooter = new JoystickButton(articulation_joystick, 5);
		shoot = new JoystickButton(articulation_joystick, 1);
		
		//Commands
		initiate_shooter.whenPressed(new PIDShootInitialize());
		initiate_shooter.whenReleased(new EndShooter());
		shoot.whenPressed(new ShootCommand());
		shoot.whenReleased(new EndEjector());
		
		//Test
		
		
	}
	
	public double getArticJoyY() {
		return -articulation_joystick.getY();
	}
}
