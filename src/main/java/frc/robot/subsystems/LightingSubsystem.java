// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Lighting;
import frc.lib.aupirates3291.constants.BlinkenConstants;
import frc.lib.aupirates3291.constants.BlinkenConstants.Colors;

public class LightingSubsystem extends SubsystemBase {
  public Spark lighting;

  public final SendableChooser<Colors> lighting_chooser = new SendableChooser<>();

  public Colors selectedColor;

  /**
   * Creates a new LightingSubsystem.
   */
  public LightingSubsystem() {
    ShuffleboardTab tab = Shuffleboard.getTab("Lighting");

    // Define Blinken module, currently as a Spark motor controller Servo
    lighting = new Spark(Lighting.lightingPort);

    // Set the default color
    lighting.set(BlinkenConstants.startingColor.getColorValue());

    addColorSelector(tab);
    
    addOnOffToggle(tab, "Lighting On/Off");
  }

  public void addColorSelector(ShuffleboardTab tab) {
    List<Colors> colors;
    List<String> colorList = new ArrayList<>();

    // Colors to be displayed
    colorList.add("Solid Colors");
    colorList.add("Fixed Palette Patterns");

    colors = Colors.getColorsByTypeNames(colorList);
    
    // Add the colors to the SmartDashboard
    lighting_chooser.setDefaultOption(BlinkenConstants.startingColor.getColorName(), BlinkenConstants.startingColor);
  
    for (Colors c : colors) {
      lighting_chooser.addOption(c.getColorName(), c);
    }

    // Get the colors by the type names
    colors = Colors.getColorsByTypeNames(colorList);
    tab.add("Color Selector", lighting_chooser)
      .withPosition(0, 0)
      .withSize(2, 1);
  }

  public void addOnOffToggle(ShuffleboardTab tab, String name) {
    tab.add(name, false)
      .withWidget(BuiltInWidgets.kToggleSwitch)
      .withPosition(0, 1)
      .withSize(1, 1)
      ;
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
    this.selectedColor = lighting_chooser.getSelected();

    lighting.set(selectedColor.getColorValue());
  }
}
