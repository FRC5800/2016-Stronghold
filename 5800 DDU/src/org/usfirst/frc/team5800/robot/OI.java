package org.usfirst.frc.team5800.robot;

import static org.usfirst.frc.team5800.robot.RobotMap.*;
import static org.usfirst.frc.team5800.robot.base.commands.CommandBase.*;

import java.io.File;

import org.usfirst.frc.team5800.robot.base.buttons.JoystickAxis;
import org.usfirst.frc.team5800.robot.base.buttons.JoystickAxisButton;
import org.usfirst.frc.team5800.robot.base.buttons.JoystickButtonList;
import org.usfirst.frc.team5800.robot.base.buttons.JoystickPOVButton;
import org.usfirst.frc.team5800.robot.base.commands.CommandIntake;
import org.usfirst.frc.team5800.robot.base.commands.CommandIntakeOnly;
import org.usfirst.frc.team5800.robot.base.commands.CommandMotor;
import org.usfirst.frc.team5800.robot.base.commands.CommandOuttakeOnly;
import org.usfirst.frc.team5800.robot.base.commands.CommandSingleSolenoid;
import org.usfirst.frc.team5800.robot.base.commands.CommandWait;
import org.usfirst.frc.team5800.robot.base.commands.autonomous.Autonomous;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control of the robot.
 *
 * @author Sean Zammit
 */
@SuppressWarnings("unused")
public class OI
{
	public OI() {
		Autonomous.initAutonomous();
		
		//Set what commands will run when buttons are pressed/held/released here.
		whenHeld(d_A, new CommandIntake()); // whenHeld(o_LT, new CommandIntake());
		whenHeld(d_X, new CommandIntakeOnly()); // whenHeld(o_X, new CommandIntakeOnly());
		whenHeld(d_Y, new CommandOuttakeOnly()); // whenHeld(o_Y, new CommandOuttakeOnly());
		
		whenPressed(d_B,
				new CommandMotor(shooter, shooter.centreBallMotor, 1.0D).setParallel(
						new CommandMotor(shooter, shooter.shooter, 1.0D)
//						.setParallel(
//								new CommandMotor(intake, intake.intake, 1.0D)
//						)
				)
		);		
		whenReleased(d_B,
				new CommandMotor(shooter, shooter.centreBallMotor, 0D).setParallel(
						new CommandMotor(shooter, shooter.shooter, 0D)
//						.setParallel(
//								new CommandMotor(intake, intake.intake, 0D)
//						)
				)
		);
	}
	
	//Set up joysticks and buttons here.
	private static final Joystick stick_d = new Joystick(0);
	
	public static final JoystickAxis
		axis_d_LX = new JoystickAxis(stick_d, 0),
		axis_d_LY = new JoystickAxis(stick_d, 1),
		axis_d_LT = new JoystickAxis(stick_d, 2),
		axis_d_RT = new JoystickAxis(stick_d, 3), //
		axis_d_RX = new JoystickAxis(stick_d, 4),
		axis_d_RY = new JoystickAxis(stick_d, 5); //

	public static final Button
		d_A = new JoystickButton(stick_d, 1),
		d_B = new JoystickButton(stick_d, 2),
		d_X = new JoystickButton(stick_d, 3),
		d_Y = new JoystickButton(stick_d, 4),
		d_LB = new JoystickButton(stick_d, 5),
		d_RB = new JoystickButton(stick_d, 6),
		d_Back = new JoystickButton(stick_d, 7),
		d_Start = new JoystickButton(stick_d, 8),
		d_LStick = new JoystickButton(stick_d, 9),
		d_RStick = new JoystickButton(stick_d, 10),

		d_POV_U = new JoystickPOVButton(stick_d, 0),
		d_POV_R = new JoystickPOVButton(stick_d, 90),
		d_POV_D = new JoystickPOVButton(stick_d, 180),
		d_POV_L = new JoystickPOVButton(stick_d, 270),

		d_LT = new JoystickAxisButton(axis_d_LT, false, 0.5D),
		d_RT = new JoystickAxisButton(axis_d_RT, false, 0.5D);
	
	private static final Joystick stick_o = new Joystick(1);
	
	public static final JoystickAxis
		axis_o_LX = new JoystickAxis(stick_o, 0),
		axis_o_LY = new JoystickAxis(stick_o, 1),
		axis_o_LT = new JoystickAxis(stick_o, 2),
		axis_o_RT = new JoystickAxis(stick_o, 3),
		axis_o_RX = new JoystickAxis(stick_o, 4),
		axis_o_RY = new JoystickAxis(stick_o, 5);

	public static final Button
		o_A = new JoystickButton(stick_o, 1),
		o_B = new JoystickButton(stick_o, 2),
		o_X = new JoystickButton(stick_o, 3),
		o_Y = new JoystickButton(stick_o, 4),
		o_LB = new JoystickButton(stick_o, 5),
		o_RB = new JoystickButton(stick_o, 6),
		o_Back = new JoystickButton(stick_o, 7),
		o_Start = new JoystickButton(stick_o, 8),
		o_LStick = new JoystickButton(stick_o, 9),
		o_RStick = new JoystickButton(stick_o, 10),

		o_POV_U = new JoystickPOVButton(stick_o, 0),
		o_POV_R = new JoystickPOVButton(stick_o, 90),
		o_POV_D = new JoystickPOVButton(stick_o, 180),
		o_POV_L = new JoystickPOVButton(stick_o, 270),

		o_LT = new JoystickAxisButton(axis_o_LT, false, 0.5D),
		o_RT = new JoystickAxisButton(axis_o_RT, false, 0.5D);
	
	private void whenPressed(Button button, Command5800 command) {
		button.whenPressed(command);
	}

	private void whenHeld(Button button, Command5800 command) {
		button.whenPressed(command.setCancelWhenReleased(button));
	}

	private void whenReleased(Button button, Command5800 command) {
		button.whenReleased(command);
	}

	private void cancelWhenPressed(Button button, Command5800 command) {
		button.cancelWhenPressed(command);
	}

	private void toggleWhenPressed(Button button, Command5800 command) {
		button.toggleWhenPressed(command);
	}
	
	private void pulseWhileHeld(Button button, Command5800 command) {
		button.whileHeld(command);
	}
}
