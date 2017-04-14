package org.usfirst.frc369.Robot2017Code.subsystems;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LED extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void LEDOn(){
    	Robot.LEDSys.equals(Relay.Value.kForward);
    }
    public void LEDelse(){
    	Robot.LEDSys.equals(Relay.Value.kReverse);
    }
    public void LEDOff(){
    	Robot.LEDSys.equals(Relay.Value.kOff);
    }
}

