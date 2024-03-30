// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.aupirates3291.lib.subsystems.lighting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.aupirates3291.lib.subsystems.lighting.constants.BlinkenLightning;
import frc.lib.aupirates3291.lib.subsystems.lighting.constants.BlinkenLightning.Colors;
import frc.robot.Constants.Lighting;

public class LightingSubsystem extends SubsystemBase {
  public Spark lighting;

  public final SendableChooser<Colors> lightingChooser = new SendableChooser<>();

  public Colors selectedColor;

  /**
   * Creates a new LightingSubsystem.
   */
  public LightingSubsystem() {
    ShuffleboardTab tab = Shuffleboard.getTab("Lighting");

    // Define Blinken module, currently as a Spark motor controller Servo
    lighting = new Spark(Lighting.lightingPort);

    // Set the default color
    lighting.set(BlinkenLightning.startingColor.getColorValue());

    addOnOffToggle(tab, "Switch");

    addColorSelector(tab);
  }

  public void addColorSelector(ShuffleboardTab tab) {
    List<Colors> colors;
    List<String> colorList = new ArrayList<>();

    // Colors to be displayed
    colorList.add("Solid Colors");
    colorList.add("Fixed Palette Patterns");

    colors = Colors.getColorsByTypeNames(colorList);

    // Add the colors to the SmartDashboard
    lightingChooser.setDefaultOption(BlinkenLightning.startingColor.getColorName(), BlinkenLightning.startingColor);

    for (Colors c : colors) {
      lightingChooser.addOption(c.getColorName(), c);
    }

    // Get the colors by the type names
    tab.add("Color Selector", lightingChooser).withPosition(1, 0).withSize(2, 1);
  }

  public void addOnOffToggle(ShuffleboardTab tab, String label) {
    tab.add(label, false).withWidget(BuiltInWidgets.kToggleButton).withPosition(0, 0)
        .withSize(1, 1).getEntry(label);
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
    this.selectedColor = lightingChooser.getSelected();

    lighting.set(selectedColor.getColorValue());
  }
}
