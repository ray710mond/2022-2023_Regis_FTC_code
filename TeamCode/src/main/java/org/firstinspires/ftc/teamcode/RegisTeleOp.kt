package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp

@TeleOp
class RegisTeleOp : RegisLinearOp() {
    override fun runOpMode() {
        super.runOpMode()
        while (opModeIsActive()) {
            val swerve = gamepad1.left_stick_x
            val thrust = gamepad1.left_stick_y.toDouble()
            val spin = gamepad1.right_stick_x
            rightFrontMotor.power = thrust
            leftFrontMotor.power = thrust
            leftBackMotor.power = thrust
            rightBackMotor.power = thrust
            if (swerve > 0) {
                leftBackMotor.power *= 1 - swerve
                leftFrontMotor.power *= 1 - swerve
            } else if (swerve < 0) {
                rightBackMotor.power *= 1 + swerve
                rightFrontMotor.power *= 1 + swerve
            }

            if (spin > 0) {
                leftBackMotor.power *= 1 - spin
                leftFrontMotor.power *= 1 - spin
                rightBackMotor.power *= -1 * ( 1- spin)
                rightFrontMotor.power *= -1 * ( 1- spin)
            } else if (spin < 0) {
                rightBackMotor.power *= 1 + swerve
                rightFrontMotor.power *= 1 + swerve
                rightBackMotor.power *= -1 * (1 + swerve)
                rightFrontMotor.power *= -1 * (1 + swerve)

            }

            telemetry.addData("Status", "Running")
            telemetry.update()
        }
    }
}
