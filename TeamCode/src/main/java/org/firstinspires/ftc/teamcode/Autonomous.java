package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Autonomous extends LinearOpMode {
  private static final int RUN_TIME = 5000;
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

    while (opModeIsActive() && !isStopRequested()) {
      Storage.runAllToTarget();

      try {
        Thread.sleep(RUN_TIME);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
      }

      Storage.stopMotors();
    }
  }
}
