package frc.lib.aupirates3291.constants;

/**
 * Ports
 * 
 * This is used to define and track all ports of the robot.
 * 
 * Since CAN IDs/Ports are configured, I setup all the ones we have
 * defined in the parts inventory.
 * 
 * All other ports will need to be updated accordingly.
 */
public class Ports {
    public enum PortType {
        ANALOG,
        CAN,
        DIO,
        I2C,
        MXP,
        OTHER,
        PNUEMATIC,
        PWM,
        RELAY,
        RS232,
        SPI,
        USB,
    }

    public enum PORTLIST {
        // Analog
        DRIVE_GYROSCOPE(0, PortType.ANALOG),

        // Digital IO
        ENCODER_LEFT_FRONT_A(0, PortType.DIO),
        ENCODER_LEFT_FRONT_B(1, PortType.DIO),
        ENCODER_LEFT_BACK_A(2, PortType.DIO),
        ENCODER_LEFT_BACK_B(3, PortType.DIO),
        ENCODER_RIGHT_FRONT_A(4, PortType.DIO),
        ENCODER_RIGHT_FRONT_B(5, PortType.DIO),
        ENCODER_RIGHT_BACK_A(6, PortType.DIO),
        ENCODER_RIGHT_BACK_B(7, PortType.DIO),

        // CAN
        TALONSRX_40(40, PortType.CAN),
        TALONSRX_41(41, PortType.CAN),
        TALONSRX_42(42, PortType.CAN),
        TALONSRX_43(43, PortType.CAN),

        TALONFX_44(44, PortType.CAN),
        TALONFX_45(45, PortType.CAN),

        SPARKMAX_05(5, PortType.CAN),
        SPARKMAX_06(6, PortType.CAN),
        SPARKMAX_07(7, PortType.CAN),
        SPARKMAX_08(8, PortType.CAN),
        SPARKMAX_09(9, PortType.CAN),
        SPARKMAX_10(10, PortType.CAN),
        SPARKMAX_11(11, PortType.CAN),
        SPARKMAX_12(12, PortType.CAN),
        SPARKMAX_13(13, PortType.CAN),
        SPARKMAX_14(14, PortType.CAN),
        SPARKMAX_15(15, PortType.CAN),
        SPARKMAX_16(16, PortType.CAN),
        SPARKMAX_17(17, PortType.CAN),
        SPARKMAX_18(18, PortType.CAN),
        SPARKMAX_19(19, PortType.CAN),
        SPARKMAX_20(20, PortType.CAN),
        SPARKMAX_21(21, PortType.CAN),
        SPARKMAX_22(22, PortType.CAN),
        SPARKMAX_23(23, PortType.CAN),

        // PWM
        DRIVE_LEFT_FRONT_MOTOR(0, PortType.PWM),
        DRIVE_LEFT_BACK_MOTOR(1, PortType.PWM),
        DRIVE_RIGHT_FRONT_MOTOR(2, PortType.PWM),
        DRIVE_RIGHT_BACK_MOTOR(3, PortType.PWM),

        LIGHTING_PORT(9, PortType.PWM),

        // Relay

        // Pneumatic

        // MXP

        // USB
        PRIMARY_CONTROLLER(0, PortType.USB),
        SECONDARY_CONTROLLER(1, PortType.USB),
        ;

        private final int port;
        private final PortType type;

        /**
         * Constructor for PORTLIST
         * @param port
         * @param type
         */
        PORTLIST(int port, PortType type) {
            this.port = port;
            this.type = type;
        }

        /**
         * Get the port number
         * @return port number
         */
        public int getPort() {
            return port;
        }

        /**
         * Get the port type
         * @return port type
         */
        public PortType getType() {
            return type;
        }
    }
}
