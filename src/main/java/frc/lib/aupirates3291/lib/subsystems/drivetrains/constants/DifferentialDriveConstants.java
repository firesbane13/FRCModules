package frc.lib.aupirates3291.lib.subsystems.drivetrains.constants;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public class DifferentialDriveConstants {
    // Suppresses default constructor, ensuring non-instantiability.
    private DifferentialDriveConstants() {
    }

    // Motor ports
    public static final int K_LEFT_MOTOR_1_PORT = 0;
    public static final int K_LEFT_MOTOR_2_PORT = 1;
    public static final int K_RIGHT_MOTOR_1_PORT = 2;
    public static final int K_RIGHT_MOTOR_2_PORT = 3;

    // Motor inversion
    public static final boolean K_LEFT_MOTORS_INVERTED = false;
    public static final boolean K_RIGHT_MOTORS_INVERTED = false;

    public static final DifferentialDriveKinematics K_DRIVE_KINEMATICS = new DifferentialDriveKinematics(RobotConstants.TRACK_WIDTH);
}