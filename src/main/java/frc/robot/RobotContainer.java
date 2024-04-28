// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.lib.aupirates3291.constants.Ports.PORTLIST;
import frc.lib.aupirates3291.helper.SystemIdentification;
import frc.lib.aupirates3291.lib.subsystems.drivetrains.DifferentialDriveSubsystemV1;
import frc.lib.aupirates3291.lib.subsystems.lighting.LightingSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private DifferentialDriveSubsystemV1 driveSubsystem = new DifferentialDriveSubsystemV1();
  private LightingSubsystem lightingSubsystem = new LightingSubsystem();
  private SystemIdentification systemIdentification = new SystemIdentification();

  private SendableChooser<Command> chooser = new SendableChooser<>();
    
  // JOYSTICKS
  private CommandJoystick controller00 = new CommandJoystick(PORTLIST.PRIMARY_CONTROLLER.getPort());
  private CommandJoystick controller01 = new CommandJoystick(PORTLIST.SECONDARY_CONTROLLER.getPort());

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    systemIdentification.identficationInit(driveSubsystem);

    lightingSubsystem.init();

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Configure the button bindings

    // Configure the system identification buttons
    controller00 = systemIdentification.configureBindings(controller00);

    driveSubsystem.setDefaultCommand(
      new RunCommand(
        () ->
        driveSubsystem.drive(
          controller00.getRawAxis(1),
          controller01.getRawAxis(1)
        ),
        driveSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return chooser.getSelected();
  }

  public DifferentialDriveSubsystemV1 getDriveSubsystem() {
    return driveSubsystem;
  }
}
