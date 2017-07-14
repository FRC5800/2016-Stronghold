package org.usfirst.frc.team5800.robot.base.commands.autonomous;

import org.usfirst.frc.team5800.robot.base.commands.CommandMotorTime;
import org.usfirst.frc.team5800.robot.base.commands.drive.CommandTimedTurn;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

/**
 *
 * @author Sean Zammit
 */
public class Autonomous extends Command5800
{
	public Autonomous() {super(null);}
	protected void execute() {}
	protected boolean isDone() {return true;}
	protected void onCompletion() {}
	
	public static Autonomous[] autonomous = new Autonomous[5];
	
	public static void initAutonomous() {
		//Set the sequence of commands run by each version of autonomous here.
		
		//Do nothing
		autonomous[0] = new Autonomous();
		
		//Primary autonomous
		autonomous[1] = (Autonomous) new Autonomous().setSequential(
				new CommandTimedTurn(9, 0.6D, 0.63D), 
				new CommandTimedTurn(0.75D, -0.5D, -0.5D), 
				new CommandTimedTurn(0.85D, 0.8D, -0.8D),
				new CommandTimedTurn(0.45D, -0.7D, -0.6D),
				new CommandTimedTurn(1, -0.6D, -0.6D),
				new CommandMotorTime(shooter, shooter.shooter, 1D, 3D) //Shoot.
		);
		
		//Spy bot autonomous
		autonomous[2] = (Autonomous) new Autonomous().setSequential(
				new CommandTimedTurn(0.5D, -0.7D, -0.6D),
				new CommandTimedTurn(1, -0.6D, -0.6D),
				new CommandMotorTime(shooter, shooter.shooter, 1D, 3D) //Shoot.
		);
		
		//Low bar autonomous
		autonomous[3] = (Autonomous) new Autonomous().setSequential(
				new CommandTimedTurn(5, 0.6D, 0.63D)
		);
		
		//Defense autonomous
		autonomous[4] = (Autonomous) new Autonomous().setSequential(
				new CommandTimedTurn(5, 1, 1)
		);
	}
}
