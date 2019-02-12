/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class Drive extends Command {
  public Drive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_drivetrain);
  }
  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  // collect values from driver control
    double moveValue = Robot.m_oi.driver.getRawAxis(RobotMap.moveAxis);
    double rotateValue = Robot.m_oi.driver.getRawAxis(RobotMap.rotateAxis);

    //dead bands round up and avoid errors
    if ((moveValue <= 0.2 && moveValue >= -0.2)){
        moveValue = 0;
    }

    if ((rotateValue <= 0.2 && moveValue >= -0.2)){
        rotateValue = 0;
    }

    // setting max speed for robot
    if (moveValue > 0.9){
        moveValue = 0.9;
    }

    if (moveValue < -0.9){
        moveValue = -0.9;
    }
    
    //send Values to the drivetrain
    Robot.m_drivetrain.drive(moveValue, rotateValue);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.m_drivetrain.drive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
