package com.example;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class ControlLoopDevelopment {
    static MouseJFrame frame;
    public static void  main(String[] args) {
        frame = new MouseJFrame("Robot Sim");
    }

    public static float timeOut = 0;

    public static float calculations(RobotGraphic robot) {
        System.out.println(robot.getDegreeRotation());
        return -robot.getDegreeRotation();
    }

}