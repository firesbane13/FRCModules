package frc.lib.aupirates3291.constants;

public class ShuffleboardGrid {
    public enum Tabs {
        DIFFERENTIAL_DRIVE_TAB("Differential"),
        LIGHTING_TAB("Lighting"),;

        private String tabName;

        Tabs(String tabName) {
            this.tabName = tabName;
        }

        public String getTabName() {
            return tabName;
        }
    }

    public enum ShuffleboardTypes {
        K3_AXIS_ACCELEROMETER("k3AxisAccelerometer"),
        K_ACCELEROMETER("kAccelerometer"),
        K_BOOLEAN_BOX("kBooleanBox"),
        K_CAMERA_STREAM("kCameraStream"),
        K_COMBO_BOX("kComboBox"),
        K_COMMAND("kCommand"),
        K_DIAL("kDial"),
        K_DIFFERENTIAL_DRIVE("kDifferentialDrive"),
        K_ENCODER("kEncoder"),
        K_FIELD("kField"),
        K_GRAPH("kGraph"),
        K_GYRO("kGyro"),
        K_MECANUM_DRIVE("kMecanumDrive"),
        K_MOTOR_CONTROLLER("kMotorController"),
        K_NUMBER_BAR("kNumberBar"),
        K_NUMBER_SLIDER("kNumberSlider"),
        K_PID_COMMAND("kPIDCommand"),
        K_PID_CONTROLLER("kPIDController"),
        K_POWER_DISTRIBUTION("kPowerDistribution"),
        K_RELAY("kRelay"),
        K_SPLIT_BUTTON_CHOOSER("kSplitButtonChooser"),
        K_TEXT_VIEW("kTextView"),
        K_TOGGLE_BUTTON("kToggleButton"),
        K_TOGGLE_SWITCH("kToggleSwitch"),
        K_VOLTAGE("kVoltage");

        private String typeName;

        ShuffleboardTypes(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }
    }
    
    public enum GridLocation {
        // Differential Drive Tab
        DIFFERENTIAL_DRIVE_LEFT_FRONT(
            Tabs.DIFFERENTIAL_DRIVE_TAB, 
            ShuffleboardTypes.K_MOTOR_CONTROLLER, 
            "Left Front", 
            0, 0, 
            1, 1
        ),
        DIFFERENTIAL_DRIVE_LEFT_BACK(
            Tabs.DIFFERENTIAL_DRIVE_TAB, 
            ShuffleboardTypes.K_MOTOR_CONTROLLER, 
            "Left Back", 
            0, 1, 
            1, 1
        ),
        DIFFERENTIAL_DRIVE_RIGHT_FRONT(
            Tabs.DIFFERENTIAL_DRIVE_TAB, 
            ShuffleboardTypes.K_MOTOR_CONTROLLER, 
            "Right Front", 
            1, 0, 
            1, 1
        ),
        DIFFERENTIAL_DRIVE_RIGHT_BACK(
            Tabs.DIFFERENTIAL_DRIVE_TAB, 
            ShuffleboardTypes.K_MOTOR_CONTROLLER, 
            "Right Back", 
            1, 1, 
            1, 1
        )
        ;

        private Tabs tab;
        private ShuffleboardTypes type;
        private String name;
        private int row;
        private int column;
        private int width;
        private int height;

        GridLocation(Tabs tab, ShuffleboardTypes type, String name, int row, int column, int width, int height) {
            this.tab = tab;
            this.type = type;
            this.name = name;
            this.row = row;
            this.column = column;
            this.width = width;
            this.height = height;
        }

        public Tabs getTab() {
            return tab;
        }

        public ShuffleboardTypes getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public int getRow() {
            return row;
        }
        
        public int getColumn() {
            return column;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
