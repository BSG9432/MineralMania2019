package org.firstinspires.ftc.teamcode.MineralMania2k19.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;


@TeleOp (name = "OOFdistrictsTeleOp")
public class districtsTeleOpA extends OpMode {

    public DcMotor frontRight;
    public DcMotor backRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor intake;
    public DcMotor hang;
    public Servo leftPan;
    public Servo rightPan;



    @Override
    public void init() {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight = hardwareMap.dcMotor.get("backRight");
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intake = hardwareMap.dcMotor.get("intake");
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        hang = hardwareMap.dcMotor.get("hang");
        hang.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftPan = hardwareMap.servo.get("leftPan");
        rightPan = hardwareMap.servo.get("rightPan");

        leftPan.setPosition(0);
        rightPan.setPosition(1);
    }
    @Override
    public void loop () {

        //for the joysticks
        if (Math.abs(gamepad1.left_stick_y) > .1) {
            frontLeft.setPower(gamepad1.left_stick_y);
            backLeft.setPower(gamepad1.left_stick_y);
        }
        else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }

        if (Math.abs(gamepad1.right_stick_y) > .1) {
            frontRight.setPower(-gamepad1.right_stick_y);
            backRight.setPower(-gamepad1.right_stick_y);
        }
        else {
            frontRight.setPower(0);
            backRight.setPower(0);

        }

        //intake
        if (gamepad1.dpad_up) {
            intake.setPower(.5);
        }
        else if (gamepad1.dpad_down) {
            intake.setPower(-.5);
        }
        else {
            intake.setPower(0);
        }

        //hanging
        if (Math.abs(gamepad1.right_trigger) > .1) {
            hang.setPower(gamepad1.right_trigger);
        } else if (Math.abs(gamepad1.left_trigger) > .1) {
            hang.setPower(-gamepad1.left_trigger);
        } else {
            hang.setPower(0);
        }

        //yeeting the Mobile Cargo Bay
        if (gamepad1.a) {
            rightPan.setPosition(.75);
            leftPan.setPosition(.25);
        }
        else {
            rightPan.setPosition(0);
            leftPan.setPosition(1);
        }

        }
}

