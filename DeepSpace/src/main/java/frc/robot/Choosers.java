package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.PID.Zpid;

public class Choosers{

    RobotMap robotMap;
    boolean toRocket, intakeMode, ballManipulator;
    Timer buttonTime, ballTime, manipulatorModeTime;
    DriveTrain driveTrain;
    Manipulator manipulator;

    public Choosers(DriveTrain driveTrain, Manipulator manipulator)
    {
        robotMap = RobotMap.getRobotMap();

        this.driveTrain = driveTrain;
        driveTrain.driveMode = new ManualDrive(robotMap, driveTrain);
        this.manipulator = manipulator;
        manipulator.manipulatorMode = new Ball(manipulator);

        toRocket = false;
        intakeMode = false;
        ballManipulator = false;

        buttonTime = new Timer();
        buttonTime.start();
        ballTime = new Timer();
        ballTime.start();
        manipulatorModeTime = new Timer();
        manipulatorModeTime.start();
    }

    public void setDriveMode()
    {
        if(robotMap.buttonA.get())
        {
            driveTrain.driveMode = new ManualDrive(robotMap, driveTrain);
        }
        if(robotMap.buttonB.get())//&&NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0)>0)
        {
            driveTrain.driveMode = new VisionDrive(robotMap, driveTrain);
        }
        if(robotMap.buttonX.get())
        {
            driveTrain.driveMode =  new LineDrive(robotMap);
        }
    }

    public void angleSwitch()
    {
        if(robotMap.backB.get()&&(buttonTime.get()>=0.25))
        {
            buttonTime.reset();
            buttonTime.start();
            toRocket=!toRocket;
        }
        manipulator.toRocket = toRocket;
    }

    public void automatedTurnToAngle (){
        angleSwitch();
        if(!toRocket){
            if((robotMap.controller.getPOV()) == 0) { 
                driveTrain.turnPID.zController.setSetpoint(0);
                driveTrain.turnPID.zController.enable();
                driveTrain.turnSetpoint = 0;
            }
            else if((robotMap.controller.getPOV()) == 90) { 
                driveTrain.turnPID.zController.setSetpoint(90);
                driveTrain.turnPID.zController.enable();
                driveTrain.turnSetpoint = 90;
            }
            else if ((robotMap.controller.getPOV()) == 180) { 
                driveTrain.turnPID.zController.setSetpoint(180);
                driveTrain.turnPID.zController.enable();
                driveTrain.turnSetpoint = 180;
            }
            else if((robotMap.controller.getPOV()) == 270) { 
                driveTrain.turnPID.zController.setSetpoint(-90);
                driveTrain.turnPID.zController.enable();
                driveTrain.turnSetpoint = -90;
            }
        }
        else if(toRocket){
            if(robotMap.controller.getPOV() == 45) { 
                driveTrain.turnPID.zController.setSetpoint(29);
                driveTrain.turnPID.zController.enable();
                driveTrain.turnSetpoint = 29;
            }
            else if(robotMap.controller.getPOV() == 315) { 
                driveTrain.turnPID.zController.setSetpoint(-29);
                driveTrain.turnPID.zController.enable();
                driveTrain.turnSetpoint = -29;
            }
            else if(robotMap.controller.getPOV() == 135){
                driveTrain.turnPID.zController.setSetpoint(151);
                driveTrain.turnPID.zController.enable();
                driveTrain.turnSetpoint = 151;
            }
            else if(robotMap.controller.getPOV() == 225) {
                driveTrain.turnPID.zController.setSetpoint(-151);
                driveTrain.turnPID.zController.enable();
                driveTrain.turnSetpoint = -151;
            }
        }
    }

    public void shootHighSwitch()
    {
        if(robotMap.startB.get()&&(ballTime.get()>=0.25))
        {
            ballTime.reset();
            ballTime.start();
            intakeMode = !intakeMode;
        }
        manipulator.intakeMode = intakeMode;
    }



    public void setManipulatorMode()
    {
        if(robotMap.buttonY.get()&&manipulatorModeTime.get()>=0.25)
        {
            ballManipulator = !ballManipulator;
            manipulatorModeTime.reset();
            manipulatorModeTime.start();
            if(ballManipulator)
            {
                manipulator.manipulatorMode = new Ball(manipulator);
            }
            else if(!ballManipulator)
            {
                manipulator.manipulatorMode = new Hatch(manipulator);
            }
        }
    }
}