package com.example;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.Date;

import javax.swing.JFrame;

import static java.lang.Float.NaN;

/**
 * Created by matt on 8/12/17.
 */

public class MouseJFrame extends JFrame implements MouseMotionListener {
    RobotGraphic rg;
    boolean isDragging = false;
    long startTime = 0;

    public MouseJFrame(String title) {
        super(title);
        addMouseMotionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,2));
        this.setSize(200, 200);
        this.pack();
        this.setVisible(true);
        rg = new RobotGraphic(500, 500, 100, 100, this);
        this.add(rg);

        while (startTime < 1 || ControlLoopDevelopment.timeOut < 10 || System.currentTimeMillis() - startTime < ControlLoopDevelopment.timeOut) {
            if (!isDragging && rg.getDegreeRotation() != 0) {
                rg.rotate(ControlLoopDevelopment.calculations(rg));
            }
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        isDragging = true;
        int mouseX = mouseEvent.getX() - rg.x;
        int mouseY = mouseEvent.getY() - rg.y;
        float hyp = (float) Math.sqrt(Math.pow(mouseY, 2) + Math.pow(mouseX, 2));
        float newX = mouseX/hyp;
        float newY = mouseY/hyp;

        float ang;

        if(newY < 0) {
            ang = (float) (2*Math.PI - Math.acos(newX));
        } else {
            ang = (float) Math.acos(newX);
        }

        rg.rotateTo((float) Math.toDegrees(ang));
        startTime = System.currentTimeMillis();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        isDragging = false;
    }
}