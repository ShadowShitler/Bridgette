package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class DriveByTime extends Command {
	static double speed = 0.5;
	private double distanceToTravel;
	private double travelSpeed;
	private Timer time;
    public DriveByTime(double speed, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSys);
    	distanceToTravel = time;
    	travelSpeed = speed;
    	this.time = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSys.resetAngle();
    	time.start();
//    	Robot.driveSys.shiftToLowGear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSys.driveStraight(travelSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return time.hasPeriodPassed(distanceToTravel);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSys.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
