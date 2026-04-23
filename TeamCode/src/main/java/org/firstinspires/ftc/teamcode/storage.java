package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Utility class for managing robot motor operations and speeds.
 */
public class storage {
  public static final double MOTOR_SPEED = 0.5;
  public static final int TARGET_POSITION = 1000;
  public static final double DEADZONE = 0.05;

  private DcMotor leftBackMotor;
  private DcMotor leftFrontMotor;
  private DcMotor rightBackMotor;
  private DcMotor rightFrontMotor;

  /**
   * Creates a new storage instance with the specified motors.
   *
   * @param leftBackMotor   The left back motor
   * @param leftFrontMotor  The left front motor
   * @param rightBackMotor  The right back motor
   * @param rightFrontMotor The right front motor
   */
  public storage(DcMotor leftBackMotor, DcMotor leftFrontMotor, DcMotor rightBackMotor,
                 DcMotor rightFrontMotor) {
    this.leftBackMotor = leftBackMotor;
    this.leftFrontMotor = leftFrontMotor;
    this.rightBackMotor = rightBackMotor;
    this.rightFrontMotor = rightFrontMotor;
  }

  /**
   * Default constructor for backward compatibility.
   * Note: Motors must be set manually before use.
   */
  public storage() {
  }

  /**
   * Stops all motors by setting their power to 0.
   */
  public void stopMotors() {
    leftBackMotor.setPower(0);
    leftFrontMotor.setPower(0);
    rightBackMotor.setPower(0);
    rightFrontMotor.setPower(0);
  }

  /**
   * Runs the left back motor with encoder to a target position of 1000.
   */
  public void runWithEncoderLeftB() {
    leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftBackMotor.setTargetPosition(1000);
    leftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    leftBackMotor.setPower(0.5);
  }

  /**
   * Runs the left front motor with encoder to a target position of 1000.
   */
  public void runWithEncoderLeftF() {
    leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftFrontMotor.setTargetPosition(1000);
    leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    leftFrontMotor.setPower(0.5);
  }

  /**
   * Runs the right back motor with encoder to a target position of 1000.
   */
  public void runWithEncoderRightB() {
    rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightBackMotor.setTargetPosition(1000);
    rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    rightBackMotor.setPower(0.5);
  }

  /**
   * Runs the right front motor with encoder to a target position of 1000.
   */
  public void runWithEncoderRightF() {
    rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightFrontMotor.setTargetPosition(1000);
    rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    rightFrontMotor.setPower(0.5);

  }

  /**
   * Sets power for all four motors.
   *
   * @param backLeftPower   Power for the back left motor
   * @param frontLeftPower  Power for the front left motor
   * @param backRightPower  Power for the back right motor
   * @param frontRightPower Power for the front right motor
   */
  public void setPower(double backLeftPower, double frontLeftPower, double backRightPower,
                       double frontRightPower) {
    leftBackMotor.setPower(backLeftPower);
    leftFrontMotor.setPower(frontLeftPower);
    rightBackMotor.setPower(backRightPower);
    rightFrontMotor.setPower(frontRightPower);
  }

  /**
   * Sets the same power to all motors.
   *
   * @param power The power to set for all motors
   */
  public void setAllPower(double power) {
    leftBackMotor.setPower(power);
    leftFrontMotor.setPower(power);
    rightBackMotor.setPower(power);
    rightFrontMotor.setPower(power);
  }

  /**
   * Configures all motors with the specified mode.
   *
   * @param mode The run mode to set for all motors
   */
  public void setAllMode(DcMotor.RunMode mode) {
    leftBackMotor.setMode(mode);
    leftFrontMotor.setMode(mode);
    rightBackMotor.setMode(mode);
    rightFrontMotor.setMode(mode);
  }

  /**
   * Configures all motors with encoder-based movement to target position.
   */
  public void runAllToTarget() {
    setAllMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftBackMotor.setTargetPosition(TARGET_POSITION);
    leftFrontMotor.setTargetPosition(TARGET_POSITION);
    rightBackMotor.setTargetPosition(TARGET_POSITION);
    rightFrontMotor.setTargetPosition(TARGET_POSITION);
    setAllMode(DcMotor.RunMode.RUN_TO_POSITION);
    setAllPower(MOTOR_SPEED);
  }

  /**
   * Gets the current positions of all motors.
   *
   * @return Array of current positions [leftBack, leftFront, rightBack, rightFront]
   */
  public double[] getCurrentPositions() {
    return new double[] {
        leftBackMotor.getCurrentPosition(),
        leftFrontMotor.getCurrentPosition(),
        rightBackMotor.getCurrentPosition(),
        rightFrontMotor.getCurrentPosition()
    };
  }
}
