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
	
	private Joystick articulation_joystick;
	private Button initiate_shooter, shoot;
	
	public OI(){
		//Joy Stick
		articulation_joystick = new Joystick(2);
		
		//Buttons
		initiate_shooter = new JoystickButton(articulation_joystick, 5);
		shoot = new JoystickButton(articulation_joystick, 1);
		
		//Commands
//		initiate_shooter.whileHeld(new PIDShootInitiate());
		shoot.whileHeld(new PIDEjectorInitiate());
	}
	
	public boolean articulationButtonState(int button_number){
		return articulation_joystick.getRawButton(button_number);
	}
	
}
