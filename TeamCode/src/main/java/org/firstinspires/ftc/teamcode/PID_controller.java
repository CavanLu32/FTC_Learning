package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * PID controller implementation for motor control.
 * Provides proportional, integral, and derivative control to reach target positions.
 */
public class PID_controller {
  private final double kP;
  private final  double kI;
  private final double kD;

  private double integralSum = 0;
  private double lastError = 0;

  private final ElapsedTime timer = new ElapsedTime();

  /**
   * Creates a new PID controller with specified gains.
   *
   * @param kP Proportional gain
   * @param kI Integral gain
   * @param kD Derivative gain
   */
  public PID_controller(double kP, double kI, double kD) {
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
  }

  /**
   * Calculates the PID output to reach the target position.
   *
   * @param target  The target position
   * @param current The current position
   * @return The calculated output power
   */
  public double calculate(double target, double current) {

    double error = target - current;
    double derivative = (error - lastError) / timer.seconds();
    integralSum += (error * timer.seconds());

    if (Math.abs(error) < 1) {
      integralSum = 0;
    }

    double output = (kP * error) + (kI * integralSum) + (kD * derivative);

    lastError = error;
    timer.reset();

    return output;
  }
}
