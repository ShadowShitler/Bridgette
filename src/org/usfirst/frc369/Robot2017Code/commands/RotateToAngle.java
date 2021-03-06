package org.usfirst.frc369.Robot2017Code.commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotateToAngle extends Command {

	private double angleToAcquire = 0.0;
	private boolean angleAcquired = false;
	
    public RotateToAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSys);
    	angleToAcquire = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSys.resetAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSys.rotateToAngle(angleToAcquire);
    	Timer time = new Timer();
    	/*if (Robot.driveSys.didAchievedAngle()){
    		time.start();
    		if (time.hasPeriodPassed(1)){
    			angleAcquired = true;
    		}
    	}else{
    		time.stop();
    		time.reset();
    		angleAcquired = false;
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	SmartDashboard.putBoolean("CMD ANGLE ACHIEVED", angleAcquired);
        return angleAcquired;
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
