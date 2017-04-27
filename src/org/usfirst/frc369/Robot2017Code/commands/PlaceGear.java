package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGear extends CommandGroup {

    public PlaceGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearHandler);
    	
    	addSequential(new GearHandlerDown());
    	addSequential(new ClawOpen());
    	addParallel(new GearHanlderUp());    	
    }
    }
