package org.firstinspires.ftc.teamcode.MineralMania2k19.Testing;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
//Program that starts to move once it reaches a given angle threshold
@Autonomous(name = "yaleIMUv2")

public class yaleIMU extends LinearOpMode {
    public DcMotor frontRight, frontLeft, backRight, backLeft;
    public Servo servoboi;
    public BNO055IMU imu;
    public double imuAngle;

        @Override
    public void runOpMode() throws InterruptedException {
            frontLeft = hardwareMap.dcMotor.get("frontLeft");
            frontRight = hardwareMap.dcMotor.get("frontRight");
            backLeft = hardwareMap.dcMotor.get("backLeft");
            backRight = hardwareMap.dcMotor.get("backRight");
            servoboi = hardwareMap.servo.get("servoboi");

            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

            parameters.mode                = BNO055IMU.SensorMode.IMU;
            parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
            parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
            parameters.loggingEnabled      = false;

            imu = hardwareMap.get(BNO055IMU.class, "imu");

            imu.initialize(parameters);

            waitForStart();
            while (opModeIsActive()&&!isStopRequested()) {
                imuAngle = getHeading();
                if(imuAngle < 0) {
                    imuAngle += 360;
                    move();
                    telemetry.addLine("yo it's working");
                }
                else if(imuAngle > 0){
                    telemetry.addLine("yo im not doing that");
                    stopMovement();

                }
                telemetry.addData("Current Angle: ", imuAngle);
                telemetry.update();
            }

    }
    public void move(){
        frontRight.setPower(.5);
        frontLeft.setPower(.5);
        backRight.setPower(.5);
        backLeft.setPower(.5);

    }
    public void stopMovement(){
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
    }
    public double getHeading() {
        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC,
                AxesOrder.ZYX, AngleUnit.DEGREES);
        double heading = angles.firstAngle;
        return heading;
    }
}
