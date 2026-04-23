package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Basic FTC practice OpMode for testing gamepad input.
 */
@TeleOp
public class FTCPractice extends OpMode {

  /**
   * Initializes the OpMode and waits for a button press.
   */
  @Override
  public void init() {
    String button = "N/A";
    boolean pressed = false;
    while (!pressed) {
      if (gamepad1.a) {
        button = "a";
      } else if (gamepad1.b) {
        button = "b";
      } else if (gamepad1.x) {
        button = "x";
      } else if (gamepad1.y) {
        button = "y";
      }
      pressed = true;
    }
    telemetry.addData("Pressed", button);
  }

  /**
   * Main loop method - currently empty.
   */
  public void loop() throws UnsupportedOperationException{
    // Not needed for coding use
  }
}