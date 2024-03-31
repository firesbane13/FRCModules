package frc.lib.aupirates3291.helper;

import java.util.List;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.lib.aupirates3291.lib.subsystems.lighting.constants.BlinkenLightningConstants.Colors;

public class ShuffleboardHelper {
    // Suppresses default constructor, ensuring non-instantiability.
    private ShuffleboardHelper() {
    }

    /**
     * Adds an on/off toggle to the Shuffleboard.
     * 
     * @param tab       The tab to add the on/off toggle to.
     * @param name      The name of the on/off toggle.
     * @param defaultValue  The default value of the on/off toggle.
     * @param position  The position of the on/off toggle. (Column, Row)
     * @param size      The size of the on/off toggle.  (Width, Height)
     * @return          The GenericEntry of the on/off toggle.
     */
    public static GenericEntry addOnOffToggle(
        ShuffleboardTab tab, 
        String name, 
        Boolean defaultValue, 
        List<Integer> position, // Column, Row
        List<Integer> size      // Width, Height
    ) {
        return tab.add(name, defaultValue)
            .withWidget(BuiltInWidgets.kToggleButton)
            .withPosition(position.get(0), position.get(1))
            .withSize(size.get(0), size.get(1))
            .getEntry();
        
    } 

    /**
     * Adds a chooser to the Shuffleboard.
     * 
     * @param tab       The tab to add the chooser to.
     * @param name      The name of the chooser.
     * @param defaultValue  The default value of the chooser.
     * @param position  The position of the chooser. (Column, Row)
     * @param size      The size of the chooser.  (Width, Height)
     * @return          The GenericEntry of the chooser.
     */
    public static GenericEntry addChooser(
        ShuffleboardTab tab, 
        String name, 
        SendableChooser<?> defaultValue, 
        List<Integer> position, // Column, Row
        List<Integer> size      // Width, Height
    ) {
        tab.add(name, defaultValue)
            .withWidget(BuiltInWidgets.kComboBoxChooser)
            .withPosition(position.get(0), position.get(1))
            .withSize(size.get(0), size.get(1));

        // Return a text entry of the chooser
        return tab.add(name + " Selected", Colors.OFF.getColorName())
            .withPosition(position.get(0), position.get(1) + 1)
            .withSize(size.get(0), size.get(1))
            .getEntry();
    }


}
