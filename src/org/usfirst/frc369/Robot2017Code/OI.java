// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc369.Robot2017Code;

import org.usfirst.frc369.Robot2017Code.commands.*;
import org.usfirst.frc369.Robot2017Code.subsystems.Cameras;
import org.usfirst.frc369.Robot2017Code.subsystems.Cameras.CameraType;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
	public JoystickButton square;
    public JoystickButton x;
    public JoystickButton r2;
    public JoystickButton l2;
    public JoystickButton r1;
    public JoystickButton l1;
    public JoystickButton circle;
    public JoystickButton triangle;
    public JoystickButton leftStickButton;
    public JoystickButton square2;
    public JoystickButton x2;
    public JoystickButton r22;
    public JoystickButton l22;
    public JoystickButton r12;
    public JoystickButton l12;
    public JoystickButton circle2;
    public JoystickButton triangle2;
    public JoystickButton leftStickButton2;
    public JoystickButton share;
    public JoystickButton options;
    public JoystickButton share2;
    public JoystickButton options2;
    public Joystick ps4_Controller;
    public Joystick ps4_Controller2;
    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        ps4_Controller = new Joystick(0);
        ps4_Controller2 = new Joystick(1);
      
        x = new JoystickButton(ps4_Controller, 2);
        x2 = new JoystickButton(ps4_Controller2, 2);
        square = new JoystickButton(ps4_Controller, 1);
        square2 = new JoystickButton(ps4_Controller2, 1);
        l2 = new JoystickButton(ps4_Controller, 7);
        l22 = new JoystickButton(ps4_Controller2, 7);
        
        r2 = new JoystickButton(ps4_Controller, 8);
        r22 = new JoystickButton(ps4_Controller2, 8);
        l1 = new JoystickButton(ps4_Controller, 5);
        l12 = new JoystickButton(ps4_Controller2, 5);
        r1 = new JoystickButton(ps4_Controller, 6); 
        r12 = new JoystickButton(ps4_Controller, 6);
        circle = new JoystickButton(ps4_Controller, 4);
        circle2 = new JoystickButton(ps4_Controller2, 4);
        triangle = new JoystickButton(ps4_Controller, 3);
        triangle2 = new JoystickButton(ps4_Controller2, 3);
        leftStickButton = new JoystickButton(ps4_Controller, 11);
        leftStickButton2 = new JoystickButton(ps4_Controller, 11);
        share = new JoystickButton(ps4_Controller, 9);
        options = new JoystickButton(ps4_Controller, 10);
        share2 = new JoystickButton(ps4_Controller2, 9);
        options2 = new JoystickButton(ps4_Controller2, 10);
        
        
        
        triangle.whenPressed(new HangerClimbUp());
        triangle.whenReleased(new StopHanger());
        
        circle.whenPressed(new HangerClimbDown());
        circle.whenReleased(new StopHanger());
        
        triangle2.whenPressed(new HangerClimbUp());
        triangle2.whenReleased(new StopHanger());
        
        circle2.whenPressed(new HangerClimbDown());
        circle2.whenReleased(new StopHanger());
        
        square.whenPressed(new GearHandlerDown());
        x.whenPressed(new GearHanlderUp());
        
        l1.whenPressed(new ClawOpen());
        r1.whenPressed(new CloseClaw());
        
        l2.whenPressed(new lowGearShift());
        r2.whenPressed(new highGearShift());
        
//        x2.whenPressed(new BlueLED());
//        square2.whenPressed(new PinkLED());
//        share2.whenPressed(new OffLED());
//        share.whenPressed(new CameraSwitch(CameraType.FRONT));
//        options.whenPressed(new CameraSwitch(CameraType.BACK));
//        
        
       
        
        //if (driveStick.getRawButton(RobotMap.btnCameraFront)) {
//			cameras.changeCamera(CameraType.FRONT);
//
//		}
//		if (driveStick.getRawButton(RobotMap.btnCameraBack)) {
//			cameras.changeCamera(CameraType.BACK);

        // SmartDashboard Buttons
//        chooser = new SendableChooser();
//        chooser.addDefault("Default Auto", defaultAuto);
//        chooser.addObject("My Auto", customAuto);
//        SmartDashboard.putData("Auto choices", chooser);

       // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("HangerClimbUp", new HangerClimbUp());
        SmartDashboard.putData("HangerClimbDown", new HangerClimbDown());
 //     SmartDashboard.putData("Left Peg Auto", new PlaceGearOnLeftPeg_Auto());
 //     SmartDashboard.putData("Right Peg Auto", new PlaceGearOnRightPeg_Auto());
 //     SmartDashboard.putData("Reg Peg Auto", new PlaceGearAutonomous());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getps4_Controller() {
        return ps4_Controller;
    }
    
    public double getleftStick(){
    	return ps4_Controller.getRawAxis(1);
    }
    
    public double getRightStick(){
    	return ps4_Controller.getRawAxis(5);
    }
    
    
    public boolean getStickButton(){
    	return ps4_Controller.getRawButton(11);
    }
    


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

