package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightToSetDistance extends Command {

	private double distanceToTravel;
	private double travelSpeed;
	
    public DriveStraightToSetDistance(double speed, double dist) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.dblE);
    	requires(Robot.driveSys);
    	distanceToTravel = dist;
    	travelSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dblE.reset();
    	Robot.driveSys.resetAngle();
    	Robot.dblE.setDistanceToAcquire(distanceToTravel);
    	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (travelSpeed > 0)
    		Robot.driveSys.driveStraightReverse(travelSpeed);
    	else
    		Robot.driveSys.driveStraight(travelSpeed);
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.dblE.didAcquireDistance();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSys.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
