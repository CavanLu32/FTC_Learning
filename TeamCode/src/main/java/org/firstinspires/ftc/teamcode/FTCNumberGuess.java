package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class FTCNumberGuess extends OpMode {
  private static final String[] TUTORIAL = {
      "Guess the Number",
      "Pick a number, 1 to 100",
      "Press A to add one",
      "Press B to add ten",
      "Press X make A and B subtract, instead of adding.",
      "Press Y to guess",
      "You have 7 attempts",
      "Let's play!"
  };

  private int targetNumber;
  private int attempts;
  private boolean gameActive;
  private int guess = 0;
  private int multiplier = 1;

  @Override
  public void init() {
    for (String message : TUTORIAL) {
      waitForButton("Tutorial", message);
    }
    resetGame();
  }

  private void waitForButton(String caption, String value) {
    while (!gamepad1.a) {
      telemetry.addData(caption, value + " (Press A to continue)");
      telemetry.update();
    }
  }

  private void resetGame() {
    targetNumber = (int) (Math.random() * 100) + 1;
    attempts = 7;
    gameActive = true;
    guess = 0;
    multiplier = 1;
  }

  @Override
  public void loop() {
    if (!gameActive) {
      if (gamepad1.a) {
        resetGame();
      }
      return;
    }

    getGuess();

    if (gamepad1.y) {
      attempts--;
      if (guess == targetNumber) {
        telemetry.addData("Congrats", "You used " + (8 - attempts) + " attempts!");
        gameActive = false;
      } else if (attempts == 0) {
        telemetry.addData("Try again", "You ran out of attempts. Number was: " + targetNumber);
        gameActive = false;
      } else {
        telemetry.addData("Value", guess < targetNumber ? "Too low." : "Too high.");
        telemetry.addData("Attempts left", attempts);
      }
    }

    telemetry.addData("Current Guess", guess);
    telemetry.update();
  }

  private int getGuess() {
    if (gamepad1.a) {
      guess += multiplier;
    }
    if (gamepad1.b) {
      guess += 10 * multiplier;
    }
    if (gamepad1.x) {
      multiplier *= -1;
    }

    return Math.max(0, Math.min(100, guess));
  }
}
