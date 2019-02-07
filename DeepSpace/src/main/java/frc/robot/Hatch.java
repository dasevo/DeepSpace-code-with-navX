/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;

public class Hatch implements ManipulatorMode {
    RobotMap robotMap;
    boolean manipulatorOut;
    Manipulator manipulator;
    Timer coneIn;

    public Hatch(Manipulator manipulator) {
        robotMap = RobotMap.getRobotMap();
        this.manipulator = manipulator;
        manipulatorOut = false;
    }

    public void engage () {
        //extend hatch deploy thing
        if(robotMap.bumperR.get()&&!manipulatorOut)
        {
            manipulatorOut = true;
//            robotMap.hatchExtendL.set(DoubleSolenoid.Value.kForward);
//            robotMap.hetchExtendR.set(DoubleSolenoid.Value.kForward);
        }
        if(robotMap.bumperR.get()&&manipulatorOut)
        {
//        robotMap.hatchDeploy.set(true);
        }
    }

    public void intake () {
        //nothing, for now
    }

    public void deploy (boolean rocketMode) {
        if(robotMap.bumperR.get()&&manipulatorOut)
        {
            coneIn.reset();
            coneIn.start();
//            robotMap.hatchDeploy.set(true);
        }
        if(coneIn.get()>2)
        {
            coneIn.stop();
            coneIn.reset();
//            robotMap.hatchDeploy.set(false);
        }
    }

    public void disengage () {
        if(robotMap.bumperL.get())
        {

//            robotMap.hatchExtendR.set(DoubleSolenoid.Value.kReverse);
//            robotMap.hatchExtendL.set(DoubleSolenoid.Value.kReverse);
        }
    }

}
