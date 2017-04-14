package org.usfirst.frc369.Robot2017Code.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc369.Robot2017Code.RobotMap;

/**
 *Distance Per Pulse - Sets the scale factor between pulses and distance.
 * The library already accounts for the decoding scale factor (1x, 2x, 4x) 
 * separately so this value should be set exclusively based on the encoder's
 *  Pulses per Revolution and any gearing following the encoder.
 *  
 *  Min Rate - Sets the minimum rate before the device is considered stopped. 
 *  This compensates for both scale factor and distance per pulse and therefore 
 *  should be entered in engineering units (RPM, RPS, Degrees/sec, In/s, etc)
 *  
 *Reverse Direction - Sets the direction the encoder counts, used to flip the direction
 * if the encoder mounting makes the default counting direction unintuitive.
 * 
 * Samples to Average - Sets the number of samples to average when determining the period.
 *  Averaging may be desired to account for mechanical imperfections (such as unevenly 
 *  spaced reflectors when using a reflective sensor as an encoder) or as oversampling to 
 *  increase resolution. Valid values are 1 to 127 samples.
 *  
 *  Max Period - The maximum period (in seconds) where the device is still considered moving.
 *   This value is used to determine the state of the getStopped() method and effect the 
 *   output of the getPeriod() and getRate() methods. This is the time between pulses on an 
 *   individual channel (scale factor is accounted for). It is recommended to use the Min Rate 
 *   parameter instead as it accounts for the distance per pulse, allowing you to set the rate
 *    in engineering units.
 *    
 *    
 *    PID NEED WORK!!!

 */
public class DoubleEncoder extends Subsystem implements PIDOutput{

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final Encoder leftEncoder = RobotMap.leftEncoder;			//reference from Robotmap class to new variable
	private final Encoder rightEncoder = RobotMap.rightEncoder;			//reference from Robotmap class to new variable
	private double speedCorrectionValue = 0.0;							//speedcorrection value for our pid output
	private double distanceToTravel = 0.0;								//distance our robot has to travel variable
	private double headingSpeed = 0.0; 									//heading speed for our robot used bcuz pid needs more testing
	
	private PIDController ldistController;										//PID controller variable
	
	static double kP = 0.021;													//P variable
	static double kI = 0.00;													//I variable
	static double kD = 0.00;													//D variable
	static double kF = 0.00;													//F variable
	
	

	//private PIDController pidController2 = new PIDController(P, I, D, rightEncoder, this);

    public void initDefaultCommand() {
    	PIDOutput left = new PIDOutput() {			
			@Override
			public void pidWrite(double output) {
				// TODO Auto-generated method stub
				
			}
		};
    	ldistController = new PIDController(kP, kI, kD, leftEncoder, this);
    	
    }
    
    //resets our encoders
    public void reset(){
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    //sets our distance to travel
    public void setDistanceToAcquire(double dist){
    	distanceToTravel = dist;
    }
    
    
    
    //starts tracking is our make shift aggressive approach pid
    //w/o all the fanciness to it
    //if we're 50%/25%/0% close to our target distance
    //cut/divide the speed respectively 2/3/set speed to 0
    public void startTracking(){
    	double percentTavelled = getDistanceTravelled()/distanceToTravel*100;
    	double speed = 0.5;
    	if(percentTavelled >= 50)
    		headingSpeed = speed;
    	
    	if(percentTavelled < 50)
    		headingSpeed = speed/2;
    	
    	if(percentTavelled < 25)
    		headingSpeed = speed/3;
    	
    	if(percentTavelled <= 0){
    		headingSpeed = 0.0;
    		if(percentTavelled < 0)
    			headingSpeed = -speed/3; 
    	}	
    }
    
    //the output variable for our make shift pid
    public double getHeadingSpeed(){
    	return headingSpeed;
    }
    
    //returns distance left to travel
    //since there is 2 encoders, returns the average distance
    //between the two
    public double getDistanceTravelled(){
    	return leftEncoder.getDistance();
    }
    
    //returns true if were are at the target distance
    //and false if not
    public boolean didAcquireDistance(){
    	if (leftEncoder.getDistance() >= distanceToTravel)
    		return true;
    	return false;			
    }
    
    //prints values to dashboard
    public void showValuestoDashBoard(){
    	SmartDashboard.putNumber("left Drvie Encoder", leftEncoder.getDistance());
    	SmartDashboard.putNumber("Right Drive Encoder", rightEncoder.getDistance());
    	SmartDashboard.putNumber("speed Correction", speedCorrectionValue);
    	//SmartDashboard.putBoolean("TargetAcquired", didAcquireDistance());
    }
   
   //returns our speedCorrection variable
   public double getSpeedCorrection(){
	   return speedCorrectionValue;
   }


   //refer to DriveSystem.java at the bottom for explanation 
   //on this function
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("ENCODER PID OUTPUT", output);
		SmartDashboard.putNumber("ENCODER P", kP);
		SmartDashboard.putNumber("ENCODER I", kI);
		SmartDashboard.putNumber("ENCODER D", kD);
		speedCorrectionValue = output*-0.5;
	}
    
}

