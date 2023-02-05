package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name="RegisLinearOp", group="Linear Opmode")

public class RegisLinearOp extends LinearOpMode {
    public DcMotor rightFrontMotor = null;
    public DcMotor rightBackMotor = null;
    public DcMotor leftFrontMotor = null;
    public DcMotor leftBackMotor = null;
    public DcMotor armMotor = null;
    public DcMotor intakeMotor = null;
    public Servo servo = null;
    
    public final static double servoHome = 0.0;
    public final static double servoMin = 0.0;
    public final static double servoMax = 0.3;

    @Override

    public void runOpMode() {
        // Front Right - Port 0 Control Hub
        // Front Left - Port 0 Expansion Hub
        // Back Right - Port 1 Control Hub
        // Back Left - Port 2 Expansion Hub
        // Linear Slide Motor - Port 3 Expansion Hub

        rightFrontMotor = hardwareMap.get(DcMotor.class, "Top Right");
        rightBackMotor = hardwareMap.get(DcMotor.class, "Bottom Right");
        leftFrontMotor = hardwareMap.get(DcMotor.class, "Top Left");
        leftBackMotor = hardwareMap.get(DcMotor.class, "Bottom Left");
        armMotor = hardwareMap.get(DcMotor.class, "Arm Motor");
        //intakeMotor = hardwareMap.get(DcMotor.class, "Intake Motor");
        servo = hardwareMap.get(Servo.class, "Servo");
        servo.setPosition(servoHome);

        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotor.setDirection(DcMotor.Direction.FORWARD);
        //intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        

        //rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        //rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        //leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        //leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        //intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        //intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        //armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        
        




        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
    }
}
