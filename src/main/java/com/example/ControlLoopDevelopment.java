package com.example;

public class ControlLoopDevelopment {

    public static void calculations() throws InterruptedException {
        while (imu.getDegreeRotation() != 0 || magic) {
            rotate(-imu.getDegreeRotation());
            System.out.println(imu.getDegreeRotation());
            Thread.sleep(16); // prevents your computer from exploding
        }
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
    private static void rotate(float d) {
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