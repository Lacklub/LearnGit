/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.age;

/**
 *
 * @author Admin
 */
public class Point {
    float x;
    float y;
    float z;
    
    float xImage;
    float yImage;
    
    float heightConstant = 2;
    float widthConstant = 2;
    float CameraDepth = 1000;
    
    
    public Point(float i, float j, float k){
        x = i;
        y = j;
        z = k;
    }
    
    public void collapseToPlane(){
        float scaling = z/CameraDepth;
        
        yImage = (y+scaling*Pong.ScreenHeight)/heightConstant;
        xImage = (x+scaling*Pong.ScreenWidth)/widthConstant;
    }
    
    public void translate(double dx, double dy, double dz){
        x += dx;
        y += dy;
        z += dz;
    }
}
