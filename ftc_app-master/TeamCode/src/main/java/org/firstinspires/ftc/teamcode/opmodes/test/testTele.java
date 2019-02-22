package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
@TeleOp(name = "tylaop")
public class testTele extends OpMode {
    public DcMotor frontLeft, frontRight, backLeft, backRight;

    @Override
    public void init() {
       frontLeft = hardwareMap.dcMotor.get("frontLeft");
       frontRight = hardwareMap.dcMotor.get("frontRight");
       backLeft = hardwareMap.dcMotor.get("backLeft");
       backRight = hardwareMap.dcMotor.get("backRight");

       frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    @Override
    public void loop() {
        if (Math.abs(gamepad1.right_stick_y) > .1) {
            backRight.setPower(-gamepad1.right_stick_y);
            frontRight.setPower(-gamepad1.right_stick_y);
        }

        if (Math.abs(gamepad1.left_stick_y) > .1) {
            backLeft.setPower(gamepad1.left_stick_y);
            frontLeft.setPower(gamepad1.left_stick_y);
        } else {
            backRight.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            frontLeft.setPower(0);

        }
    }
}
