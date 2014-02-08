/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.age;


import java.util.*;
/**
 *
 * @author Admin
 */
public class Triangle {
    Point point1;
    Point point2;
    Point point3;
    
    int[] xCoordinates = new int[9];
    
    public Triangle(Point p, Point q, Point r){
        point1 = p;
        point2 = q;
        point3 = r;
        
        xCoordinates[1] = point1.x;
    }
    
    public Triangle(int x1, int y1, int z1,
            int x2, int y2, int z2, 
            int x3, int y3, int z3){
        point1.x = x1;
        point1.y = y1;
        point1.z = z1;
        point2.x = x2;
        point2.y = y2;
        point2.z = z2;
        point3.x = x3;
        point3.y = y3;
        point3.z = z3;
    }
    
    public void translate(double dx, double dy, double dz){
        point1.translate(dx, dy, dz);
        point2.translate(dx, dy, dz);
        point3.translate(dx, dy, dz);
    }
    
    public void collapseToPlane(){
        point1.collapseToPlane();
        point2.collapseToPlane();
        point3.collapseToPlane();
    }
    
    
    
}
