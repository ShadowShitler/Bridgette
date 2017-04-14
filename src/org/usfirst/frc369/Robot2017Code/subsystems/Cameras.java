package org.usfirst.frc369.Robot2017Code.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Cameras extends Subsystem {
	public enum CameraType {
		FRONT, BACK
	}

	static UsbCamera fwdCamera;
	static UsbCamera bkwdCamera;
	static MjpegServer mjpegServer;
	static CameraServer cs;
	public Cameras() {
//        cs = CameraServer.getInstance();  
//		fwdCamera = new UsbCamera("USB Camera 0", 0);
//		bkwdCamera = new UsbCamera("USB Camera 1", 1);
		
		
	//	mjpegServer = cs.addServer("server_USB Camera 0");	
		
	}

	public static void changeCamera(CameraType camera) {
		switch (camera) {
		case FRONT:
			cs.addCamera(fwdCamera);
			mjpegServer.setSource(fwdCamera);
			SmartDashboard.putString("camera", "front");
			break;

		case BACK:

			cs.addCamera(bkwdCamera);
			mjpegServer.setSource(bkwdCamera);
			SmartDashboard.putString("camera", "back");
			break;
		default:
			

		}
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}