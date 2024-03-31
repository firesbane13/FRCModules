package frc.lib.aupirates3291.constants;

import edu.wpi.first.math.util.Units;

public class RobotConstants {
    // Suppresses default constructor, ensuring non-instantiability.
    private RobotConstants() {
    }

    // trackWidth is the distance between the left and right wheels of the robot
    public static final double TRACK_WIDTH = Units.inchesToMeters(27);

    public static final double ROBOT_MASS = 60.0; // kg

    public static final double WHEEL_RADIUS = Units.inchesToMeters(3);
}
