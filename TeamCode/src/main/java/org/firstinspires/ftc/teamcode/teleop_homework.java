package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "My_Teleop")
public class teleop_homework extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        storage storage = new storage();

        double drive, turn, strafe;
        double backLeftPower, frontLeftPower, backRightPower, frontRightPower;

        DcMotor leftBackMotor = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor rightBackMotor = hardwareMap.get(DcMotor.class, "rightBack");
        DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFront");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            drive = gamepad1.left_stick_y * -1;
            turn = gamepad1.right_stick_x;
            strafe = gamepad1.left_stick_x;

            backLeftPower = drive + turn - strafe;
            frontLeftPower = drive + turn + strafe;
            backRightPower = drive - turn - strafe;
            frontRightPower = drive - turn + strafe;

            storage.setPower(backLeftPower, frontLeftPower, backRightPower, frontRightPower);
        }

        storage.stopMotors();
    }

}
