package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {
    private DcMotor intakeMotor;

    public final double OUT = -.5;
    public final double IN = .5;

    public Intake(){

    }

    public void inTake() {
        intakeMotor.setPower(IN);
    }

    public void outTake() {
        intakeMotor.setPower(OUT);
    }

}


