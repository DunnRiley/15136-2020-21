package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="TelleOp", group="Iterative Opmode")
public class TelleOp extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor RightFront = null;
    private DcMotor LeftFront = null;
    private DcMotor RightBack = null;
    private DcMotor LeftBack = null;
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        RightFront  = hardwareMap.get(DcMotor.class, "RightFront");
        LeftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        RightBack  = hardwareMap.get(DcMotor.class, "RightBack");
        LeftBack = hardwareMap.get(DcMotor.class, "LeftBack");

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");

        LeftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {

        double drive = gamepad1.right_stick_y;
        double strafe  =  gamepad1.right_stick_x;
        double turn = gamepad1.left_stick_x;

        double frontLeft = turn + strafe - drive;
        double frontRight = turn + strafe + drive;
        double backLeft = turn - strafe - drive;
        double backRight = turn - strafe + drive;

        double intake = gamepad1.right_trigger;
        double intakeback = gamepad1.left_trigger;
        boolean belt = gamepad1.right_bumper;

        RightBack.setPower(backRight);
        RightFront.setPower(frontRight);
        LeftBack.setPower(backLeft);
        LeftFront.setPower(frontLeft);
    }
    @Override
    public void stop() {
    }

}
