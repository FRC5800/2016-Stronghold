package org.usfirst.frc.team5800.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //PWMs (0 - 9)
    public static final int
    	driveMotorLID = 0,
    	driveMotorRID = 2,
    	intakeMotorID = 4,
    	centreBallMotorID = 5,
    	shooterMotorID = 6;
  
    //Solenoids (0 - 7)
    public static final int
		intakeSolenoidID = 0,
		armSolenoidID = 1;
        
    //Analog Inputs (0 - 3)
    public static final int
    	gyroID = 0;
    
    //Digital I/Os (0 - 9)
    public static final int
    	driveEncoderL3ID = 0,
    	driveEncoderL1ID = 1,
    	driveEncoderR3ID = 2,
    	driveEncoderR1ID = 3;
}