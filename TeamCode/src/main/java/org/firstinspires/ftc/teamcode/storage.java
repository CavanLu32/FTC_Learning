package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class storage {
  final static double leftBackMotorSpeed = 0.5;
  final static double leftFrontMotorSpeed = 0.5;
  final static double rightBackMotorSpeed = 0.5;
  final static double rightFrontMotorSpeed = 0.5;
  private DcMotor leftBackMotor;
  private DcMotor leftFrontMotor;
  private DcMotor rightBackMotor;
  private DcMotor rightFrontMotor;

  public void stopMotors() {
    leftBackMotor.setPower(0);
    leftFrontMotor.setPower(0);
    rightBackMotor.setPower(0);
    rightFrontMotor.setPower(0);
  }

  public void runWithEncoderLeftB() {
    leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftBackMotor.setTargetPosition(1000);
    leftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    leftBackMotor.setPower(0.5);
  }

  public void runWithEncoderLeftF() {
    leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftFrontMotor.setTargetPosition(1000);
    leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    leftFrontMotor.setPower(0.5);
  }

  public void runWithEncoderRightB() {
    rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightBackMotor.setTargetPosition(1000);
    rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    rightBackMotor.setPower(0.5);
  }

  public void runWithEncoderRightF() {
    rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightFrontMotor.setTargetPosition(1000);
    rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    rightFrontMotor.setPower(0.5);
  }

  public void setPower(double backLeftPower, double frontLeftPower, double backRightPower,
                       double frontRightPower) {
    leftBackMotor.setPower(backLeftPower);
    leftFrontMotor.setPower(frontLeftPower);
    rightBackMotor.setPower(backRightPower);
    rightFrontMotor.setPower(frontRightPower);
  }
}
