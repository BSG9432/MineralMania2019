package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name= "ServoTester")
@Disabled
public class servoTest extends OpMode{
        public DcMotor frontLeft, frontRight, backLeft, backRight,hang, intake;
        public Servo leftPan, rightPan;
        //IMUs
        //sideIMU
        //centerIMU


    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        hang = hardwareMap.dcMotor.get("hang");
        intake = hardwareMap.dcMotor.get("intake");

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftPan = hardwareMap.servo.get("leftPan");
        rightPan = hardwareMap.servo.get("rightPan");

    }

    @Override
    public void loop() {
        if(gamepad1.a){
            rightPan.setPosition(1);
            leftPan.setPosition(1);
            telemetry.addLine("Servo Pos: 1");
            telemetry.update();
        }
        else if(gamepad1.x){
            rightPan.setPosition(.5);
            leftPan.setPosition(.5);
            telemetry.addLine("Servo Pos: .5");
            telemetry.update();
        }
        else{
            rightPan.setPosition(0);
            leftPan.setPosition(0);
            telemetry.addLine("Servo Pos: 0");
            telemetry.update();
        }


    }
}
