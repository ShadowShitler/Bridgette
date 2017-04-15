package org.usfirst.frc369.Robot2017Code.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc369.Robot2017Code.RobotMap;;

/**
 *
 */
public class GyroAngleHandler extends Subsystem implements PIDOutput {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	static final double kP = 0.03;
	static final double kI = 0.00;
	static final double kD = 0.00;
	static final double kF = 0.00;
	
	private PIDController turnController;
	private double rotationRate;
	private boolean isAtAngle = false;
	
	/* This tuning parameter indicates how close to "on target" the    */
	/* PID Controller will attempt to get.                             */

	  static final double kToleranceDegrees = 2.0f;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);
    }
    
    
    public double rotateToAngle(double angle){
    	turnController.setSetpoint(angle);
    	turnController.startLiveWindowMode();
    	turnController.enable();
    	return rotationRate;
    }
    
    public boolean angleAchieved(){
    	turnController.disable();
    	return isAtAngle;
    }

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		rotationRate = output;
	}
    
    
    
}

