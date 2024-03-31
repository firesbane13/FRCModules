// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.aupirates3291.lib.subsystems.drivetrains;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.simulation.AnalogGyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.aupirates3291.constants.RobotConstants;
import frc.lib.aupirates3291.helper.ShuffleboardHelper;
import frc.lib.aupirates3291.lib.subsystems.drivetrains.constants.DifferentialDriveConstants.*;
import frc.robot.RobotContainer;

public class DifferentialDriveSubsystemV1 extends SubsystemBase {
  private Spark leftFrontMotor  = new Spark(DriveMotors.K_LEFT_FRONT_MOTOR_PORT);
  private Spark leftBackMotor   = new Spark(DriveMotors.K_LEFT_BACK_MOTOR_PORT);
  private Spark rightFrontMotor = new Spark(DriveMotors.K_RIGHT_FRONT_MOTOR_PORT);
  private Spark rightBackMotor  = new Spark(DriveMotors.K_RIGHT_BACK_MOTOR_PORT);

  private List<Spark> leftMotors  = new ArrayList<>();
  private List<Spark> rightMotors = new ArrayList<>();

  private Encoder leftFrontEncoder = new Encoder(
      DriveEncoders.K_LEFT_FRONT_ENCODER_PORT_A,
      DriveEncoders.K_LEFT_FRONT_ENCODER_PORT_B
  );
  private Encoder leftBackEncoder = new Encoder(
      DriveEncoders.K_LEFT_BACK_ENCODER_PORT_A,
      DriveEncoders.K_LEFT_BACK_ENCODER_PORT_B
  );
  private Encoder rightFrontEncoder = new Encoder(
      DriveEncoders.K_RIGHT_FRONT_ENCODER_PORT_A,
      DriveEncoders.K_RIGHT_FRONT_ENCODER_PORT_B
  );
  private Encoder rightBackEncoder = new Encoder(
      DriveEncoders.K_RIGHT_BACK_ENCODER_PORT_A,
      DriveEncoders.K_RIGHT_BACK_ENCODER_PORT_B
  );

  private AnalogGyro gyro = new AnalogGyro(DriveGyro.K_GYRO_PORT);

  private DifferentialDriveOdometry odometry;

  // Simulation
  private DifferentialDrivetrainSim drivetrainSim;

  private EncoderSim leftFrontEncoderSim;
  private EncoderSim leftBackEncoderSim;
  private EncoderSim rightFrontEncoderSim;
  private EncoderSim rightBackEncoderSim;

  private AnalogGyroSim gyroSim;

  // Shuffleboard
  private ShuffleboardTab tab;
  private GenericEntry leftInvertedToggle;
  private GenericEntry rightInvertedToggle;

  private Boolean lastLeftInverted = DriveMotors.K_LEFT_MOTORS_INVERTED;
  private Boolean lastRightInverted = DriveMotors.K_RIGHT_MOTORS_INVERTED;

  private Field2d field2d = new Field2d();

  /**
   * Creates a new TankDriveSubsystemV1.
   */
  public DifferentialDriveSubsystemV1() {
    leftMotors.add(leftFrontMotor);
    leftMotors.add(leftBackMotor);

    rightMotors.add(rightFrontMotor);
    rightMotors.add(rightBackMotor);

    setInverted(leftMotors, DriveMotors.K_LEFT_MOTORS_INVERTED);
    setInverted(rightMotors, DriveMotors.K_RIGHT_MOTORS_INVERTED); 

    odometry = new DifferentialDriveOdometry(
      gyro.getRotation2d(),
      leftFrontEncoder.getDistance(),
      rightFrontEncoder.getDistance(),
      new Pose2d(
        5.0,        // X meters along the long end of the field
        13.5,      // Y meters along the short end of the field 
        new Rotation2d()    // Angle in radians. Facing forward is 0
      )
    );

    field2d.setRobotPose(odometry.getPoseMeters());

    shuffleboardDataInitialization();
  }

  @Override
  public void periodic() {
    Boolean leftInverted = leftInvertedToggle.getBoolean(DriveMotors.K_LEFT_MOTORS_INVERTED);
    Boolean rightInverted = rightInvertedToggle.getBoolean(DriveMotors.K_RIGHT_MOTORS_INVERTED);
    Rotation2d gyroAngle = gyro.getRotation2d();

    odometry.update(
      gyroAngle,
      leftFrontEncoder.getDistance(),
      rightFrontEncoder.getDistance()
    );

    field2d.setRobotPose(odometry.getPoseMeters());

    // This method will be called once per scheduler run
    if (leftInverted != lastLeftInverted) {
      this.lastLeftInverted = leftInverted;
      this.lastRightInverted = !leftInverted;

      // Right and left always have to be opposite
      rightInvertedToggle.setBoolean(this.lastRightInverted);

      // Change the inverted status of the motors
      setInverted(leftMotors, leftInverted);
      setInverted(rightMotors, this.lastRightInverted);
    } else if (rightInverted != lastRightInverted) {
      this.lastRightInverted = rightInverted;
      this.lastLeftInverted = !rightInverted;

      // Right and left always have to be opposite
      leftInvertedToggle.setBoolean(this.lastLeftInverted);

      // Change the inverted status of the motors
      setInverted(leftMotors, this.lastLeftInverted);
      setInverted(rightMotors, rightInverted);
    }
  }

