package org.usfirst.frc369.Robot2017Code.commands;

import java.util.Timer;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drivewithpi extends Command {
	static double speed = 0.5;
	private double distanceToTravel;
	private double travelSpeed;
	private Timer time;

	private static boolean durationAcquired = false;
	
	public Drivewithpi(double speed, double time){
		
		requires(Robot.driveSys);
		distanceToTravel = time;
		travelSpeed = speed;
		requires(Robot.dblE);
		this.time = new Timer();
	//	duration = period;
	}
	
	
	protected void initialize(){
		Robot.driveSys.resetAngle();
	//	time.start();
	//	startTime = System.currentTimeMillis();
	//	Robot.driveSys.resetAngle();
	}
	
	protected void execute() {
    	Robot.driveSys.drive(0.4 , Robot.vision.getangle());
    }
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
}
