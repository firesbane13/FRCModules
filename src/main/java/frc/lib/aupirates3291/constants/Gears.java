package frc.lib.aupirates3291.constants;

public class Gears {

    public enum Measurement {
        INCHES,
        FEET,
        MM,
        CM,
        M
    }

    public enum GearType {
        ROUND,
        WORM
    }

    public enum RoundGear {
        AM3407(
            "40 Tooth 32 DP Nub Bore Steel Gear for PicoBox",
            GearType.ROUND,
            40, 
            1.25, 
            Measurement.INCHES, 
            32
        ),
        AM3408(
            "35 Tooth 32 DP Nub Bore Steel Gear for PicoBox",
            GearType.ROUND,
            35, 
            1.093, 
            Measurement.INCHES, 
            32
        ),
        AM5020_30(
            "Robits 20DP Gears (30)",
            GearType.ROUND,
            30,
            1.5,
            Measurement.INCHES,
            20
        ),
        AM5020_40(
            "Robits 20DP Gears (40)",
            GearType.ROUND,
            40,
            20,
            Measurement.INCHES,
            20
        ),
        AM5020_50(
            "Robits 20DP Gears (50)",
            GearType.ROUND,
            50,
            2.5,
            Measurement.INCHES,
            20
        ),
        AM5020_60(
            "Robits 20DP Gears (60)",
            GearType.ROUND,
            30,
            30,
            Measurement.INCHES,
            20
        )
        ;

        private final String      description;

        private final GearType    type;

        // Number of Teeth the gear has. 
        private final int         numberOfTeeth;

        // Pitch Diameter from the spec sheet.
        private final double      pitchDiameter;

        // What the Pitch Diameter is measured in.
        private final Measurement measurement;

        // Diametral Pitch.  This helps determine the pitch diameter.
        private final int         diametralPitch;

        RoundGear(
            String description, 
            GearType type, 
            int numberOfTeeth, 
            double pitchDiameter, 
            Measurement measurement, 
            int diametralPitch
        ) {
            this.description = description;
            this.type = type;
            this.numberOfTeeth = numberOfTeeth;
            this.pitchDiameter = pitchDiameter;
            this.measurement = measurement;
            this.diametralPitch = diametralPitch;
        }
        
        public String getDescription() {
            return this.description;
        }

        public GearType getType() {
            return this.type;
        }

        public int getNumberOfTeeth() {
            return this.numberOfTeeth;
        }

        public double getPitchDiameter() {
            return this.pitchDiameter;
        }

        public Measurement getMeasurement() {
            return this.measurement;
        }

        public double calculatePitchDiameter() {
            double numberOfTeeth = this.numberOfTeeth * 1.0;
            double diametralPitch = this.diametralPitch * 1.0;

            return (numberOfTeeth / diametralPitch);
        }

        public double convertPitchDiameter(Measurement to) {
            double calculatedValue = 0.0;
            Measurement from = this.measurement;

            switch (from) {
                case INCHES:
                    calculatedValue = convertInches(to);
                break;
                case FEET:
                    calculatedValue = convertFeet(to);
                break;
                case MM:
                    calculatedValue = convertMM(to);
                break;
                case CM:
                    calculatedValue = convertCM(to);
                break;
                case M:
                    calculatedValue = convertM(to);
                break;
                default:
                    calculatedValue = this.pitchDiameter;
                break;
            }

            return calculatedValue;
        }

        private double convertInches(Measurement to) {
            double calculatedValue = 0.0;
            double inches = this.pitchDiameter;

            switch (to) {
                case FEET:
                    calculatedValue = inches * 0.0833;
                    break;
            
                case MM:
                    calculatedValue = inches * 25.4;
                    break;

                case CM:
                    calculatedValue = inches * 2.54;
                    break;
                
                case M:
                    calculatedValue = inches * 0.0254;
                    break;

                default:
                    calculatedValue = inches;
                    break;
            }

            return calculatedValue;
        }
        
        private double convertFeet(Measurement to) {
            double calculatedValue = 0.0;
            double feet = this.pitchDiameter;

            switch (to) {
                case INCHES:
                    calculatedValue = feet * 12;
                    break;
            
                case MM:
                    calculatedValue = feet * 304.8;
                    break;

                case CM:
                    calculatedValue = feet * 30.48;
                    break;
                
                case M:
                    calculatedValue = feet * 0.3048;
                    break;

                default:
                    calculatedValue = feet;
                    break;
            }

            return calculatedValue;
        }

        private double convertMM(Measurement to) {
            double calculatedValue = 0.0;
            double mm = this.pitchDiameter;

            switch (to) {
                case INCHES:
                    calculatedValue = mm / 25.4;
                    break;
            
                case FEET:
                    calculatedValue = mm * 0.00328084;
                    break;

                case CM:
                    calculatedValue = mm / 10;
                    break;
                
                case M:
                    calculatedValue = mm / 1000;
                    break;

                default:
                    calculatedValue = mm;
                    break;
            }

            return calculatedValue;
        }

        private double convertCM(Measurement to) {
            double calculatedValue = 0.0;
            double cm = this.pitchDiameter;

            switch (to) {
                case INCHES:
                    calculatedValue = cm * 0.3937;
                    break;

                case FEET:
                    calculatedValue = cm * 0.0328;
                    break;
            
                case MM:
                    calculatedValue = cm * 10;
                    break;
                
                case M:
                    calculatedValue = cm / 100;
                    break;

                default:
                    calculatedValue = cm;
                    break;
            }

            return calculatedValue;
        }

        private double convertM( Measurement to) {
            double calculatedValue = 0.0;
            double m = this.pitchDiameter;

            switch (to) {
                case INCHES:
                    calculatedValue = m * (3.28 * 12);
                    break;

                case FEET:
                    calculatedValue = m * 3.28084;
                    break;
            
                case MM:
                    calculatedValue = m * 1000;
                    break;
                
                case CM:
                    calculatedValue = m * 100;
                    break;

                default:
                    calculatedValue = m;
                    break;
            }

            return calculatedValue;
        }
    }    
}
