package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@TeleOp(name="RegisTeleOp", group="Linear Opmode")
public class RegisTeleOp extends RegisLinearOp {
    double servoPosition = servo.servoHome;
    final double servoSpeed = .01;
    public void runOpMode() {
        super.runOpMode();
        while (OpModeIsActive()) {
            double max;
            double rot = 0.5;
            double X = gamepad1.left_stick_x;
            double Y = -gamepad1.left_stick_y;
            double R = gamepad1.right_stick_x;
            double RT = gamepad.right_trigger;
            double LT = gamepad.left_trigger;


            max = Math.abs(X*X) + Math.abs(Y*Y) + rot * Math.abs(R*R);

            max = (max < 1)? 1: max;

            rightFrontMotor.setPower((-X + Y - R) / max);
            rightBackMotor.setPower((X + Y - R) / max);
            leftFrontMotor.setPower((X + Y + R) / max);
            leftBackMotor.setPower((-X - Y + R) / max);
            armMotor
            
            servoPosition = Range.clip(servoPosition, servoMax, servoMin);
            servo.setPosition(servoPosition);

                telemetry.addData("Status", "Running");
                telemetry.update();
        }
    }
}
