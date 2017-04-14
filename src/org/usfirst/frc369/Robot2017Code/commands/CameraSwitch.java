package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;
import org.usfirst.frc369.Robot2017Code.subsystems.Cameras.CameraType;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraSwitch extends Command {
	private CameraType type;
    public CameraSwitch(CameraType camera) {
   // 	requires(Robot.cameras);
    	type = camera;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    //	Robot.cameras.changeCamera(type);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
