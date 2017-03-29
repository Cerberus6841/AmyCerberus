// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5725.AmyCerberus;

//import edu.wpi.cscore.UsbCamera;
//import edu.wpi.cscore.UsbCamera;
//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc5725.AmyCerberus.commands.*;
import org.usfirst.frc5725.AmyCerberus.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.opencv.core.Rect;
//import org.opencv.imgproc.Imgproc;
//import edu.wpi.first.wpilibj.vision.VisionPipeline;
//import edu.wpi.first.wpilibj.vision.VisionRunner;
//import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autoModes;

    // Vison tracking variables
	/*private VisionThread visionThread;
	public static double centerX = 0.0;
	private final Object imgLock = new Object();
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
    */
    public static OI oi;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static HDrive hDrive;
    public static Climber climber;
    public static Latch latch;
    public static Kicker kicker;
    public static CameraRotator cameraRotator;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Camera camera;

    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        hDrive = new HDrive();
        climber = new Climber();
        latch = new Latch();
        kicker = new Kicker();
        cameraRotator = new CameraRotator();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        camera = new Camera();
        //centerX = camera.getCenterX();
        //System.out.println("CenterX: " + String.valueOf(centerX));
        // Start USB Camera
        //CameraServer.getInstance().startAutomaticCapture(); 
       /*UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();
       camera1.setResolution(IMG_WIDTH, IMG_HEIGHT);
        
        visionThread = new VisionThread(camera1, new GripPipeline(), pipeline -> {
            if (!pipeline.filterContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                synchronized (imgLock) {
                    centerX = r.x + (r.width / 2);
                    System.out.println("CenterX: " + String.valueOf(centerX));
                }

            }
        });
        visionThread.start();        
        */
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutoMiddle();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autoModes = new SendableChooser();
        autoModes.addDefault("Middle Position", new AutoMiddle());
        autoModes.addObject("Right Position", new AutoLeft());
        autoModes.addObject("Left Position", new AutoRight());
        SmartDashboard.putData("Autonomous Modes", autoModes);

        
      }
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	
    	// Overrides default autonomous command from Robot Builder
    	autonomousCommand = (Command)autoModes.getSelected();
    	
    	// Starts Autonomous
        if (autonomousCommand != null) autonomousCommand.start();

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
