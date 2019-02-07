/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Robot extends TimedRobot {
 

  public DriveTrain driveTrain;
  public Manipulator manipulator;
  Choosers choosers;
  Vision vision;
  NavX navx;

  @Override
  public void robotInit() {
    driveTrain = new DriveTrain();
    manipulator = new Manipulator();
    choosers = new Choosers(driveTrain, manipulator);
    vision = new Vision();
    navx = new NavX();
  }
  
  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
    
  }

  
  @Override
  public void autonomousPeriodic() 
  {
    choosers.automatedTurnToAngle();
    driveTrain.drive();
    
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() 
  {
    choosers.setDriveMode();
    choosers.automatedTurnToAngle();
//    choosers.shootHighSwitch();
//    choosers.setManipulatorMode();
    driveTrain.drive();
    vision.execute();
    navx.xAcceleration();
    navx.yAcceleration();
//    manipulator.manipulatorExecute();
  }

 
  @Override
  public void testPeriodic() {
  }
}
