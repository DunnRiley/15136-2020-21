package org.firstinspires.ftc.teamcode.backcountry;

//import static org.firstinspires.ftc.teamcode.backcountry.FTCUtilities.telemetry;

public class MotionFunctions {
    private Chassis chassis;

    public MotionFunctions(){
        this.chassis = new Chassis();
    }

    public void StraitMotion (double Speed, double Direction, double Distance, double Angle, double Time) {
        chassis.init();
//        double doubleSpeed = Double.parseDouble(Speed);
//        double doubleDistance = Double.parseDouble(Distance);
//        telemetry.addData("Speed", doubleSpeed);
//        telemetry.addData("Distance", doubleDistance);
//        telemetry.update();
        chassis.StraitMotion(Speed,Distance);
    }

    public void Rotate (String Speed, String Direction, String Distance, String Angle, String Time){
        chassis.init();
        double doubleSpeed = Double.parseDouble(Speed);
        double doubleAngle = Double.parseDouble(Angle);
        chassis.Rotate(doubleAngle,doubleSpeed);
    }

    public void Strafe (String Speed, String Direction, String Distance, String Angle, String Time){
        chassis.init();
        double doubleSpeed = Double.parseDouble(Speed);
        double doubleDistance = Double.parseDouble(Distance);
        chassis.Strafe(doubleSpeed, doubleDistance);
    }
}