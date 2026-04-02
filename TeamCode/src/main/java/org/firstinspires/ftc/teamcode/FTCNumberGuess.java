package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class FTCNumberGuess extends OpMode {

    public void next(String caption, String value){
        boolean next = false;
        while (!next){
            telemetry.addData(caption, value + " (Press A to continue)");
            if (gamepad1.a) next = true;
        }
    }

    @Override
    public void init (){
        next("Title", "Guess the Number");
        next("Tutorial", "Pick a number, 1 to 100");
        next("Tutorial", "Press A to add one");
        next("Tutorial", "Press B to add ten");
        next("Tutorial", "Press X make A and B subtract, instead of adding.");
        next("Tutorial", "Press Y to guess");
        next("Tutorial", "You have 7 attempts");
        next("Tutorial", "Let's play!");
    }

    public int guess () {
        int guess = 0;
        boolean guessed = false;
        int a = 1, b = 10;
        while (!guessed) {
            if (gamepad1.a) guess += a;
            else if (gamepad1.b) guess += b;
            else if (gamepad1.x) {
                a *= -1;
                b *= -1;
            }
            else if (gamepad1.y) guessed = true;
            telemetry.addData("Number", guess);
        }
        return guess;
    }

    @Override
    public void loop() {
        int attempts = 7;
        int number = (int)(Math.random() * 100) + 1;
        while (attempts > 0) {
            if (guess() < number){ telemetry.addData("Value", "Too low."); }
            else if (guess() > number){ telemetry.addData("Value", "Too high."); }
            else {
                int tries = 8 - attempts;
                telemetry.addData("Congrats", "You used " + tries + " attempts!");
                break;
            }
            attempts --;

        }
        if (attempts <= 0){ telemetry.addData("Try again", "You ran out of attempts."); }
    }
}
