package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class PracticeProgramming extends LinearOpMode {
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;
    public Servo servoBoi;

    @Override
    public void runOpMode() throws InterruptedException {
      frontRight = hardwareMap.dcMotor.get("frontRight");
      frontLeft  = hardwareMap.dcMotor.get("frontLeft");
      backRight = hardwareMap.dcMotor.get("backRight");
      backLeft = hardwareMap.dcMotor.get("backLeft");

      servoBoi = hardwareMap.servo.get("servoBoi");

      frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

      waitForStart();

      frontRight.setPower(1);
      frontLeft.setPower(-1);
      backRight.setPower(1);
      backLeft.setPower(-1);
      sleep(3000);



    }
}
