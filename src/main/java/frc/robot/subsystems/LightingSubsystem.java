// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Lighting;
import frc.robot.Constants.Lighting.Colors;

public class LightingSubsystem extends SubsystemBase {
  public Spark lighting;

  public final SendableChooser<Lighting.Colors> lighting_chooser = new SendableChooser<>();

  /**
   * Creates a new LightingSubsystem.
   */
  public LightingSubsystem() {
    lighting = new Spark(Lighting.lightingPort);

    lighting.set(Lighting.startingColor.getColorValue());

    lighting_chooser.setDefaultOption(Lighting.startingColor.getColorName(), Lighting.startingColor);
  
    for (Colors c : Colors.values()) {
      lighting_chooser.addOption(c.getColorName(), c);
    }

    SmartDashboard.putData("Alliance", lighting_chooser);
  }

  /**
   * Disables the lighting
   */
  public void disable() {
    lighting.set(Colors.OFF.getColorValue());
  }

  /**
   * Sets the lighting to the alliance color
   */
  public void setAllianceColor() {
    Optional<Alliance> alliance = DriverStation.getAlliance();

    // Set the lighting to the alliance color
    if (alliance.isPresent()) {
      if (alliance.get() == Alliance.Blue) {
        lighting.set(Colors.BLUE.getColorValue());
      } else if (alliance.get() == Alliance.Red) {
        lighting.set(Colors.RED.getColorValue());
      } else {
        lighting.set(Colors.OFF.getColorValue());
      }
    } else {
      lighting.set(Colors.OFF.getColorValue());
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Colors selectedColor = lighting_chooser.getSelected();

    lighting.set(selectedColor.getColorValue());
  }
}
