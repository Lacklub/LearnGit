/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.age;
import java.awt.Rectangle;
/**
 *
 * @author Admin
 */
public class ExtendedRectangle extends Rectangle{
    float H = 0;
    float S = 0;
    float B = 0;
    
    float xAcceleration = 0;
    float xVelocity = 0;
    float yAcceleration = 0;
    float yVelocity = 0;
    
    public ExtendedRectangle(){
        
    }
    
    public ExtendedRectangle(int a, int b, int c, int d){
        x = a;
        y = b;
        width = c;
        height = d;
    }
}
