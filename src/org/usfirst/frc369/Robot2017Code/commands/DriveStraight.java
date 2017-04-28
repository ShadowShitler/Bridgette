package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class DriveStraight extends Command {

	private static double speed = 0.5;
	private static long startTime;
	private static long duration;
	private static boolean durationAcquired = false;
	
    public DriveStraight(long period) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSys);
    	requires(Robot.dblE);
    	duration = period;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    	Robot.driveSys.resetAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSys.driveStraight(speed);
    	if((System.currentTimeMillis() - startTime) >= duration)
    		durationAcquired = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return durationAcquired;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSys.driveStraight(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
