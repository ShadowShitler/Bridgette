package org.usfirst.frc369.Robot2017Code.subsystems;

import org.usfirst.frc369.Robot2017Code.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ImageProcessing extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    }
    public Double getangle(){
    	Double value = RobotMap.server.getDouble();
    	if (value == null){
    		return 0.0;
    	}
    	return value;
    }
   
}

