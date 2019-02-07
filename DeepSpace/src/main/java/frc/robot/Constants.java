/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Constants {

    public static final double xKP = 0.1;
    public static final double xKI = 0;
    public static final double xKD = 0;
    public static final double xOutput = 0.7;
    public static final double xTolerance = 1;
    
    public static final double yKP = 0.22;
    public static final double yKI = 0;
    public static final double yKD = 0;
    public static final double yOutput = 0.7;
    public static final double yTolerance = 1;

    public static final double zKP = 0.03;
    public static final double zKI = 0;
    public static final double zKD = 0;
    public static final double zOutput = 1;
    public static final double zInput = 180;
    public static final double turnTolerance = 2;

    public static final double midVoltage = 2.5;
    public static final double driveForwardSpeed = -0.3;
    public static final double rotateLeftSpeed = -0;
    public static final double rotateRightSpeed = 0;
    public static final double strafeLeftSpeed = 0.2;
    public static final double strafeRightSpeed = -0.2;

    public static final double h1 = 21.5; //distance from bottom of robot to camera (inches)
    public static final double h2 = 31.50; //distance from bottom of board to far left target (inches)
    public static final double w1 = 13.78; //half of robot distance in x direction (inches)
    public static final double alphaXOne = 0;
    public static final double alphaYOne = 0;

    public static final int timeOutMs = 10;
}
