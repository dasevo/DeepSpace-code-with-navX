package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;

public class Vision // just a testing class, will be implemented in a different way
{
    
    Timer doublePress = new Timer();
    double camMode = 0;
    double lightMode = 0;

    public Vision()
    {
        doublePress.start();
    }

    public void execute()
    {
        if(getPressed(buttonA))
        {
            if(camMode==0)
            {
                camMode = 1;
            }
            else
            {
                camMode = 0;
            }
            NetworkTableInstance.getDefault().getTable("limelight-one").getEntry("camMode").setNumber(camMode);
        }

        if(getPressed(buttonB))
        {
            if(lightMode==0)
            {
                lightMode = 1;
            }
            else if(lightMode==1)
            {
                lightMode = 2;
            }
            else if(lightMode==2)
            {
                lightMode = 3;
            }
            else if(lightMode==3)
            {
                lightMode = 0;
            }
            NetworkTableInstance.getDefault().getTable("limelight-one").getEntry("ledMode").setNumber(lightMode);
        }
    }

    public boolean getPressed(JoystickButton button)
    {
        if(button.get()&&doublePress.get()>=0.25)
        {
            doublePress.reset();
            doublePress.start();
            return true;
        }
        else
        {
            return false;
        }
    }

    XboxController controller = new XboxController(1);
	
	final static int aButton = 1;
	final static int bButton = 2;
	final static int xButton = 3;
	final static int yButton = 4;
	final static int leftBumper = 5;
	final static int rightBumper = 6;
	final static int backButton = 7;
	final static int startButton = 8;
	final static int lStickButton = 9;
	final static int rStickButton = 10;
	final static int lStickXAxis = 0;
	final static int lStickYAxis = 1;
	final static int lTriggerAxis = 2;
	final static int rTriggerAxis = 3;
	final static int rStickXAxis = 4;
	final static int rStickYAxis = 5;
	final static double deadzone = 0.2;
	
	public final JoystickButton buttonA = new JoystickButton(controller, aButton);
	public final JoystickButton buttonB = new JoystickButton(controller, bButton);
	public final JoystickButton buttonX = new JoystickButton(controller, xButton);
	public final JoystickButton buttonY = new JoystickButton(controller, yButton);
	public final JoystickButton bumperL = new JoystickButton(controller, leftBumper);
	public final JoystickButton bumperR = new JoystickButton(controller, rightBumper);
	public final JoystickButton backB = new JoystickButton(controller, backButton);	
	public final JoystickButton startB = new JoystickButton(controller, startButton);
	public final JoystickButton leftStickB = new JoystickButton(controller, lStickButton);
	public final JoystickButton rightStickB = new JoystickButton(controller, rStickButton);
	
	public double deadzone(double input)
	{
		if(Math.abs(input)>deadzone)
		{
			return input;
		}
		else
		{
			return 0;
		}
	}
	
	public double getLeftY()
	{
		return -deadzone(controller.getY(Hand.kLeft));
	}
	
	public double getLeftX()
	{
		return -deadzone(controller.getX(Hand.kLeft));
	}
	
	public double getRightY()
	{
		return -deadzone(controller.getY(Hand.kRight));
	}
	
	public double getRightX()
	{
		return deadzone(controller.getX(Hand.kRight));
	}
	
	public double getTrigger()
	{
		if(controller.getTriggerAxis(Hand.kRight)>0)
		{
			return deadzone(controller.getTriggerAxis(Hand.kRight));
		}
		else if(controller.getTriggerAxis(Hand.kLeft)>0)
		{
			return -deadzone(controller.getTriggerAxis(Hand.kLeft));
		}
		else
		{
			return 0.0;
        }
    }
}