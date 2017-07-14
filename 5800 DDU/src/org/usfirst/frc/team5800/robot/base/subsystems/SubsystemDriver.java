package org.usfirst.frc.team5800.robot.base.subsystems;

import static org.usfirst.frc.team5800.robot.RobotMap.*;

import org.usfirst.frc.team5800.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * @author Sean Zammit
 */
public class SubsystemDriver extends Subsystem5800
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	private VictorSP l = new VictorSP(driveMotorLID);
	private VictorSP l2 = new VictorSP(driveMotorLID + 1);
	
	private VictorSP r = new VictorSP(driveMotorRID);
	private VictorSP r2 = new VictorSP(driveMotorRID + 1);

	private RobotDrive driveFront = new RobotDrive(l, r);
	private RobotDrive driveRear = new RobotDrive(l2, r2);
	
	public Solenoid armSolenoid = new Solenoid(armSolenoidID);
	

	public SubsystemDriver() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}
	
	public void tankDrive(double l, double r) {
		driveFront.tankDrive(l, r);
		driveRear.tankDrive(l, r);
	}

	public void arcadeDrive(double speed, double d) {
		driveFront.arcadeDrive(speed, d);
		driveRear.arcadeDrive(speed, d);
	}
}
