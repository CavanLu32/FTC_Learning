package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "WTeleOp")
public class real_teleOp_tank_drive extends LinearOpMode {
  storage storage;

  @Override
  public void runOpMode() throws InterruptedException {
    storage = new storage(
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
      double power = Math.abs(gamepad1.left_stick_y) > storage.DEADZONE ?
          -gamepad1.left_stick_y * storage.MOTOR_SPEED : 0;

      storage.setAllPower(power);
    }
  }
}
