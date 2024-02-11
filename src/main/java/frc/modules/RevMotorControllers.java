package frc.modules;

public class RevMotorControllers {
    public enum MotorType {
        SPARKMAX, 
        TALONFX, 
        TALONSRX, 
        VICTORSPX, 
        VICTORSP, 
        SPARK
    }

    public enum MController {
        SPARKMAX(
            "Spark Max", 
            MotorType.SPARKMAX, 
            "Brushless Motor Controller"
        ),
        TALONFX(
            "Talon FX", 
            MotorType.TALONFX, 
            "Brushless Motor Controller"
        );

        private final String description;

        MController(String description, MotorType type, String typeDescription) {
            this.description = description;
        }
    }
}
