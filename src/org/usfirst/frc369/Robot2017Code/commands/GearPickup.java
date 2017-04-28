package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearPickup extends CommandGroup{

		
	
    public GearPickup() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearHandler);
    	
    	addSequential(new CloseClaw());
    	addSequential(new GearHanlderUp());
    	
    	
    	
    	
    	
    	
    	
    	
    }

   }
