package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public  class FTCPractice extends OpMode {

    @Override
    public void init () {
        String button = "N/A";
        boolean pressed = false;
        while (!pressed) {
            if (gamepad1.a) button = "a";
            else if (gamepad1.b) button = "b";
            else if (gamepad1.x) button = "x";
            else if (gamepad1.y) button = "y";
            pressed = true;
        }
        telemetry.addData("Pressed", button);
    }

    public void loop () {

    }
}