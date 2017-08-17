package com.example;

public class ControlLoopDevelopment {

    public static void calculations() throws InterruptedException {

        // Do your calculations here!
        // setSpeed(speed_value) sets the robots speed of rotation
        // Put Thread.sleep(16); in all of your while loops or you're computer will explode.
        // The imu class allows access to imu readings.
        // while loops should include || magic condition... because magic.

    }

    //<editor-fold desc="behind the scenes magic">
    static MouseJFrame frame;
    static boolean magic;
    public static void  main(String[] args) throws InterruptedException {
        frame = new MouseJFrame("Robot Sim");
        magic = frame.magic;
        calculations();
    }
    public static float timeOut = 0;
    private static void setSpeed(float d) {
        if (!frame.isDragging) {
            frame.rg.rotate(d);
        }
    }

    //</editor-fold>

}

class imu {
    static float getDegreeRotation() {
        return ControlLoopDevelopment.frame.rg.getDegreeRotation();
    }
}