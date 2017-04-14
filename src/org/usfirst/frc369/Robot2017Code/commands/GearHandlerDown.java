package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearHandlerDown extends Command {

	boolean isdone = false;
	
    public GearHandlerDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearHandler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearHandler.putHandlerDown();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isdone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isdone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
