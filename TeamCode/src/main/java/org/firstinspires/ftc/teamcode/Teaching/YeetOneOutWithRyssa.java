
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name = "YeetOneOutWithRyssa")
public class YeetOneOutWithRyssa extends LinearOpMode {
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
        servoBoi.setPosition(0);


        waitForStart();
        frontRight.setPower(.5);
        frontLeft.setPower(-.5);
        backRight.setPower(.5);
        backLeft.setPower(-.5);

        sleep(3000);

        frontRight.setPower(.3);
        frontLeft.setPower(.5);
        backRight.setPower(.5);
        backLeft.setPower(.3);
        sleep(2000);

        frontRight.setPower(-.5);
        frontLeft.setPower(.5);
        backRight.setPower(-.5);
        backLeft.setPower(.5);
        servoBoi.setPosition(.3);
        sleep(4000);
    }
}




