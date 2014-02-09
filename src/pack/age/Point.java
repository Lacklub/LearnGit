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
    
    double heightConstant = 1;
    double widthConstant = 1;
    float CameraDepth = 1000;
    
    public Boolean isTranslated = false;
    
    public Point(int i, int j, int k){
        x = i;
        y = j;
        z = k;
    }
    
    public Point(Point copyPoint){
        x = copyPoint.x;
        y = copyPoint.y;
        z = copyPoint.z;
    }
    
    public void collapseToPlane(){
        float scaling = z/CameraDepth;
        yImage = (int)((y+scaling*TestingGraphics.ScreenHeight/2)/(scaling+1));
        xImage = (int)((x+scaling*TestingGraphics.ScreenWidth/2)/(scaling+1));
    }
    
    public void translate(double dx, double dy, double dz){
        x += dx;
        y += dy;
        z += dz;
    }
}
