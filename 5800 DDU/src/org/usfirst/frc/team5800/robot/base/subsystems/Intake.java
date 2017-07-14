package org.usfirst.frc.team5800.robot.base.subsystems;

import static org.usfirst.frc.team5800.robot.RobotMap.*;

import org.usfirst.frc.team5800.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.*;

/**
 * @author Sean Zammit
 */
public class Intake extends Subsystem5800
{
	public VictorSP intake = new VictorSP(intakeMotorID);
	public Solenoid intakeSolenoid = new Solenoid(intakeSolenoidID);
			
	public Intake() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here.
	}
}
