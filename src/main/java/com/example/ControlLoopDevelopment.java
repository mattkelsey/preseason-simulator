package com.example;

public class ControlLoopDevelopment {
    static MouseJFrame frame;
    public static void  main(String[] args) {
        frame = new MouseJFrame("Robot Sim");
    }

    public static float timeOut = 0;

     static float proportional = 0;
     static float integral = 0;
     static float derivative = 0;

    static float lastP = 0;

    static float output =  0;

    static float kP = 3;
    static float kI = 1;
    static float kD = 4;

    static long lastTime = System.currentTimeMillis();

    public static float calculations(RobotGraphic robot) {

        long now = System.currentTimeMillis();
        System.out.println(now);
        //System.out.println(robot.getDegreeRotation());
        proportional = -robot.getDegreeRotation();
        integral += (proportional * (float)(now - lastTime));
        System.out.println("integral: " + integral);
        derivative = (proportional-lastP)/(float) (now - lastTime);
      //  System.out.println(proportional + " " + integral + " " + derivative);
        output = /*(integral * kI) + */(proportional * kP) + (derivative * kD);
        lastTime = now;
        lastP = proportional;
        return output;
    }

}
