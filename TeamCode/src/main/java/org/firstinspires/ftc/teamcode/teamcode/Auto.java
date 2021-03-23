package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.backcountry.DriveUnit;

import java.io.FileNotFoundException;

@Autonomous(name="Auto", group="Linear Opmode")

public class Auto extends LinearOpMode {
//    private FileOrgoniser file;
    private ElapsedTime runtime = new ElapsedTime();
//    private MotionFunctions MF;
    private DcMotor Motor = null;
    private DriveUnit driveUnit;

    public void runOpMode() {
        driveUnit=new DriveUnit(1,4,"Motor",true);
        Motor  = hardwareMap.get(DcMotor.class, "Motor");
        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {
//            driveUnit.setPower(.4);
           // MF.StraitMotion(1.0,0.0,20.0,0.0,0.0);
//            file.run();
        }
    }
}

