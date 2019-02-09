// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6224.PowerUp4.subsystems;

import org.usfirst.frc6224.PowerUp4.Robot;
import org.usfirst.frc6224.PowerUp4.RobotMap;
import org.usfirst.frc6224.PowerUp4.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveSystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController frontRight = RobotMap.driveSystemfrontRight;
    private final SpeedController bottomRight = RobotMap.driveSystembottomRight;
    private final SpeedController frontLeft = RobotMap.driveSystemfrontLeft;
    private final SpeedController bottomLeft = RobotMap.driveSystembottomLeft;
    private final RobotDrive robotDrive = RobotMap.driveSystemRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public double ddrivethrottle;
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    		setDefaultCommand(new DriveWithJoystick());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void takeJoystickInput()
    {
    	robotDrive.arcadeDrive(Robot.oi.drive.getRawAxis(1) * (ddrivethrottle + 1)/2, -Robot.oi.drive.getRawAxis(2) * (ddrivethrottle + 1)/2);
    }
    public void stop()
    {
    	robotDrive.arcadeDrive(0,0);
    }
    public void autoDriveForward()
    {
    	robotDrive.arcadeDrive(-0.60, 0);
    }
    public void autoTurnRight() 
    {
    	robotDrive.arcadeDrive(0, -0.53);
	}
    public void autoTurnLeft()
    {
    	robotDrive.arcadeDrive(0, 0.53);
    }
    public void autoDriveForwardFast()
    {
    	robotDrive.arcadeDrive(-0.60, 0);
    }
    public void autoDriveBackwardFast()
    {
    	robotDrive.arcadeDrive(0.65, 0);
    }


}
