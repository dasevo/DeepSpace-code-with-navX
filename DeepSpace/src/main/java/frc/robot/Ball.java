/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class Ball implements ManipulatorMode {
    Talon intakeMotor;
    Talon deployMotor;
    RobotMap robotMap;
    Manipulator manipulator;
    
    //not actually talons
    public Ball (Manipulator manipulator) {
        robotMap = RobotMap.getRobotMap();
        this.manipulator = manipulator;
    }

    public void engage () {
        //get to ball - driver/limelight?
    }

    public void intake () {
        if(manipulator.intakeMode)
        {
            robotMap.talonBallIntake.set(robotMap.getTrigger()); //later on, this will be just a button, but we want to test the motor
        }
//        Timer.delay(3);
        //test timing & speed
//        intakeMotor.set(0);
    }

    public void deploy (boolean rocketMode) {
        if(!manipulator.intakeMode)
        {
            robotMap.talonBallShooter.set(robotMap.getTrigger());
        }
    }

    public void disengage () {

    }
}
