package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@TeleOp(name="RegisTeleOp", group="Linear Opmode")
public class RegisTeleOp extends RegisLinearOp {
    final double servoSpeed = .01;
    final double linslideSpeed = 2;
    public void runOpMode() {
        super.runOpMode();
        while (opModeIsActive()) {
            double max;
            double rot = 0.5;
            double X = gamepad1.left_stick_x;
            double Y = -gamepad1.left_stick_y;
            double R = gamepad1.right_stick_x;
            double LT = gamepad1.left_trigger;
            double RT = gamepad1.right_trigger;


            max = Math.abs(X*X) + Math.abs(Y*Y) + rot * Math.abs(R*R);

            max = (max < 1)? 1: max;

            rightFrontMotor.setPower((X + Y - R) / max);
            telemetry.addData("RF Motor Power: ", rightFrontMotor.getPower());
            telemetry.update();
            rightBackMotor.setPower((-X + Y - R) / max);
            telemetry.addData("RB Motor Power: ", rightBackMotor.getPower());
            telemetry.update();
            leftFrontMotor.setPower((-X + Y + R) / max);
            telemetry.addData("LF Motor Power: ", leftFrontMotor.getPower());
            telemetry.update();
            leftBackMotor.setPower((X + Y + R) / max);
            telemetry.addData("LB Motor Power: ", leftBackMotor.getPower());
            telemetry.update();
            armMotor.setPower(linslidespeed * (RT - LT));
            telemetry.addData("Arm Motor Power: ", armMotor.getPower());
            telemetry.update();
            
            if (gamepad1.x){
                servo.setPosition(servoOpen);
            }
            if (gamepad1.y){
                servo.setPosition(servoClose);
            }
            telemetry.addData("Servo Position: ", servo.getPosition());
            telemetry.update();
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}