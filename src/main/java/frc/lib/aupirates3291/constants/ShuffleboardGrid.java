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
        K3_AXIS_ACCELEROMETER(
            "k3AxisAccelerometer", 
            1, 
            1, 
            false
        ),
        K_ACCELEROMETER(
            "kAccelerometer", 
            1, 
            1, 
            false
        ),
        K_BOOLEAN_BOX(
            "kBooleanBox", 
            1, 
            1, 
            false
        ),
        K_CAMERA_STREAM(
            "kCameraStream", 
            1, 
            1, 
            false
        ),
        K_COMBO_BOX(
            "kComboBox", 
            1, 
            1, 
            false
        ),
        K_COMMAND(
            "kCommand", 
            1, 
            1, 
            false
        ),
        K_DIAL(
            "kDial", 
            1, 
            1, 
            false),
        K_DIFFERENTIAL_DRIVE(
            "kDifferentialDrive", 
            1, 
            1, 
            false
        ),
        K_ENCODER(
            "kEncoder", 
            1, 
            1, 
            false
        ),
        K_FIELD(
            "kField", 
            1, 
            1, 
            false
        ),
        K_GRAPH(
            "kGraph", 
            1, 
            1, 
            false
        ),
        K_GYRO(
            "kGyro", 
            1, 
            1, 
            false
        ),
        K_MECANUM_DRIVE(
            "kMecanumDrive", 
            1, 
            1, 
            false
        ),
        K_MOTOR_CONTROLLER(
            "kMotorController", 
            2, 
            1, 
            false
        ),
        K_NUMBER_BAR(
            "kNumberBar", 
            1, 
            1, 
            false
        ),
        K_NUMBER_SLIDER(
            "kNumberSlider", 
            1, 
            1, 
            false
        ),
        K_PID_COMMAND(
            "kPIDCommand", 
            1, 
            1, 
            false
        ),
        K_PID_CONTROLLER(
            "kPIDController", 
            1, 
            1, 
            false
        ),
        K_POWER_DISTRIBUTION(
            "kPowerDistribution", 
            1, 
            1, 
            false
        ),
        K_RELAY(
            "kRelay", 
            1, 
            1, 
            false
        ),
        K_SPLIT_BUTTON_CHOOSER(
            "kSplitButtonChooser", 
            1, 
            1, 
            false
        ),
        K_TEXT_VIEW(
            "kTextView", 
            1, 
            1, 
            false
        ),
        K_TOGGLE_BUTTON(
            "kToggleButton", 
            1, 
            1, 
            true
        ),
        K_TOGGLE_SWITCH(
            "kToggleSwitch", 
            1, 
            1, 
            true
        ),
        K_VOLTAGE(
            "kVoltageView", 
            1, 
            1, 
            false
        ),
        SIMPLE(
            "Simple", 
            1, 
            1, 
            true
        );

        private String typeName;
        private int defaultWidth;
        private int defaultHeight;
        private Boolean isEditable;

        ShuffleboardTypes(String typeName, int defaultWidth, int defaultHeight, Boolean isEditable) {
            this.typeName = typeName;
            this.defaultWidth = defaultWidth;
            this.defaultHeight = defaultHeight;
            this.isEditable = isEditable;
        }

        public String getTypeName() {
            return typeName;
        }

        public int getDefaultWidth() {
            return defaultWidth;
        }

        public int getDefaultHeight() {
            return defaultHeight;
        }

        public Boolean getIsEditable() {
            return isEditable;
        }
    }
    
    public enum GridLocation {
        // Differential Drive Tab
        DIFFERENTIAL_DRIVE_LEFT_FRONT(
            Tabs.DIFFERENTIAL_DRIVE_TAB, 
            ShuffleboardTypes.K_MOTOR_CONTROLLER, 
            "Left Front", 
            0, 0
        ),
        DIFFERENTIAL_DRIVE_LEFT_BACK(
            Tabs.DIFFERENTIAL_DRIVE_TAB, 
            ShuffleboardTypes.K_MOTOR_CONTROLLER, 
            "Left Back", 
            0, 1
        ),
        DIFFERENTIAL_DRIVE_RIGHT_FRONT(
            Tabs.DIFFERENTIAL_DRIVE_TAB, 
            ShuffleboardTypes.K_MOTOR_CONTROLLER, 
            "Right Front", 
            1, 0
        ),
        DIFFERENTIAL_DRIVE_RIGHT_BACK(
            Tabs.DIFFERENTIAL_DRIVE_TAB, 
            ShuffleboardTypes.K_MOTOR_CONTROLLER, 
            "Right Back", 
            1, 1
        )
        ;

        private Tabs tab;
        private ShuffleboardTypes type;
        private String name;
        private int row;
        private int column;

        GridLocation(Tabs tab, ShuffleboardTypes type, String name, int row, int column) {
            this.tab = tab;
            this.type = type;
            this.name = name;
            this.row = row;
            this.column = column;
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
    }
}
