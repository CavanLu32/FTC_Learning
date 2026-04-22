package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class real_autonomous extends LinearOpMode {
  private storage storage;

  @Override
  public void runOpMode() throws InterruptedException {
    storage = new storage();

    waitForStart();
    if (isStopRequested()) {
      return;
    }

    while (opModeIsActive() && !isStopRequested()) {

      storage.runWithEncoderLeftB();
      storage.runWithEncoderLeftF();
      storage.runWithEncoderRightB();
      storage.runWithEncoderRightF();

      wait(5000);

      storage.stopMotors();
    }
  }
}
