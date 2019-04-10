package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
//idk
@Autonomous (name = "Practice2")
public class Practice2 extends LinearOpMode{
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;

    @Override
    public void runOpMode() throws InterruptedException {
        frontRight=hardwareMap.dcMotor.get("frontRight");
        frontLeft=hardwareMap.dcMotor.get("frontLeft");
        backRight=hardwareMap.dcMotor.get("backRight");
        backLeft=hardwareMap.dcMotor.get("backLeft");

        waitForStart();

        frontRight.setPower(-.5);
        frontLeft.setPower(.5);
        backRight.setPower(-.5);
        backLeft.setPower(.5);
        sleep(5000);

        frontRight.setPower(-.5);
        frontLeft.setPower(1);
        backRight.setPower(-.5);
        backLeft.setPower(1);
        sleep(3000);

        frontRight.setPower(.5);
        frontLeft.setPower(-.5);
        backRight.setPower(.5);
        backLeft.setPower(-.5);
        sleep(2000);
    }
}
