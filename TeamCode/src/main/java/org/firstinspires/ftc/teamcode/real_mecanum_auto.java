package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "WAuto")
public class real_mecanum_auto extends LinearOpMode {

    private  storage storage;
    private PID_controller PID_controller;
    private DcMotor leftBackMotor;
    private DcMotor leftFrontMotor;
    private DcMotor rightBackMotor;
    private DcMotor rightFrontMotor;
    private double targetPosition = 500;

    PID_controller controller = new PID_controller(0.01, 0, 0.0001);

    @Override
    public void runOpMode() throws InterruptedException {

        leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        while (opModeIsActive()){

            double lbCurrentPos = leftBackMotor.getCurrentPosition();
            double lfCurrentPos = leftFrontMotor.getCurrentPosition();
            double rbCurrentPos = rightBackMotor.getCurrentPosition();
            double rfCurrentPos = rightFrontMotor.getCurrentPosition();

            double lbpower = controller.calculate(targetPosition, lbCurrentPos);
            double lfpower = controller.calculate(targetPosition, lfCurrentPos);
            double rbpower = controller.calculate(targetPosition, rbCurrentPos);
            double rfpower = controller.calculate(targetPosition, rfCurrentPos);

            leftBackMotor.setPower(Math.max(-1, Math.min(1, lbpower)));
            leftFrontMotor.setPower(Math.max(-1, Math.min(1, lfpower)));
            rightBackMotor.setPower(Math.max(-1, Math.min(1, rbpower)));
            rightFrontMotor.setPower(Math.max(-1, Math.min(1, rfpower)));

            telemetry.addData("lfPos", lfCurrentPos);
            telemetry.addData("Target", targetPosition);
            telemetry.update();
        }
    }
}
