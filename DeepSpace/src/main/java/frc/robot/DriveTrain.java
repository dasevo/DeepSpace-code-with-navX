/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.PID.Zpid;

public class DriveTrain {

    RobotMap robotMap;
    DriveMode driveMode;
    public double turnSetpoint;
    public Zpid turnPID;

    public DriveTrain()
    {
        robotMap = RobotMap.getRobotMap();
        turnPID = new Zpid();
        turnPID.zpidSetup();
    }
    
    public void drive()
    {
        driveMode.driveRobot();
    }


    

}