  private void shuffleboardDataInitialization() {
    tab = Shuffleboard.getTab("DifferentialDrive");

    // Used to track state of the toggle
    leftInvertedToggle = ShuffleboardHelper.addOnOffToggle(
      tab, 
      "Left Inverted", 
      DriveMotors.K_LEFT_MOTORS_INVERTED, 
      List.of(0, 4), // Column, Row
      List.of(1, 1) // Width, Height
    );

    // Used to track state of the toggle
    rightInvertedToggle = ShuffleboardHelper.addOnOffToggle(
      tab, 
      "Right Inverted", 
      DriveMotors.K_RIGHT_MOTORS_INVERTED, 
      List.of(1, 4 ), // Column, Row
      List.of(1, 1) 
    );

    ShuffleboardHelper.addGyro(
      tab,
      "Robot Angle",
      gyro,
      List.of(0, 2), // Column, Row
      List.of(2, 2) // Width, Height
      );

    ShuffleboardHelper.addMotorController(
      tab,
      "Left Front Motor",
      leftFrontMotor,
      List.of(2, 0), // Column, Row
      List.of(1, 1) // Width, Height
    );

    ShuffleboardHelper.addEncoder(
      tab,
      "Left Front Encoder",
      leftFrontEncoder,
      List.of(0, 0), // Column, Row
      List.of(2, 1) // Width, Height
    );

    ShuffleboardHelper.addMotorController(
      tab,
      "Left Back Motor",
      leftBackMotor,
      List.of(2, 1), // Column, Row
      List.of(1, 1) // Width, Height
    );  

    ShuffleboardHelper.addEncoder(
      tab,
      "Left Back Encoder",
      leftBackEncoder,
      List.of(0, 1), // Column, Row
      List.of(2, 1) // Width, Height
    );

    ShuffleboardHelper.addMotorController(
      tab,
      "Right Front Motor",
      rightFrontMotor,
      List.of(4, 0), // Column, Row
      List.of(1, 1) // Width, Height
    );  

    ShuffleboardHelper.addEncoder(
      tab,
      "Right Front Encoder",
      rightFrontEncoder,
      List.of(6, 0), // Column, Row
      List.of(2, 1) // Width, Height
    );

    ShuffleboardHelper.addMotorController(
      tab,
      "Right Back Motor",
      rightBackMotor,
      List.of(4, 1), // Column, Row
      List.of(1, 1) // Width, Height
    );

    ShuffleboardHelper.addEncoder(
      tab,
      "Right Back Encoder",
      rightBackEncoder,
      List.of(6, 1), // Column, Row
      List.of(2, 1) // Width, Height
    );

    ShuffleboardHelper.addField(
      tab,
      "Field",
      field2d,
      List.of(2, 2), // Column, Row
      List.of(4, 3) // Width, Height
    );
  }

  /**
   * Set the inverted status of a list of motors
   * 
   * @param motors     List of motors to set the inverted status of
   * @param isInverted Inverted status to set
   */
  public void setInverted(List<Spark> motors, boolean isInverted) {
    for (Spark motor : motors) {
      motor.setInverted(isInverted);
    }
  }

  /**
   * Drive the robot using tank drive
   * 
   * @param leftSpeed  Speed of the left side of the robot
   * @param rightSpeed Speed of the right side of the robot
   */
  public void drive(double leftSpeed, double rightSpeed) {
    for (Spark motor : leftMotors) {
      motor.set(leftSpeed);
    }

    for (Spark motor : rightMotors) {
      motor.set(rightSpeed);
    }
  }

  /**
   * Enable simulation for the drivetrain
   */
  public void enableSim() {
    drivetrainSim = new DifferentialDrivetrainSim(
      DCMotor.getCIM(4),
      DriveMotors.K_GEAR_REDUCTION,
      DriveMotors.K_MOI,
      RobotConstants.ROBOT_MASS,
      RobotConstants.WHEEL_RADIUS,
      RobotConstants.TRACK_WIDTH,
      VecBuilder.fill(0.001, 0.001, 0.001, 0.1, 0.1, 0.005, 0.005)
    );

    leftFrontEncoderSim   = new EncoderSim(leftFrontEncoder);
    leftBackEncoderSim    = new EncoderSim(leftBackEncoder);
    rightFrontEncoderSim  = new EncoderSim(rightFrontEncoder);
    rightBackEncoderSim   = new EncoderSim(rightBackEncoder);

    gyroSim = new AnalogGyroSim(gyro);
  }

  public void simulationPeriodic() {
    drivetrainSim.setInputs(
      leftFrontMotor.get() * RobotController.getInputVoltage(),
      rightFrontMotor.get() * RobotController.getInputVoltage()
    );

    drivetrainSim.update(0.02);

    leftFrontEncoderSim.setDistance(drivetrainSim.getLeftPositionMeters());
    leftFrontEncoderSim.setRate(drivetrainSim.getLeftVelocityMetersPerSecond());

    leftBackEncoderSim.setDistance(drivetrainSim.getLeftPositionMeters());
    leftBackEncoderSim.setRate(drivetrainSim.getLeftVelocityMetersPerSecond());

    rightFrontEncoderSim.setDistance(drivetrainSim.getRightPositionMeters());
    rightFrontEncoderSim.setRate(drivetrainSim.getRightVelocityMetersPerSecond());

    rightBackEncoderSim.setDistance(drivetrainSim.getRightPositionMeters());
    rightBackEncoderSim.setRate(drivetrainSim.getRightVelocityMetersPerSecond());

    gyroSim.setAngle(-drivetrainSim.getHeading().getDegrees());
  }
}
