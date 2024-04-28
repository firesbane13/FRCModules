package frc.lib.aupirates3291.helper;

import org.littletonrobotics.urcl.URCL;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import frc.lib.aupirates3291.constants.ControllerLayout;
import frc.lib.aupirates3291.lib.subsystems.drivetrains.DifferentialDriveSubsystemV1;

import static edu.wpi.first.units.Units.Volts;

public class SystemIdentification {
    enum TestType {
        QUASI_STATIC, DYNAMIC
    }

    enum Direction {
        FORWARD, REVERSE
    }

    SysIdRoutine routine;

    /**
     * This class is used to identify the system.
     */
    public SystemIdentification() {
        // Empty constructor
    }

    /**
     * This method is used to identify the system periodically.
     * 
     * Use: Call this method in the robotPeriodic() method in Robot.java
     */
    public void identificationPeriodic() {
        // Call this method in the robotPeriodic() method in Robot.java
    }

    /**
     * This method requires Mechanical Advantage's AdvantageScope URCL to be
     * installed: https://github.com/Mechanical-Advantage/AdvantageScope/blob/main/docs/REV-LOGGING.md#setup
     * 
     * This method initializes the logging system for the robot.
     * 
     * Use: Call this method in the robotInit() method in Robot.java first thing.
     */
    public static void loggingInit() {
        DataLogManager.start();
        URCL.start();
    }

    /**
     * This method initializes the system identification routine.
     * 
     * @param driveTrain The drive train subsystem
     * @param additionalSubsystems Additional subsystems to be identified
     */
    public void identficationInit(
        DifferentialDriveSubsystemV1 driveTrain
        // Add additional subsystems here
    ) {

        routine = new SysIdRoutine(
            new SysIdRoutine.Config(),
            new SysIdRoutine.Mechanism(
                voltage -> driveTrain.voltageDrive(voltage.in(Volts), voltage.in(Volts)), 
                driveTrain::logDrive, 
                driveTrain
            )
        );
    }

    public CommandJoystick configureBindings(CommandJoystick controller) {
        controller.button(ControllerLayout.ButtonList.A).toggleOnTrue(
            identificationTest(TestType.QUASI_STATIC, Direction.FORWARD)
        );

        controller.button(ControllerLayout.ButtonList.B).toggleOnTrue(
            identificationTest(TestType.QUASI_STATIC, Direction.REVERSE)
        );

        controller.button(ControllerLayout.ButtonList.X).toggleOnTrue(
            identificationTest(TestType.DYNAMIC, Direction.FORWARD)
        );

        controller.button(ControllerLayout.ButtonList.Y).toggleOnTrue(
            identificationTest(TestType.DYNAMIC, Direction.REVERSE)
        );

        return controller;
    }

    /**
     * This method is used to identify the system.
     * 
     * @param testType The type of test to run
     * @param direction The direction to run the test
     */
    public Command identificationTest(TestType testType, Direction direction) {
        Command command = null; 

        if (testType == TestType.QUASI_STATIC) {
            if (direction == Direction.FORWARD) {
                routine.quasistatic(SysIdRoutine.Direction.kForward);
            } else if (direction == Direction.REVERSE) {
                routine.quasistatic(SysIdRoutine.Direction.kReverse);
            }
        } else if (testType == TestType.DYNAMIC) {
            if (direction == Direction.FORWARD) {
                routine.dynamic(SysIdRoutine.Direction.kForward);
            } else if (direction == Direction.REVERSE) {
                routine.dynamic(SysIdRoutine.Direction.kReverse);
            }
        }

        return command;
    }
}