package org.firstinspires.ftc.teamcode.backcountry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// On Bot Mechanic
public class OBM {

    private String deviceName;
    private HardwareMap hardwareMap;
    private DcMotor motor;
    private boolean direction;
    public OBM(String deviceName, boolean direction) {
        this.deviceName = deviceName;
        this.direction = direction;
        init();
    }

    public void init(){
        motor = FTCUtilities.getHardwareMap().get(DcMotor.class,deviceName);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setPower(double power){
        if(!direction){power=-power;}
        motor.setPower(power);
    }
}
