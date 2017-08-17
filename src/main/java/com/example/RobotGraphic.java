package com.example;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by matt on 8/12/17.
 */

class RobotGraphic extends JPanel {

    public int x;
    public int y;
    private int w;
    private int h;
    private float degreeRotation;
    private JFrame f;
    int cap = BasicStroke.CAP_BUTT;
    int join = BasicStroke.JOIN_MITER;
    BasicStroke thick = new BasicStroke(15,cap,join);
    public RobotGraphic(int x, int y, int w, int h, JFrame f) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.degreeRotation = 0;
        this.f = f;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // do your superclass's painting routine first, and then paint on top of it.
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(degreeRotation));
        g2d.fillRect(-w/2, -h/2, w, h);
        g2d.setColor(Color.RED);
        g2d.setStroke(thick);
        g2d.draw(new Line2D.Double(0, -h/2, 0, 10));
    }


    public void rotateTo(Float degrees) {
        this.degreeRotation = degrees;
        f.repaint();
    }
    public void rotate(Float degrees) {
        this.degreeRotation += degrees / 120;
        f.repaint();
    }
    public float getDegreeRotation() {
        return this.degreeRotation;
    }
}