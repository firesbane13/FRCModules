package frc.lib.aupirates3291.lib.subsystems.lighting.constants;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class BlinkenLightingConstants {
  // Suppresses default constructor, ensuring non-instantiability.
  private BlinkenLightingConstants() {
  }

  /**
   * Enum for the different types of colors.
   */
  public enum ColorType {
    SOLIDCOLORS       ("Solid Colors"),    
    FIXEDPALETTE      ("Fixed Palette Patterns"),
    COLOR1PATTERN     ("Color 1 Patterns"),
    COLOR2PATTERN     ("Color 2 Patterns"),
    COLOR1N2PATTERN   ("Color 1 and 2 Patterns");

    public final String colorTypeName;

    /**
     * Constructor for the ColorType enum.
     * 
     * @param colorTypeName The name of the color type.
     */
    ColorType(String colorTypeName) {
      this.colorTypeName = colorTypeName;
    }

    /**
     * Gets the name of the color type.
     * 
     * @return The name of the color type.
     */
    public String getTypeName() {
      return this.colorTypeName;
    }
  }

  /**
   * Enum for the different colors.
   */
  public enum Colors {
      // Solid Colors
      OFF       (ColorType.SOLIDCOLORS, "Off", 0.99),
      ALLIANCE  (ColorType.SOLIDCOLORS, "Alliance", 1.00),
      AQUA      (ColorType.SOLIDCOLORS, "Aqua", 0.81),
      BLUE      (ColorType.SOLIDCOLORS, "Blue", 0.87),
      BLUEGREEN (ColorType.SOLIDCOLORS, "Blue Green", 0.79),
      BLUEVIOLET (ColorType.SOLIDCOLORS, "Blue Violet", 0.89),
      DARKBLUE  (ColorType.SOLIDCOLORS, "Dark Blue", 0.85),
      DARKGRAY  (ColorType.SOLIDCOLORS, "Dark Gray", 0.97),
      DARKGREEN (ColorType.SOLIDCOLORS, "Dark Green", 0.75),
      DARKRED   (ColorType.SOLIDCOLORS, "Dark Red", 0.59),
      GOLD      (ColorType.SOLIDCOLORS, "Gold", 0.67),
      GRAY      (ColorType.SOLIDCOLORS, "Gray", 0.95),
      GREEN     (ColorType.SOLIDCOLORS, "Green", 0.77),
      HOTPINK   (ColorType.SOLIDCOLORS, "Hot Pink", 0.57),
      LAWNGREEN (ColorType.SOLIDCOLORS, "Lawn Green", 0.71),
      LIME      (ColorType.SOLIDCOLORS, "Lime", 0.73),
      ORANGE    (ColorType.SOLIDCOLORS, "Orange", 0.65),
      RED       (ColorType.SOLIDCOLORS, "Red", 0.61),
      REDORANGE (ColorType.SOLIDCOLORS, "Red Orange", 0.63),
      SKYBLUE   (ColorType.SOLIDCOLORS, "Sky Blue", 0.83),
      VIOLET    (ColorType.SOLIDCOLORS, "Violet", 0.91),
      WHITE     (ColorType.SOLIDCOLORS, "White", 0.93),
      YELLOW    (ColorType.SOLIDCOLORS, "Yellow", 0.69),

      // Fixed Palette Patterns
      RAINBOWRAINBOW          (ColorType.FIXEDPALETTE, "Rainbow - Rainbow", -0.99),
      RAINBOWPARTY            (ColorType.FIXEDPALETTE, "Rainbow - Party", -0.97),
      RAINBOWOCEAN            (ColorType.FIXEDPALETTE, "Rainbow - Ocean", -0.95),
      RAINBOWLAVA             (ColorType.FIXEDPALETTE, "Rainbow - Lava", -0.93),
      RAINBOWFOREST           (ColorType.FIXEDPALETTE, "Rainbow - Forest", -0.91),
      RAINBOWGLITTER          (ColorType.FIXEDPALETTE, "Rainbow- Glitter", -0.89),
      CONFETTI                (ColorType.FIXEDPALETTE, "Confetti", -0.87),
      SHOTSRED                (ColorType.FIXEDPALETTE, "Shots - Red", -0.85),
      SHOTSBLUE               (ColorType.FIXEDPALETTE, "Shots - Blue", -0.83),
      SHOTSWHITE              (ColorType.FIXEDPALETTE, "Shots - White", -0.81),
      RAINBOWRAINBOWSINELON   (ColorType.FIXEDPALETTE, "Rainbow - Rainbow Sinelon", -0.79),
      RAINBOWPARTYSINELON     (ColorType.FIXEDPALETTE, "Rainbow - Party Sinelon", -0.77),
      RAINBOWOCEANSINELON     (ColorType.FIXEDPALETTE, "Rainbow - Ocean Sinelon", -0.75),
      RAINBOWLAVASINELON      (ColorType.FIXEDPALETTE, "Rainbow - Lava Sinelon", -0.73),
      RAINBOWFORESTSINELON    (ColorType.FIXEDPALETTE, "Rainbow - Forest Sinelon", -0.71),
      RAINBOWRAINBOWBEATS     (ColorType.FIXEDPALETTE, "Rainbow - Rainbow Beats Per Minute", -0.69),
      RAINBOWPARTYBEATS       (ColorType.FIXEDPALETTE, "Rainbow - Party Beats Per Minute", -0.67),
      RAINBOWOCEANBEATS       (ColorType.FIXEDPALETTE, "Rainbow - Ocean Beats Per Minute", -0.65),
      RAINBOWLAVABEATS        (ColorType.FIXEDPALETTE, "Rainbow - Lava Beats Per Minute", -0.63),
      RAINBOWFORESTBEATS      (ColorType.FIXEDPALETTE, "Rainbow - Forest Beats Per Minute", -0.61),
      FIREMEDIUM              (ColorType.FIXEDPALETTE, "Fire - Medium", -0.59),
      FIRELARGE               (ColorType.FIXEDPALETTE, "Fire - Large", -0.57),
      RAINBOWTWINKLES         (ColorType.FIXEDPALETTE, "Rainbow - Rainbow Twinkles", -0.55),
      RAINBOWTWINKLESPARTY    (ColorType.FIXEDPALETTE, "Rainbow - Party Twinkles", -0.53),
      RAINBOWTWINKLESOCEAN    (ColorType.FIXEDPALETTE, "Rainbow - Ocean Twinkles", -0.51),
      RAINBOWTWINKLESLAVA     (ColorType.FIXEDPALETTE, "Rainbow - Lava Twinkles", -0.49),
      RAINBOWTWINKLESFOREST   (ColorType.FIXEDPALETTE, "Rainbow - Forest Twinkles", -0.47),
      RAINBOWRAINBOWWAVES     (ColorType.FIXEDPALETTE, "Rainbow - Rainbow Color Waves", -0.45),
      RAINBOWPARTYWAVES       (ColorType.FIXEDPALETTE, "Rainbow - Party Color Waves", -0.43),
      RAINBOWOCEANWAVES       (ColorType.FIXEDPALETTE, "Rainbow - Ocean Color Waves", -0.41),
      RAINBOWLAVAWAVES        (ColorType.FIXEDPALETTE, "Rainbow - Lava Color Waves", -0.39),
      RAINBOWFORESTWAVES      (ColorType.FIXEDPALETTE, "Rainbow - Forest Color Waves", -0.37),
      LARSONSCANNERRED        (ColorType.FIXEDPALETTE, "Larson Scanner - Red", -0.35),
      LARSONSCANNERGRAY       (ColorType.FIXEDPALETTE, "Larson Scanner - Gray", -0.33),
      LIGHTCHASERED           (ColorType.FIXEDPALETTE, "Light Chase - Red", -0.31),
      LIGHTCHASEBLUE          (ColorType.FIXEDPALETTE, "Light Chase - Blue", -0.29),
      LIGHTCHASEGRAY          (ColorType.FIXEDPALETTE, "Light Chase - Gray", -0.27),
      HEARTBEATRED            (ColorType.FIXEDPALETTE, "Heartbeat - Red", -0.25),
      HEARTBEATBLUE           (ColorType.FIXEDPALETTE, "Heartbeat - Blue", -0.23),
      HEARTBEATWHITE          (ColorType.FIXEDPALETTE, "Heartbeat - White", -0.21),
      HEARTBEATGRAY           (ColorType.FIXEDPALETTE, "Heartbeat - Gray", -0.19),
      BREATHRED               (ColorType.FIXEDPALETTE, "Breath - Red", -0.17),
      BREATHBLUE              (ColorType.FIXEDPALETTE, "Breath - Blue", -0.15),
      BREATHGRAY              (ColorType.FIXEDPALETTE, "Breath - Gray", -0.13),
      STROBERED               (ColorType.FIXEDPALETTE, "Strobe - Red", -0.11),
      STROBEBLUE              (ColorType.FIXEDPALETTE, "Strobe - Blue", -0.09),
      STROBEGOLD              (ColorType.FIXEDPALETTE, "Strobe - Gold", -0.07),
      STROBEWHITE             (ColorType.FIXEDPALETTE, "Strobe - White", -0.05),
      
      // Color 1 Patterns
      ENDTOENDBLENDTOBLACK1    (ColorType.COLOR1PATTERN, "End to End Blend to Black - Color 1", -0.03),
      LARSONSCANNER1           (ColorType.COLOR1PATTERN, "Larson Scanner - Color 1", -0.01),
      LIGHTCHASE1              (ColorType.COLOR1PATTERN, "Light Chase - Blue - Color 1", 0.01),
      HEARTBEATSLOW1           (ColorType.COLOR1PATTERN, "Heartbeat - Slow - Color 1", 0.03),
      HEARTBEATMEDIUM1         (ColorType.COLOR1PATTERN, "Heartbeat - Medium - Color 1", 0.05),
      HEARTBEATFAST1           (ColorType.COLOR1PATTERN, "Heartbeat - Fast - Color 1", 0.07),
      BREATHSLOW1              (ColorType.COLOR1PATTERN, "Breath - Slow - Color 1", 0.09),
      BREATHFAST1              (ColorType.COLOR1PATTERN, "Breath - Fast - Color 1", 0.11),
      SHOT1                    (ColorType.COLOR1PATTERN, "Shot - Color 1", 0.13),
      STROBE1                  (ColorType.COLOR1PATTERN, "Strobe - Color 1", 0.15),

      // Color 2 Patterns
      ENDTOENDBLENDTOBLACK2    (ColorType.COLOR2PATTERN, "End to End Blend to Black - Color 2", 0.17),
      LARSONSCANNER2           (ColorType.COLOR2PATTERN, "Larson Scanner - Color 2", 0.19),
      LIGHTCHASE2              (ColorType.COLOR2PATTERN, "Light Chase - Blue - Color 2", 0.21),
      HEARTBEATSLOW2           (ColorType.COLOR2PATTERN, "Heartbeat - Slow - Color 2", 0.23),
      HEARTBEATMEDIUM2         (ColorType.COLOR2PATTERN, "Heartbeat - Medium - Color 2", 0.25),
      HEARTBEATFAST2           (ColorType.COLOR2PATTERN, "Heartbeat - Fast - Color 2", 0.27),
      BREATHSLOW2              (ColorType.COLOR2PATTERN, "Breath - Slow - Color 2", 0.29),
      BREATHFAST2              (ColorType.COLOR2PATTERN, "Breath - Fast - Color 2", 0.31),
      SHOT2                    (ColorType.COLOR2PATTERN, "Shot - Color 2", 0.33),
      STROBE2                  (ColorType.COLOR2PATTERN, "Strobe - Color 2", 0.35),

      // Color 1 and 2 Patterns
      SPARKLE1N2               (ColorType.COLOR1N2PATTERN, "Sparkle - Color 1 and 2", 0.37),
      SPARKLE2N1               (ColorType.COLOR1N2PATTERN, "Sparkle - Color 2 and 1", 0.39),
      COLORGRADIENT1N2         (ColorType.COLOR1N2PATTERN, "Color Gradient - Color 1 and 2", 0.41),
      BEATSPERMINUTE1N2        (ColorType.COLOR1N2PATTERN, "Beats Per Minute - Color 1 and 2", 0.43),
      ENDTOENDBLEND1N2         (ColorType.COLOR1N2PATTERN, "End to End Blend - Color 1 and 2", 0.45),
      ENDTOENDBLEND            (ColorType.COLOR1N2PATTERN, "End to End Blend", 0.47),
      COLOR1N2NOBLEND          (ColorType.COLOR1N2PATTERN, "Color 1 and 2 No Blend", 0.49),
      TWINKLES1N2              (ColorType.COLOR1N2PATTERN, "Twinkles - Color 1 and 2", 0.51),
      COLORWAVES1N2            (ColorType.COLOR1N2PATTERN, "Color Waves - Color 1 and 2", 0.53),
      SINELON1N2               (ColorType.COLOR1N2PATTERN, "Sinelon - Color 1 and 2", 0.55),
      ;

      public final ColorType type;
      public final String colorName;
      public final double colorValue;

      /**
       * Constructor for the Colors enum.
       * 
       * @param type The type of color.
       * @param colorName The name of the color.
       * @param colorValue The value of the color.
       */
      Colors(ColorType type, String colorName, double colorValue) {
        this.type = type;
        this.colorName = colorName;
        this.colorValue = colorValue;
      } 

      /**
       * Gets the type of the color.
       * 
       * @return The type of the color.
       */
      public ColorType getType() {
        return this.type;
      }

      /**
       * Gets the name of the color.
       * 
       * @return The name of the color.
       */
      public String getColorName() {
        return this.colorName;
      }

      /**
       * Gets the value of the color.
       * 
       * @return The value of the color.
       */
      public double getColorValue() {
        return this.colorValue;
      }

      /**
       * Gets the color by the name.
       * 
       * @param colorName The name of the color.
       * @return The color.
       */
      public static Colors getColorByName(String colorName) {
        for (Colors c : Colors.values()) {
          if (c.getColorName().equals(colorName)) {
            return c;
          }
        }

        return Colors.OFF;
      }

      /**
       * Gets the color by the value.
       * 
       * @param colorValue The value of the color.
       * @return The color.
       */
      public static List<Colors> getColorsByType(ColorType type) {
        List<Colors> colors = new ArrayList<>();
        for (Colors c : Colors.values()) {
          if (c.getType() == type) {
            colors.add(c);
          }
        }
        return colors;
      }
      
      /**
       * Gets the color by the value.
       * 
       * @param colorValue The value of the color.
       * @return The color.
       */
      public static List<Colors> getColorsByTypeNames(List<String> colorTypeNames) {
          List<Colors> colorsOfTypes = new ArrayList<>();
          for (Colors color : Colors.values()) {
              if (colorTypeNames.contains(color.getType().getTypeName())) {
                  colorsOfTypes.add(color);
              }
          }
          return colorsOfTypes;
      }
  }

  /**
   * Sets the default color of the lighting chooser.
   * 
   * @param lightingChooser The lighting chooser to set the default color of.
   * @param lightingChooserEntry The lighting chooser entry to set the default color of.
   * @param color The color to set the default color to.
   */
  public static void setDefaultColor(
    SendableChooser<Colors> lightingChooser, 
    GenericEntry lightingChooserEntry,
    Colors color
  ) {
    // Set the new color in the dropdown
    lightingChooser.setDefaultOption(color.getColorName(), color);

    /**
     *  Set the new color in the text entry.  
     * 
     *  NOTE: This is needed to update the Shuffleboard to reflect the new color.
     *        Dropdowns don't seem to update selected option currently
     */
    lightingChooserEntry.setString(color.getColorName());

    // Update the Shuffleboard to reflect chooser changes
    Shuffleboard.update();
  }
  
  public static final Colors startingColor = Colors.OFF; 
}
