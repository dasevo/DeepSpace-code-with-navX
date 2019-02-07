package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.PID.Xpid;
import frc.robot.PID.Ypid;
import frc.robot.PID.Zpid;

public class VisionDrive implements DriveMode{

    RobotMap robotMap;
    DriveTrain driveTrain;
    Xpid xpid;
    Ypid ypid;
    Choosers turnChooser;
    double xValue, yValue, zValue;

    public VisionDrive(RobotMap robotMap, DriveTrain driveTrain)
    {
        this.robotMap = robotMap;
        this.driveTrain = driveTrain;
        xpid = Xpid.getXpid();
        ypid = Ypid.getYpid();
        xpid.xpidSetup();
        ypid.ypidSetup(); //run this only when the robot is started...
    }

    public void driveRobot()
    {
        xpid.xController.enable();
        ypid.yController.enable();
        driveTrain.turnPID.zController.enable();

        xpid.xController.setSetpoint(0);
        ypid.yController.setSetpoint(0);
        driveTrain.turnPID.zController.setSetpoint(driveTrain.turnSetpoint);

        xValue = xpid.getXOutput();
        yValue = ypid.getYOutput();
        zValue = driveTrain.turnPID.getZOutput();

        SmartDashboard.putNumber("turn setpoint in visionDrive", driveTrain.turnPID.zController.getSetpoint());
        robotMap.drive.driveCartesian(-xValue, yValue, zValue);
    }

}