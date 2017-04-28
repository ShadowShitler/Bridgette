package org.usfirst.frc369.Robot2017Code.subsystems;

import org.usfirst.frc369.Robot2017Code.RobotMap;

//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSystem extends Subsystem implements PIDOutput {


	private final RobotDrive driveSystem = RobotMap.driveSystem; 				//reference drivesystem from Robotmap class to new variable
	private final DoubleSolenoid gearSwitcher = RobotMap.gearSwitcher;			//reference gearSwitcher from Robotmap class to new variable
	
	//
//	private final AHRS navX_Gyro = RobotMap.navX_Gyro;							//reference navXGyro from Robotmap class to new variable
	private final ADXRS450_Gyro adx_Gyro = RobotMap.gyro;						//reference drivesystem from ADXRS gyro class to new variable
	
	private PIDController turnController;										//PID controller variable
	
	static double kP = 0.034;													//P variable
	static double kI = 0.00;													//I variable
	static double kD = 0.00;													//D variable
	static double kF = 0.00;													//F variable
	
	static final double kToleranceDegrees = 0.03;								//tolerance variable
	
	private static double rotationRate = 0.0;									//rotation rate variable
	
	private static boolean isAtAngle = false;									//isAtAngle variable
	
	private static double maxSpeed = 0.5;										//maxSpeed variable
	
//	private EncoderHandler distanceTracker;
	
    public void initDefaultCommand() {
   // 	distanceTracker = new EncoderHandler();
    	turnController = new PIDController(kP, kI, kD, kF, adx_Gyro, this);		//initialize PID controller
        turnController.setInputRange(-180.0f,  180.0f);							//sets PID input range (max and min degrees)
        turnController.setOutputRange(-maxSpeed, maxSpeed);						//sets PID output range (normally -1.0 to 1.0 for motor output)
        turnController.setAbsoluteTolerance(kToleranceDegrees);					//sets Tolerence
        turnController.setContinuous(true);										//set PID  to continuous
    }
    
    //function for driving robot in tank drive
    private void Drive(double leftspeed, double rightspeed){
    	driveSystem.tankDrive(-leftspeed, -rightspeed); //robot tank drive with values placed in as a parameter
    }
    
    //function to normalize
    public void normalizedSpeed(double left, double right){
    	if (left > RobotMap.LEFT_GO_MAX)
    		left = RobotMap.LEFT_GO_MAX;	
    	
    	if (left < RobotMap.LEFT_BACK_MAX)
    		left = RobotMap.LEFT_BACK_MAX;
    	
    	if (right > RobotMap.RIGHT_GO_MAX)
    		right = RobotMap.RIGHT_GO_MAX;
    	
    	if (right < RobotMap.RIGHT_BACK_MAX)
    		right = RobotMap.RIGHT_BACK_MAX;
    	
    	Drive(left, right);
    }
    
    //resets gyro angle or heading direction
    public void resetAngle(){
 //   	navX_Gyro.reset();
    	adx_Gyro.reset();
    }
    
    //function to drive straight using the gyro
    //heading direction and reversing it to the motor
    //curve variable in the drive function
    //and takes speed parameter and set it to 
    //the drive function magnitude parameter
    public void driveStraightReverse(double speed){
    	try {
 //            driveSystem.drive(speed, navX_Gyro.getAngle()*0.005);
         } catch( RuntimeException ex ) {
             DriverStation.reportError("Error communicating with drive system:  " + ex.getMessage(), true);
         }

    }
    
    public void driveStraight(double speed){
        try {
            	driveSystem.drive(speed, -adx_Gyro.getAngle()*0.005);
        } catch( RuntimeException ex ) {
            DriverStation.reportError("Error communicating with drive system:  " + ex.getMessage(), true);
        }

    }
    
    public void driveDistance(double d){
  //  	distanceTracker.setDistance(d);
  //  	distanceTracker.enable();
    }
    
    //stops drive
    public void stopDrive(){
    	driveSystem.drive(0.0, 0.0);
    }
    
    //function takes in an angle
    //set that as the setpoint value (value for pid to get) for our pid controller
    //and enables our pid controller
    //once enabled, the pid will start generating output
    //to our rotationRate variable
    //we place that into our robot tank drive method lvalue - & rvalue +
    //and badda-bing we update our isAtAngle variable whether we are +/-3 to target angle
    public void rotateToAngle(double angle){
    	turnController.setSetpoint(angle);
    	turnController.enable();
    	SmartDashboard.putNumber("Rotation Rate:", rotationRate);
    	driveSystem.tankDrive(rotationRate, -rotationRate);
    	if(angle-3 <= adx_Gyro.getAngle() && angle+3 >= adx_Gyro.getAngle()){
    		isAtAngle = true;
    	}else{
    		isAtAngle = false;
    	}
    	
    }

    public void rotateToAngleWithDrive(Double angle) {
        driveSystem.drive(0, (-adx_Gyro.getAngle()*0.005) - angle );
    }
    //function to modify pid values for testing purposes
    //to write to individual slots in the basic tab on the dashboard:
    //SmartDashboard.putString("DB/String #slotnumber#", #string#);
    //to read from sliders in basic tabs on the driverstation:
    //kF = SmartDashboard.getNumber("DB/Slider $slider##", #defaultvalue#);
    //we can change the pid values with this function while testing using
    //the smartdashboard basic tab sliders and string box to print values
    public void modPID(){
    	SmartDashboard.putString("DB/String 0", "P: "+kP);
    	SmartDashboard.putString("DB/String 1", "I: "+kI);
    	SmartDashboard.putString("DB/String 2", "D: "+kD);
    	SmartDashboard.putString("DB/String 3", "F: "+kF);
    	
    	
    	kP = SmartDashboard.getNumber("DB/Slider 0",0.0);
    	kI = SmartDashboard.getNumber("DB/Slider 1",0.0);
    	kD = SmartDashboard.getNumber("DB/Slider 2",0.0);
    	kF = SmartDashboard.getNumber("DB/Slider 3",0.0);
    	turnController.setPID(kP, kI, kD, kF); //update pid values for pid controller
    }
    
    //returns value of isAtAngle variable
    public boolean didAchievedAngle(){
    	return isAtAngle;		
    }

    //high gear position
    public void shiftToHighGear(){
    	gearSwitcher.set(Value.kForward);
    }
    
    //low gear position
    public void shiftToLowGear(){
    	gearSwitcher.set(Value.kReverse);
    }
    
    //returns gyro angle
 //   public double getSysAngle(){
 //   	return navX_Gyro.getAngle();
 //   }

    //PID required function, frequently update to output variable
    //output is any value from -maxSpeed to maxSpeed
    //output is generated from pid equations
    //since we can set the max & min output value using the "setOutputRange" pid finction
    // the output can be directly sent to the motor drive
    //rotationRate handles this value
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		SmartDashboard.putBoolean("isAtAngle", isAtAngle);
		SmartDashboard.putNumber("Drive sys Gyro output", output);
		SmartDashboard.putNumber("Gyro", adx_Gyro.getAngle());
		SmartDashboard.putString("DB/String 5", "Acq Ang: "+isAtAngle);
    	SmartDashboard.putString("DB/String 6", "Rot. Rate: "+rotationRate);
    	SmartDashboard.putString("DB/String 7", "Curr. Ang.: "+adx_Gyro.getAngle());
		rotationRate = output; //updates rotationRate
	}
}

