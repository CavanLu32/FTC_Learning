package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PID_controller {
    private double kP, kI, kD;

    private double integralSum = 0;
    private double lastError = 0;

    private ElapsedTime timer = new ElapsedTime();

    public PID_controller (double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public double calculate(double target, double current) {

        double error = target - current;
        double derivative = (error -lastError) / timer.seconds();
        integralSum += (error * timer.seconds());

        if (Math.abs(error) < 1) { integralSum = 0; }

        double output = (kP * error) + (kI * integralSum) + (kD * derivative);

        lastError = error;
        timer.reset();

        return output;
    }
}
