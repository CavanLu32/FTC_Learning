package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "WTeleOp")
public class real_teleOp_tank_drive extends LinearOpMode{
    private storage storage;

    private DcMotor leftBackMotor;
    private DcMotor leftFrontMotor;
    private DcMotor rightBackMotor;
    private DcMotor rightFrontMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        storage = new storage();

        leftBackMotor = hardwareMap.dcMotor.get("leftBackMotor");
        leftFrontMotor = hardwareMap.dcMotor.get("leftFrontMotor");
        rightBackMotor = hardwareMap.dcMotor.get("rightBackMotor");
        rightFrontMotor = hardwareMap.dcMotor.get("rightFrontMotor");

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()){

            if (gamepad1.left_stick_y < -0.05){

                leftBackMotor.setPower(storage.leftBackMotorSpeed);
                leftFrontMotor.setPower(storage.leftFrontMotorSpeed);
                rightBackMotor.setPower(storage.rightBackMotorSpeed);
                rightFrontMotor.setPower(storage.rightFrontMotorSpeed);
            }

            else if (gamepad1.left_stick_y > 0.05){

                leftBackMotor.setPower(storage.leftBackMotorSpeed * -1.0);
                leftFrontMotor.setPower(storage.leftFrontMotorSpeed * -1.0);
                rightBackMotor.setPower(storage.rightBackMotorSpeed * -1.0);
                rightFrontMotor.setPower(storage.rightFrontMotorSpeed * -1.0);
            }

            else {
                leftBackMotor.setPower(0);
                leftFrontMotor.setPower(0);
                rightBackMotor.setPower(0);
                rightFrontMotor.setPower(0);
            }
        }
    }
}
