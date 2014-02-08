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
    int x;
    int y;
    int z;
    
    int xImage;
    int yImage;
    
    double heightConstant = 2;
    double widthConstant = 2;
    int CameraDepth = 1000;
    
    
    public Point(int i, int j, int k){
        x = i;
        y = j;
        z = k;
    }
    
    public void collapseToPlane(){
        float scaling = z/CameraDepth;
        
        yImage = (int)((y+scaling*Pong.ScreenHeight)/heightConstant);
        xImage = (int)((x+scaling*Pong.ScreenWidth)/widthConstant);
    }
    
    public void translate(double dx, double dy, double dz){
        x += dx;
        y += dy;
        z += dz;
    }
}
