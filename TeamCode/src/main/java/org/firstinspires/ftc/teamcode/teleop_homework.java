package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "My_Teleop")
public class teleop_homework extends LinearOpMode {
  private static final DcMotorSimple.Direction[] MOTOR_DIRECTIONS = {
      DcMotorSimple.Direction.FORWARD,
      DcMotorSimple.Direction.REVERSE,
      DcMotorSimple.Direction.REVERSE,
      DcMotorSimple.Direction.FORWARD
  };

  storage storage;

  @Override
  public void runOpMode() throws InterruptedException {
    DcMotor[] motors = new DcMotor[] {
        hardwareMap.get(DcMotor.class, "leftBack"),
        hardwareMap.get(DcMotor.class, "leftFront"),
        hardwareMap.get(DcMotor.class, "rightBack"),
        hardwareMap.get(DcMotor.class, "rightFront")
    };

    for (int i = 0; i < motors.length; i++) {
      motors[i].setDirection(MOTOR_DIRECTIONS[i]);
      motors[i].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    storage = new storage(motors[0], motors[1], motors[2], motors[3]);

    waitForStart();

    while (opModeIsActive()) {
      double drive = -gamepad1.left_stick_y;
      double turn = gamepad1.right_stick_x;
      double strafe = gamepad1.left_stick_x;

      double[] powers = {
          drive + turn - strafe,
          drive + turn + strafe,
          drive - turn - strafe,
          drive - turn + strafe
      };

      storage.setPower(powers[0], powers[1], powers[2], powers[3]);
    }

    storage.stopMotors();
  }
}
