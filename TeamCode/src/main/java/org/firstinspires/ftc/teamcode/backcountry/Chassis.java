package org.firstinspires.ftc.teamcode.backcountry;


import org.firstinspires.ftc.teamcode.backcountry.sensors.IMU;

public class Chassis{

    private DriveUnit RightFront;
    private DriveUnit LeftFront;
    private DriveUnit RightBack;
    private DriveUnit LeftBack;
    private org.firstinspires.ftc.teamcode.backcountry.sensors.IMU IMU;

    private double runTime;


    public Chassis(){
        this.RightFront= new DriveUnit(1,4,"RightFront",true);
        this.LeftFront= new DriveUnit(1,4,"LeftFront",true);
        this.RightBack= new DriveUnit(1,4,"RightBack",true);
        this.LeftBack= new DriveUnit(1,4,"LeftBack",true);
        this.IMU = new IMU(FTCUtilities.getIMU("imu"));
    }



    public void init(){
        RightFront.init();
        LeftFront.init();
        LeftBack.init();
        RightBack.init();
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

    public void Rotate(int degrees, double power){
        boolean run = true;
        double  frontleftPower, frontrightPower, backleftPower, backrightPower;

        IMU.resetAngle();

        if (degrees < 0)
        {   // turn right.
            frontleftPower = power;
            frontrightPower = power;
            backleftPower = power;
            backrightPower = power;
        }
        else if (degrees > 0)
        {   // turn left.
            frontleftPower = -power;
            frontrightPower = -power;
            backleftPower = -power;
            backrightPower = -power;
        }
        else return;

        RightFront.setPower(frontrightPower);
        LeftFront.setPower(frontleftPower);
        RightBack.setPower(backrightPower);
        LeftBack.setPower(backleftPower);
        FTCUtilities.getTelemetry("degrees",degrees);
        FTCUtilities.getTelemetry("statment",IMU.getAngle() < degrees && FTCUtilities.opModeIsActive());


        while (run) {
            if(IMU.getAngle() < degrees && FTCUtilities.opModeIsActive()){}
            else{
            RightFront.setPower(0);
            LeftFront.setPower(0);
            RightBack.setPower(0);
            LeftBack.setPower(0);
            run = false;
            }
        }
    }

    public void Strafe(double speed,int Distence){
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

            if(TravledRight > Distence || TravledLeft > Distence){
                run = false;
            }
        }

        RightBack.setPower(0);
        LeftBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
    }

}

