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
    Vector<Triangle> faces;
    public ThreeDObject(Vector<Triangle> inputFaces){
        faces = inputFaces;
    }
    public ThreeDObject(){
        faces = inputFaces;
    }
    
    public void addFace(Triangle newFace){
        faces.add(newFace);
    }
}
