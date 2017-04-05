// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5725.AmyCerberus.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc5725.AmyCerberus.subsystems.*;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class AutoLeft extends CommandGroup {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoLeft() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
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
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
    	/*Descision will need to be made as to whether or not to use
    	 * "SeekAndDriveTo" or "SeekAndDriveSim" 
    	 * comment one or other out below.
    	 */
    	addSequential(new driveForwardTimed());
    	addSequential(new turnLeftTimed());
    	addSequential(new driveForwardTimed(),0.5);
    	addSequential(new latchOpen());
    	addSequential(new SeekAndDriveSim());
    	//addSequential(new SeekAndDriveTo());
    	addSequential(new kickForward());
    	// Backup commands after one second delay.
    	Timer.delay(1.0);
    	addSequential(new AutoReverse());
    	addSequential(new SwitchDirection());
    } 
}
