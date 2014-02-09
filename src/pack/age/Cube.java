/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack.age;

import java.awt.Color;
import java.util.*;

/**
 *
 * @author Jacob
 */
public class Cube extends ThreeDObject{
    
    
    
    
    public Cube(Point startingPoint, int dimension){
        Point p1 = new Point(startingPoint);
        Point p2 = new Point(startingPoint);
        p2.x += dimension;
        Point p3 = new Point(startingPoint);
        p3.y += dimension;
        Point p4 = new Point(startingPoint);
        p4.z += dimension;
        Point p5 = new Point(startingPoint);
        p5.x += dimension;
        p5.y += dimension;
        Point p6 = new Point(startingPoint);
        p6.x += dimension;
        p6.z += dimension;
        Point p7 = new Point(startingPoint);
        p6.y += dimension;
        p6.z += dimension;
        Point p8 = new Point(startingPoint);
        p8.x += dimension;
        p8.y += dimension;
        p8.z += dimension;
        
        Triangle t1 = new Triangle(p1, p2, p3);
        t1.setColor(Color.yellow);
        Triangle t2 = new Triangle(new Point(p2), new Point(p3), p5);
        t2.setColor(Color.red);
        Triangle t3 = new Triangle(p8, p7, p6);
        t3.setColor(Color.red);
        Triangle t4 = new Triangle(new Point(p6), new Point(p7), p4);
        t4.setColor(Color.orange);
        Triangle t5 = new Triangle(new Point(p1), new Point(p1), new Point(p4));
        t5.setColor(Color.green);
        Triangle t6 = new Triangle(new Point(p4), new Point(p2), new Point(p6));
        t6.setColor(Color.blue);//top face
        Triangle t7 = new Triangle(new Point(p8), p5, new Point(p7));
        t7.setColor(Color.GREEN);
        Triangle t8 = new Triangle(new Point(p7), new Point(p5), new Point(p3));
        t8.setColor(Color.red); // top face
        Triangle t9 = new Triangle(new Point(p1), new Point(p3), new Point(p4));
        t9.setColor(Color.WHITE);
        Triangle t10 = new Triangle(new Point(p4), new Point(p3), new Point(p7));
        t10.setColor(Color.pink);
        Triangle t11 = new Triangle(new Point(p6), new Point(p5), new Point(p2));
        t11.setColor(Color.white);
        Triangle t12 = new Triangle(new Point(p5), new Point(p6), new Point(p8));
        t12.setColor(Color.DARK_GRAY);
        
        faces.add(t1); // xy plane
        faces.add(t2); // matching triangle
        faces.add(t3); // other xy plane
        faces.add(t4); // other triangle
        faces.add(t5); // xz plane
        faces.add(t6);
        faces.add(t7);
        faces.add(t8);
        faces.add(t9); // yz plane
        faces.add(t10);
        faces.add(t11);
        faces.add(t12);
    }
}
