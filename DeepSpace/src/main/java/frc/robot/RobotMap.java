/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
public class RobotMap {
    
    public final WPI_TalonSRX talonFL =  new WPI_TalonSRX (4); //4
    public final WPI_TalonSRX talonFR =  new WPI_TalonSRX (3); //2
    public final WPI_TalonSRX talonBL =  new WPI_TalonSRX (2); 
    public final WPI_TalonSRX talonBR =  new WPI_TalonSRX (1);
	public final WPI_TalonSRX talonBallIntake = new WPI_TalonSRX (5);
	public final WPI_TalonSRX talonBallShooter = new WPI_TalonSRX(6);

    public final MecanumDrive drive = new MecanumDrive(talonFL, talonBL, talonFR, talonBR);

    public final AHRS ahrs = new AHRS (SPI.Port.kMXP);

    public final AnalogInput encoder0 = new AnalogInput(0);
    public final AnalogInput encoder1 = new AnalogInput(1);
    public final AnalogInput encoder2 = new AnalogInput(2);

//    public final DoubleSolenoid hatchExtendL = new DoubleSolenoid(1,2,3);
//    public final DoubleSolenoid hatchExtendR = new DoubleSolenoid(1,4,5);
//	public final Solenoid hatchDeploy = new Solenoid(1);

//    public final Compressor mainC = new Compressor(0);


    //XboxController

	XboxController controller = new XboxController(0);
	
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
    
    private static RobotMap robotMap;
   

    private RobotMap ()
    {
		talonSetup(talonFL);
		talonSetup(talonBL);
		talonSetup(talonBR);
		talonSetup(talonFR);
		talonSetup(talonBallIntake);
		talonSetup(talonBallShooter);
    }
    
    public static RobotMap getRobotMap()
    {
        if (robotMap == null)
        {
            robotMap = new RobotMap();
        }

        return robotMap;
	}
	
	public void talonSetup(WPI_TalonSRX talon)
	{
		talon.configNominalOutputForward(0, Constants.timeOutMs);
		talon.configNominalOutputReverse(0, Constants.timeOutMs);
		talon.configPeakOutputForward(1, Constants.timeOutMs);
		talon.configPeakOutputReverse(-1, Constants.timeOutMs);
		talon.configAllowableClosedloopError(0, 0, Constants.timeOutMs);
		talon.configNeutralDeadband(0.05, Constants.timeOutMs); 
		talon.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
		talon.setInverted(false);

		// Peak current and duration must be exceeded before corrent limit is activated.
		// When activated, current will be limited to continuous current.
		// Set peak current params to 0 if desired behavior is to immediately
		// current-limit.
		talon.enableCurrentLimit(true);
		talon.configContinuousCurrentLimit(30, Constants.timeOutMs); // Must be 5 amps or more
		talon.configPeakCurrentLimit(30, Constants.timeOutMs); // 100 A
		talon.configPeakCurrentDuration(200, Constants.timeOutMs); // 200 ms
	}
	
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
	
	public double getLeftX()
	{
		return -deadzone(controller.getX(Hand.kLeft));
	}
	
	public double getLeftY()
	{
		return deadzone(controller.getY(Hand.kLeft));
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
