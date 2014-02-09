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
public class ThreeDObject {
    Vector<Triangle> faces = new Vector<Triangle>();
    
    public ThreeDObject(Vector<Triangle> inputFaces){
        faces = inputFaces;
    }
    public ThreeDObject(){
    }
    
    public void addFace(Triangle newFace){
        faces.add(newFace);
    }
    
    public void collapseToPlane(){
        for(int i = 0; i < faces.size(); i++){
            faces.get(i).collapseToPlane();
        }
    }
    
    public void translate(double dx, double dy, double dz){
        for(int i = 0; i < faces.size(); i++){
            faces.elementAt(i).translate(dx, dy, dz);
        }
        for(int i = 0; i < faces.size(); i++){
            faces.elementAt(i).resetTranslation();
        }
    }
    
    public void rotate(float theta){
        
    }
}
