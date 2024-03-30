// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.aupirates3291.lib.subsystems.drivetrains;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.aupirates3291.lib.subsystems.drivetrains.constants.DifferentialDriveConstants;

public class DifferentialDriveSubsystemV1 extends SubsystemBase {
  private Spark leftFrontMotor = new Spark(DifferentialDriveConstants.K_LEFT_MOTOR_1_PORT);
  private Spark leftBackMotor = new Spark(DifferentialDriveConstants.K_LEFT_MOTOR_2_PORT);
  private Spark rightFrontMotor = new Spark(DifferentialDriveConstants.K_RIGHT_MOTOR_1_PORT);
  private Spark rightBackMotor = new Spark(DifferentialDriveConstants.K_RIGHT_MOTOR_2_PORT);

  private List<Spark> leftMotors = new ArrayList<>();
  private List<Spark> rightMotors = new ArrayList<>();

  /**
   * Creates a new TankDriveSubsystemV1.
   */
  public DifferentialDriveSubsystemV1() {
    leftMotors.add(leftFrontMotor);
    leftMotors.add(leftBackMotor);

    rightMotors.add(rightFrontMotor);
    rightMotors.add(rightBackMotor);

    setInverted(leftMotors, DifferentialDriveConstants.K_LEFT_MOTORS_INVERTED);
    setInverted(rightMotors, DifferentialDriveConstants.K_RIGHT_MOTORS_INVERTED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
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
}
