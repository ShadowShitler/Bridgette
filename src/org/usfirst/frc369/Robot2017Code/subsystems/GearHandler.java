package org.usfirst.frc369.Robot2017Code.subsystems;

import org.usfirst.frc369.Robot2017Code.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHandler extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final DoubleSolenoid gearHandler = RobotMap.gearHandler;
	private final DoubleSolenoid gearClaw = RobotMap.gearClaw;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pullHandlerUp(){
    	gearHandler.set(Value.kForward);
    }
    
    public void putHandlerDown(){
    	gearHandler.set(Value.kReverse);
    }
    
    public void closeGearClaw(){
    	gearClaw.set(Value.kReverse);
    }
    
    public void openGearClaw(){
    	gearClaw.set(Value.kForward);
    }
    
}

