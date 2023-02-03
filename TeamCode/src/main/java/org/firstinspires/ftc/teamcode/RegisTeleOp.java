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
        while (opModeIsActive()) {
            double max;
            double rot = 0.5;
            double X = gamepad1.left_stick_x;
            double Y = -gamepad1.left_stick_y;
            double R = gamepad1.right_stick_x;
            double turn = 751.8*2;

            double Intakepower = gamepad2.right_trigger;
            double Outtakepower = gamepad2.left_trigger;
            boolean stopIntake = gamepad1.y;


            max = Math.abs(X*X) + Math.abs(Y*Y) + rot * Math.abs(R*R);

            max = (max < 1)? 1: max;

            rightFrontMotor.setPower((-X + Y - R) / max);
            rightBackMotor.setPower((X + Y - R) / max);
            leftFrontMotor.setPower((X + Y + R) / max);
            leftBackMotor.setPower((-X + Y + R) / max);

            if ( Intakepower > 0) {
                intakeMotor.setPower(.1);
            }else if (Outtakepower > 0) {
                intakeMotor.setPower(-.1);
            }else if (gamepad1.right_trigger == 0 && gamepad1.left_trigger == 0) {
                intakeMotor.setPower(0);
                
            }

        if (gamepad2.left_bumper){
        armMotor.setPower(-.15);
        }
        else if (!gamepad2.right_bumper && !gamepad1.left_bumper) {
        armMotor.setPower(0);
        }
        else if (gamepad2.right_bumper) {
        armMotor.setPower(.15);
        }
        
        if (gamepad2.x){
            servoPosition += servoSpeed;
        }else if (gamepad2.a){
            servoPosition += servoSpeed;
        }
        
        servoPosition = Range.clip(servoPosition, servoMax, servoMin);
        servo.setPosition(servoPosition);

            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
