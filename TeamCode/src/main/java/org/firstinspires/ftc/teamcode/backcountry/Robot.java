package org.firstinspires.ftc.teamcode.backcountry;


public class Robot {
    private Chassis chassis;

    public Robot(){
        this.chassis = new Chassis();
    }


    public Chassis getChassis(){
        return chassis;
    }

    public void init(){
        chassis.init();
    }

}
