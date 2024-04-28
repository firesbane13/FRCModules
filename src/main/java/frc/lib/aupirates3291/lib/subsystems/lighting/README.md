# Team 3291 - Au Pirates - Blinken Lighting Subsystem

## Description

This subsystem is to make using Blinken lighting easy.   It includes all the colors implemented by the Blinken system in an easy to use wrapper.

## Installation

Copy the following items to the same location in your FRC project.   We'll work on making this easier to install in the future.   In the meantime, the fastest way to install is:

* Copy lib directory from this project into your project's java/frc directory

If you only want the LightningSubsystem, then you'll have copy more specifically:

* lib/aupirates3291/constants/Ports.java into the same directory in your java/frc.   So this would be java/frc/lib/aupirates3291/constants/Ports.java
* lib/aupirates3291/lib/subsystems/lighting into the same directory in your java/frSo this would be java/frc/lib/aupirates3291/lib/subsystems/lighing
* lib/aupirates/helper/ShuffleboardHelper.java to java/frc/lib/aupirates3291/helper in your project.

Once you have the files installed, to use the LightningSubsystem do the following:

1) In RobotContainer, add the following between the "public class RobotContainer" and the constructor "public RobotContainer":

    private LightingSubsystem lightingSubsystem = new LightingSubsystem();

2) In the RobotContainer constructor "public RobotContainer()" add the following line:

    lightingSubsystem.init();

This will create the subsystem and setup the ShuffleBoard to allow selection of colors in any mode.

## Configuration Options

### Color Choices

Out of the box it only addes 2 sets of the Blinken color list to the dropdown in Shuffleboard.   If you want to change those, you need to go into LightingSubsystem's addColorSelector() method.

In there is a colorList List variable.   To remove groups from the list, just remove the desired colorList.add() method call.    To add groups to the list, add colorList.add(ColorType);   Replace ColorType with one of the colorTypeNames from the BlinkenLightingConstants.java file in lighting/constants directory.

### Using a Specific Color

You can use lighting.setLighting(nameOfColor);    Replace nameOfColor with the string of the color name:

For example:
    // Set the lighting to be Fire - Large
    lighting.setLighting("Fire - Large");