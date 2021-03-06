package frc.robot.PID;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.networktables.*;

public class XpidSource implements PIDSource{

    static double xDist, tx;

    public XpidSource()
    {

    }

    public PIDSourceType getPIDSourceType()
    {
        return PIDSourceType.kDisplacement;
    }

    public void setPIDSourceType(PIDSourceType source)
    {

    }

    public static double radiansToDegrees(double theta) {
        double degrees = theta * (180 / Math.PI);
        return degrees;
    }

    public static double degreesToRadians(double theta) {
        double radians = theta * (Math.PI / 180);
        return radians;
    }

    public double pidGet()
    {
        xDist = getDistance();
        return xDist;
    }

    public double getDistance()
    {
//        double ty = NetworkTableInstance.getDefault().getTable("limelight-one").getEntry("ty").getDouble(0);
        double tx = NetworkTableInstance.getDefault().getTable("limelight-one").getEntry("tx").getDouble(0);

//        double dist = Math.tan(degreesToRadians(tx))*((Constants.h2 - Constants.h1) / Math.tan(degreesToRadians(Constants.alphaYOne + ty)));
//        SmartDashboard.putNumber("xDistance", dist);
        
        return tx;
    }
}