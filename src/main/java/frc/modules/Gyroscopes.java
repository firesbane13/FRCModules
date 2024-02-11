package frc.modules;

public class Gyroscopes {
    public enum GyroType {
        PigeonIMU,
        NavX,
        ADXRS450,
        AnalogGyro
    };

    public Gyroscopes(GyroType gyroType) {
        switch (gyroType) {
            case PigeonIMU:
                // PigeonIMU pigeon = new PigeonIMU(0);
                break;
            case NavX:
                // AHRS navx = new AHRS(SPI.Port.kMXP);
                break;
            case ADXRS450:
                // ADXRS450_Gyro adxrs450 = new ADXRS450_Gyro();
                break;
            case AnalogGyro:
                // AnalogGyro analogGyro = new AnalogGyro(0);
                break;
        }
    }

    public void getAngle() {
        // return gyro.getAngle();
    }
}
