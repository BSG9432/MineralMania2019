package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Robot {
    public DcMotor frontLeft, frontRight, backLeft, backRight;
    public DcMotor[] motors = {frontLeft, frontRight, backLeft, backRight};
    public String[] motorNames = {"frontLeft", "frontRight", "backLeft", "backRight"};


    public Robot() {

    }

    public void init(HardwareMap hMap) {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = hMap.dcMotor.get(motorNames[i]);
        }
    }

    public void setAllBrake() {
        for (int i = 0; i < motors.length; i++) {
            motors[i].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }




    }
}

