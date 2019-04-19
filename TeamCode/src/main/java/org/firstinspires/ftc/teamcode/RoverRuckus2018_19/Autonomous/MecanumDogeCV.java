package org.firstinspires.ftc.teamcode.RoverRuckus2018_19.Autonomous;

//import com.disnodeteam.dogecv.CameraViewDisplay;
//import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
@Autonomous (name = "MecanumDogeCV")
public class MecanumDogeCV extends LinearOpMode {
    public DcMotor frontRight;
    public DcMotor backRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;

    public Servo hangyboi;
    public DcMotor hangLift;

    public DcMotor pivot;
    public DcMotor intakeLift; //because i don't know what to name it
    public DcMotor intake;


    public Servo teamMarker;

  //  public GoldAlignDetector detector;

    //note to add

    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        hangyboi = hardwareMap.servo.get("hangyboi");
        hangLift = hardwareMap.dcMotor.get("lift");
        hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        pivot = hardwareMap.dcMotor.get("pivot");
        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeLift = hardwareMap.dcMotor.get("blah");
        intakeLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake = hardwareMap.dcMotor.get("intake");
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        teamMarker = hardwareMap.servo.get("teamMarker");

       // detector = new GoldAlignDetector();
       // detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
       // detector.useDefaults();

       // detector.enable();

        waitForStart();

        //If Gold Detector hasn't aligned yet, then rotate clockwise
       /* boolean endReached = false;
        ElapsedTime endTimer = new ElapsedTime();
        double endTimeLimit = 4.0;//in seconds
        while(!detector.getAligned() && !endReached && opModeIsActive()){
            frontLeft.setPower(.2/1.5);
            frontRight.setPower(.175/1.5);
            backLeft.setPower(.2/1.5);
            backRight.setPower(.175/1.5);
            if(endTimer.time() >= endTimeLimit){
                endReached = true;
            }
        }
*/
        //forward for two seconds
        frontLeft.setPower(.3);
        frontRight.setPower(-.3);
        backLeft.setPower(.3);
        backRight.setPower(-.3);

        sleep(2000);

        //stop moving and disable detector
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
       // detector.disable();

       // AutoTransitioner.transitionOnStop(this, "MecanumTeleOp");


    }
}