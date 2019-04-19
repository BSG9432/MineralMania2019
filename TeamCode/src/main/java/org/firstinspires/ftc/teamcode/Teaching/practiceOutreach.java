package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//Autonomous for the workshop
@Disabled
@Autonomous (name = "practiceOutreach")
public class practiceOutreach extends LinearOpMode {
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;
    public Servo servoBoi;

    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get ("frontRight");
        frontLeft = hardwareMap.dcMotor.get ("frontLeft");
        backRight = hardwareMap.dcMotor.get ("backRight");
        backLeft = hardwareMap.dcMotor.get ("backLeft");

        servoBoi = hardwareMap.servo.get ("servoBoi");

        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        frontRight.setPower(1);
        frontLeft.setPower(-1);
        backRight.setPower(1);
        backLeft.setPower(-1);
        sleep(4000);

        turnRight(3000);
    }
    void turnRight (long time) {
        frontRight.setPower(0);
        frontLeft.setPower(-.5);
        backRight.setPower(0);
        backLeft.setPower(-.5);
        sleep(time);
    }
}
