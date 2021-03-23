package org.firstinspires.ftc.teamcode.backcountry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import static org.firstinspires.ftc.teamcode.backcountry.FTCUtilities.telemetry;

public class FileOrgoniser{
    private MotionFunctions MF;

    public void run()  {
        MF.StraitMotion(1.0,0.0,20.0,0.0,0.0);

//        String fileName = "Users/DunnR/Documents/Programing/IACompSci/IA-Android-Studio/TeamCode/src/main/java/org/firstinspires/ftc/teamcode/backcountry/Test";
//        this.MF = MF;
//        File file = new File(fileName);
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(file);
//            while (scanner.hasNext()) {
//                String[] lineSegments = scanner.next().split(",");
//                if (lineSegments[0] == "StraitMotion") {
//                    MF.StraitMotion(lineSegments[1], lineSegments[2], lineSegments[3], lineSegments[4], lineSegments[5]);
//                }
//                if (lineSegments[0] == "Rotate") {
//                    MF.Rotate(lineSegments[1], lineSegments[2], lineSegments[3], lineSegments[4], lineSegments[5]);
//                }
//                if (lineSegments[0] == "Strafe") {
//                    MF.Strafe(lineSegments[1], lineSegments[2], lineSegments[3], lineSegments[4], lineSegments[5]);
//                }
//                if (lineSegments[0] == "runOBM") {
//                    MF.Strafe(lineSegments[1], lineSegments[2], lineSegments[3], lineSegments[4], lineSegments[5]);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
