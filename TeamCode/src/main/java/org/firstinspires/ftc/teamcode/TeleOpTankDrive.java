package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "WTeleOp")
public class TeleOpTankDrive extends LinearOpMode {
  Storage Storage;

  @Override
  public void runOpMode() throws InterruptedException {
    Storage = new Storage(
        hardwareMap.get(DcMotor.class, "leftBack"),
        hardwareMap.get(DcMotor.class, "leftFront"),
        hardwareMap.get(DcMotor.class, "rightBack"),
        hardwareMap.get(DcMotor.class, "rightFront")
    );

    waitForStart();
    if (isStopRequested()) {
      return;
    }

    while (opModeIsActive()) {
      double power = Math.abs(gamepad1.left_stick_y) > Storage.DEADZONE ?
          -gamepad1.left_stick_y * Storage.MOTOR_SPEED : 0;

      Storage.setAllPower(power);
    }
  }
}
