package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp

@TeleOp
class RegisTeleOp : RegisLinearOp() {
    override fun runOpMode() {
        super.runOpMode()
        while (opModeIsActive()) {
            val swerve = gamepad1.left_stick_x
            val thrust = gamepad1.left_stick_y.toDouble()
            rightFrontMotor.power = thrust
            leftFrontMotor.power = thrust
            leftBackMotor.power = thrust
            rightBackMotor.power = thrust
            if (swerve > 0) {
                leftBackMotor.power *= 1 - swerve
            } else if (swerve < 0) {
                rightBackMotor.power *= 1 + swerve
            }
            telemetry.addData("Status", "Running")
            telemetry.update()
        }
    }
}