package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "WAuto")
public class MecanumAuto extends LinearOpMode {
  private static final double KP = 0.01;
  private static final double KI = 0;
  private static final double KD = 0.0001;
  private static final double TARGET_POS = 500;

  private final PIDController controller = new PIDController(KP, KI, KD);
  Storage Storage;

  @Override
  public void runOpMode() throws InterruptedException {
    Storage = new Storage(
        hardwareMap.get(DcMotor.class, "leftBack"),
        hardwareMap.get(DcMotor.class, "leftFront"),
        hardwareMap.get(DcMotor.class, "rightBack"),
        hardwareMap.get(DcMotor.class, "rightFront")
    );

    Storage.setAllMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    waitForStart();

    while (opModeIsActive()) {
      double[] positions = Storage.getCurrentPositions();

      double[] powers = new double[4];
      for (int i = 0; i < 4; i++) {
        powers[i] = Math.max(-1, Math.min(1, controller.calculate(TARGET_POS, positions[i])));
      }

      Storage.setPower(powers[0], powers[1], powers[2], powers[3]);

      telemetry.addData("lfPos", positions[1]);
      telemetry.addData("rfPos", positions[3]);
      telemetry.addData("Target", TARGET_POS);
      telemetry.update();
    }
  }
}
