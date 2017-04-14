package org.usfirst.frc369.Robot2017Code.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGearOnRightPeg_Auto extends CommandGroup {

    public PlaceGearOnRightPeg_Auto() {
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
        // arm.
    	
    	// NOTE:
    	//	WITH THIS CODE, WE WILL HAVE TO FIND A SWEET SPOT ON THE FIELD LIKE
    	//	A LINE OR FIELD MARKING AND MODIFY THE VALUES ACCORDINLY SO THAT IT WILL WORK
    	//	ONLY VALUES WE NEED TO CHANGE IS THE ANGLE AND DISTANCE TO TRAVLE
    	addSequential(new DriveByTime(0.25 	, 4.76)); //drives str
    	//addSequential(new ClawOpen());
    	//addSequential(new GearHandlerDown());
    	//addSequential(new DriveByTime(-0.25, 4));
    	//addParallel(new GearHanlderUp());
    	addSequential(new RotateToAngle(+60));
    	addSequential(new DriveByTime(0.5, 3));
    	addSequential(new ClawOpen());
    	addSequential(new GearHandlerDown());
    	addSequential(new DriveByTime(-0.25, 3));
    	addSequential(new GearHanlderUp());
    }
}
