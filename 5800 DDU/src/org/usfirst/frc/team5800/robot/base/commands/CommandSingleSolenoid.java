package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Sean Zammit
 */
public class CommandSingleSolenoid extends Command5800
{
	public Solenoid solenoid;
	public boolean on;
	
	public CommandSingleSolenoid(Solenoid sol, boolean on) {
		super(null);
		solenoid = sol;
		this.on = on;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return true;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		solenoid.set(on);
	}
}
