package org.firstinspires.ftc.teamcode.backcountry;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.backcountry.sensors.IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;
//import static org.firstinspires.ftc.teamcode.backcountry.FTCUtilities.telemetry;

public class Chassis{

    private DriveUnit RightFront;
    private DriveUnit LeftFront;
    private DriveUnit RightBack;
    private DriveUnit LeftBack;
    private org.firstinspires.ftc.teamcode.backcountry.sensors.IMU IMU;

    private double runTime;

    public Chassis(){
//        this.RightFront= new DriveUnit(1,4,true);
//        this.LeftFront= new DriveUnit(1,4,true);
//        this.RightBack= new DriveUnit(1,4,true);
//        this.LeftBack= new DriveUnit(1,4,true);
        this.IMU = new IMU(FTCUtilities.getIMU("imu"));
    }

    public void init(){
//        RightFront.init("RightFront");
//        LeftFront.init("LeftFront");
//        LeftBack.init("RightBack");
//        RightBack.init("LeftBack");
    }

    public void StraitMotion(double Speed,double Distence){
        boolean run = true;
        RightFront.zeroDistance();
        LeftFront.zeroDistance();
        RightBack.zeroDistance();
        LeftBack.zeroDistance();
        while(run && FTCUtilities.opModeIsActive()){
            RightBack.setPower(Speed);
            LeftBack.setPower(-Speed);
            RightFront.setPower(Speed);
            LeftFront.setPower(-Speed);

            double TravledRight = RightFront.getInchesTravelled();
            double TravledLeft = LeftFront.getInchesTravelled();

            if((TravledRight > Distence) || (TravledLeft > Distence)){
                run = false;
            }
        }

        RightBack.setPower(0);
        LeftBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
    }

    public void Rotate(double angle, double speed){
        boolean run = true;
        double  frontleftPower, frontrightPower, backleftPower, backrightPower;

        IMU.resetAngle();

        if (angle < 0)
        {   // turn right.
            frontleftPower = speed;
            frontrightPower = speed;
            backleftPower = speed;
            backrightPower = speed;
        }
        else if (angle > 0)
        {   // turn left.
            frontleftPower = -speed;
            frontrightPower = -speed;
            backleftPower = -speed;
            backrightPower = -speed;
        }
        else return;

        RightFront.setPower(frontrightPower);
        LeftFront.setPower(frontleftPower);
        RightBack.setPower(backrightPower);
        LeftBack.setPower(backleftPower);
        FTCUtilities.getTelemetry("degrees",angle);
        FTCUtilities.getTelemetry("statment",IMU.getAngle() < angle && FTCUtilities.opModeIsActive());


        while (run) {
            if(IMU.getAngle() < angle && FTCUtilities.opModeIsActive()){}
            else{
            RightFront.setPower(0);
            LeftFront.setPower(0);
            RightBack.setPower(0);
            LeftBack.setPower(0);
            run = false;
            }
        }
    }

    public void Strafe(double speed,double distence){
        RightBack.zeroDistance();
        LeftBack.zeroDistance();
        RightFront.zeroDistance();
        LeftFront.zeroDistance();

        boolean run = true;
        while(run  && FTCUtilities.opModeIsActive()){
            RightBack.setPower(speed);
            LeftBack.setPower(speed);
            RightFront.setPower(-speed);
            LeftFront.setPower(-speed);

            double TravledRight = RightFront.getInchesTravelled();
            double TravledLeft = LeftFront.getInchesTravelled();

            if(TravledRight > distence || TravledLeft > distence){
                run = false;
            }
        }

        RightBack.setPower(0);
        LeftBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
    }

}

