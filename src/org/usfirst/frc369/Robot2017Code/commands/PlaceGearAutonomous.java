package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;
import org.usfirst.frc369.Robot2017Code.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGearAutonomous extends CommandGroup {

    public PlaceGearAutonomous() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm
    	Robot.driveSys.shiftToLowGear();
    	addSequential(new CloseClaw());
    	addSequential(new DriveByTime(0.25, 4.3)); //drives str
    	addSequential(new ClawOpen());
    	addSequential(new GearHandlerDown());
    	addSequential(new DriveByTime(-0.25, 3.5));
    	addSequential(new GearHanlderUp());
    }
}
