package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "WAuto")
public class real_mecanum_auto extends LinearOpMode {
  private static final double KP = 0.01, KI = 0, KD = 0.0001;
  private static final double TARGET_POS = 500;

  private final PID_controller controller = new PID_controller(KP, KI, KD);
  storage storage;

  @Override
  public void runOpMode() throws InterruptedException {
    storage = new storage(
        hardwareMap.get(DcMotor.class, "leftBack"),
        hardwareMap.get(DcMotor.class, "leftFront"),
        hardwareMap.get(DcMotor.class, "rightBack"),
        hardwareMap.get(DcMotor.class, "rightFront")
    );

    storage.setAllMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    waitForStart();

    while (opModeIsActive()) {
      double[] positions = storage.getCurrentPositions();

      double[] powers = new double[4];
      for (int i = 0; i < 4; i++) {
        powers[i] = Math.max(-1, Math.min(1, controller.calculate(TARGET_POS, positions[i])));
      }

      storage.setPower(powers[0], powers[1], powers[2], powers[3]);

      telemetry.addData("lfPos", positions[1]);
      telemetry.addData("rfPos", positions[3]);
      telemetry.addData("Target", TARGET_POS);
      telemetry.update();
    }
  }
}
