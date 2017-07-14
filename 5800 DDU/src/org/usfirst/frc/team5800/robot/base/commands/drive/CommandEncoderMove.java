package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

/**
 * @author Sean Zammit
 */
public class CommandEncoderMove extends Command5800
{
	double speed;
	int pulses;

	public CommandEncoderMove(int pulses, double sp) {
		super(driver);
		this.pulses = pulses;
		speed = sp;
	}
	
	protected void onStart() {
		sensors.driveEncoderL.reset();
		sensors.driveEncoderR.reset();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		driver.arcadeDrive(speed, 0);
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return Math.abs(sensors.driveEncoderL.get()) > pulses && Math.abs(sensors.driveEncoderR.get()) > pulses; 
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
