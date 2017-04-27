package org.usfirst.frc369.Robot2017Code.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GoodJobJuan extends Command {
	public static String Juan;
    public GoodJobJuan() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	SmartDashboard.putString(Juan, "Good Job Juan! Proud of you!");
    	
    }
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}