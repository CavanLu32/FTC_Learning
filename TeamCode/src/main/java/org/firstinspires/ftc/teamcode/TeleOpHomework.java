package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "My_Teleop")
public class TeleOpHomework extends LinearOpMode {
  Storage Storage;

  @Override
  public void runOpMode() throws InterruptedException {
    DcMotor leftBack = hardwareMap.get(DcMotor.class, "leftBack");
    DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
    DcMotor rightBack = hardwareMap.get(DcMotor.class, "rightBack");
    DcMotor rightFront = hardwareMap.get(DcMotor.class, "rightFront");

    leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
    leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
    rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
    rightFront.setDirection(DcMotorSimple.Direction.FORWARD);

    leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    Storage = new Storage(leftBack, leftFront, rightBack, rightFront);

    waitForStart();

    while (opModeIsActive()) {
      double drive = -gamepad1.left_stick_y;
      double turn = gamepad1.right_stick_x;
      double strafe = gamepad1.left_stick_x;

      Storage.setPower(drive + turn - strafe, drive + turn - strafe, drive - turn - strafe, drive - turn + strafe);
    }

    Storage.stopMotors();
  }
}
