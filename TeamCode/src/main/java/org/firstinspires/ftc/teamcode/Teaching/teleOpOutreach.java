package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//Tele-Op for Workshop
public class teleOpOutreach extends OpMode {
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;
    public Servo servoBoi;
    @Override
    public void init() {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight = hardwareMap.dcMotor.get("backRight");
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servoBoi = hardwareMap.servo.get("servoBoi");

        servoBoi.setPosition(.3);

    }

    @Override
    public void loop() {

        if (Math.abs(gamepad1.left_stick_y) > .1) {
            frontRight.setPower(0);
            frontLeft.setPower(gamepad1.left_stick_y);
            backRight.setPower(0);
            backLeft.setPower(gamepad1.left_stick_y);
        }
        else if (Math.abs(gamepad1.right_stick_y) > .1) {
            frontRight.setPower(-gamepad1.right_stick_y);
            frontLeft.setPower(0);
            backRight.setPower(-gamepad1.right_stick_y);
            backLeft.setPower(0);
        }
        else {
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
        }


    }
}
