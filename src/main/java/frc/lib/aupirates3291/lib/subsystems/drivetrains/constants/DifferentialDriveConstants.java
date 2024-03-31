package frc.lib.aupirates3291.lib.subsystems.drivetrains.constants;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public class DifferentialDriveConstants {
    // Suppresses default constructor, ensuring non-instantiability.
    private DifferentialDriveConstants() {
    }

    public class DriveMotors {
        // Suppresses default constructor, ensuring non-instantiability.
        private DriveMotors() {
        }

        // Motor ports
        public static final int K_LEFT_FRONT_MOTOR_PORT  = 0;
        public static final int K_LEFT_BACK_MOTOR_PORT   = 1;
        public static final int K_RIGHT_FRONT_MOTOR_PORT = 2;
        public static final int K_RIGHT_BACK_MOTOR_PORT  = 3;

        // Motor inversion
        public static final boolean K_LEFT_MOTORS_INVERTED = true;
        public static final boolean K_RIGHT_MOTORS_INVERTED = false;

        public static final DifferentialDriveKinematics K_DRIVE_KINEMATICS = new DifferentialDriveKinematics(RobotConstants.TRACK_WIDTH);
    }

    public class DriveEncoders {
        // Suppresses default constructor, ensuring non-instantiability.
        private DriveEncoders() {
        }

        // Encoder ports
        public static final int K_LEFT_FRONT_ENCODER_PORT_A = 0;
        public static final int K_LEFT_FRONT_ENCODER_PORT_B = 1;
        public static final int K_LEFT_BACK_ENCODER_PORT_A = 2;
        public static final int K_LEFT_BACK_ENCODER_PORT_B = 3;
        public static final int K_RIGHT_FRONT_ENCODER_PORT_A = 4;
        public static final int K_RIGHT_FRONT_ENCODER_PORT_B = 5;
        public static final int K_RIGHT_BACK_ENCODER_PORT_A = 6;
        public static final int K_RIGHT_BACK_ENCODER_PORT_B = 7;
    }

    public class DriveGyro {
        // Suppresses default constructor, ensuring non-instantiability.
        private DriveGyro() {
        }

        // Gyro port
        public static final int K_GYRO_PORT = 0;
    }
}