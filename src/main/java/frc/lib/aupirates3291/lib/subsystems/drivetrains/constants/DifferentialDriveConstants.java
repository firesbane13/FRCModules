package frc.lib.aupirates3291.lib.subsystems.drivetrains.constants;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import frc.lib.aupirates3291.constants.RobotConstants;

public class DifferentialDriveConstants {
    // Suppresses default constructor, ensuring non-instantiability.
    private DifferentialDriveConstants() {
    }

    public class DriveMotors {
        // Suppresses default constructor, ensuring non-instantiability.
        private DriveMotors() {
        }

        // Motor inversion
        public static final boolean K_LEFT_MOTORS_INVERTED = true;
        public static final boolean K_RIGHT_MOTORS_INVERTED = false;

        public static final DifferentialDriveKinematics K_DRIVE_KINEMATICS = new DifferentialDriveKinematics(RobotConstants.TRACK_WIDTH);
   
        public static final double K_GEAR_REDUCTION = 7.29;

        // MOI is a measure of an object's resistance to changes in the rotation direction.
        public static final double K_MOI = 7.5;
    }
}