package frc.robot;

public class Manipulator
{
    ManipulatorMode manipulatorMode;
    RobotMap robotMap;
    boolean toRocket, intakeMode;

    public Manipulator()
    {
        robotMap = RobotMap.getRobotMap();
    }

    public void manipulatorExecute() //this is kind of mess but we need to start testing, so I made something
    {
        manipulatorMode.disengage();
        manipulatorMode.deploy(toRocket);
        manipulatorMode.engage();
        manipulatorMode.intake();
    }
}