/*
 * To change this template, choose Tools | Templates
 * and do the dance. open the template in the editor.
 */
package pack.age;
import java.awt.Frame;
import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;


/*
 *
 * @author Admin
 */
public class TestingGraphics extends JPanel{
    
    public static final int ScreenWidth = 1680;
    public static final int ScreenHeight = 1050;
    
    

    // Create a constructor method
    public TestingGraphics(JFrame frame){
        super();
        Timer timer = new Timer();
        final JFrame f = frame;
        
        final Vector<ExtendedRectangle> rects = new Vector<ExtendedRectangle>();
        final Vector<ThreeDObject> scene = new Vector<ThreeDObject>();
        
        initializeObjectsInSpace(scene);
        
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                
                f.removeAll();
                paintComponent(f.getGraphics(), scene);
                f.update(f.getGraphics());
            }
         }, 40, 40);
    }
    
    public void paintComponent(Graphics g, Vector<ThreeDObject> scene){
        
        Random rand = new Random();
        g.setColor(Color.getHSBColor(0, 1, 0));//backgraound
        g.fillRect(-10, -10, 2000, 1500);
        
        processImages(scene);
        drawImages(g, scene);
        //g.setColor(Color.getHSBColor(rand.nextInt(256), rand.nextInt(128)+128, rand.nextInt(256)));
        //g.drawLine(0,0,500,500); // Draw a line from (10,10) to (150,150)
        
        /*
        if(rects.isEmpty()){
            for(int i = 0; i < rand.nextInt(101)+200; i++){
                //g.setColor(Color.getHSBColor(rand.nextInt(256), rand.nextInt(128)+128, rand.nextInt(256)));
                
                ExtendedRectangle rect = new ExtendedRectangle(rand.nextInt(ScreenWidth), rand.nextInt(ScreenHeight), rand.nextInt(100), rand.nextInt(100));
                rect.H = rand.nextFloat();
                rect.S = (rand.nextFloat()+1)/2;
                rect.B = (rand.nextFloat()+1)/2;
                g.setColor(Color.getHSBColor(rect.H, rect.S, rect.B));
                g.fillRect(rect.x, rect.y, rect.width, rect.height);
                rects.addElement(rect);
            }
        }
        else
        {
            
            for(int i = 0; i < rects.size(); i++){
                ExtendedRectangle rect = rects.get(i);
                
                
                rect.xVelocity += (float)(rand.nextInt(3) - 1);
                rect.yVelocity += (float)(rand.nextInt(3) - 1);
                
                if (rect.xVelocity > 5){
                    rect.xVelocity = 5;
                }else if (rect.xVelocity < -5){
                    rect.xVelocity = -5;
                }
                if(rect.yVelocity > 5){
                    rect.yVelocity = 5;
                } else if (rect.yVelocity < -5){
                    rect.yVelocity = -5;
                }
                
                rect.width += (float)(rand.nextInt(3) - 1);
                rect.height += (float)(rand.nextInt(3) - 1);
                
                rect.H += rand.nextFloat()/10 - 0.05;
                rect.S += rand.nextFloat()/10 - 0.05;
                rect.B += rand.nextFloat()/10 - 0.05;
                
                
                if(rect.S < 0.5){
                    rect.S =(float) 0.5;
                } 
                if(rect.B < 0.5){
                    rect.B =(float) 0.5;
                }
                if(rect.S > 1){
                    rect.S = 1;
                } 
                if(rect.B > 1){
                    rect.B = 1;
                }
                
                rect.x += rect.xVelocity;
                rect.y += rect.yVelocity;
                
                if(rect.width < 0){
                    rect.width = -rect.width;
                }
                if(rect.height < 0){
                    rect.height = -rect.height;
                }
                
                keepOnScreen(rect);
                
                g.setColor(Color.getHSBColor(rect.H, rect.S, rect.B));
                g.fillRect(rect.x, rect.y, rect.width, rect.height);
                
            }
        }*/
        
    }

    public static void main(String arg[]){
        JFrame frame = new JFrame("BasicPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ScreenWidth,ScreenHeight);
        

        
        
        TestingGraphics panel = new TestingGraphics(frame);
        frame.setContentPane(panel);
        frame.setVisible(true);
        
    }
    
    public void keepOnScreen(ExtendedRectangle rect){
        if(rect.x > ScreenWidth){
            rect.x = -rect.width;
        }
        else if(rect.x + rect.width < 0){
            rect.x = ScreenWidth;
        }
        
        if(rect.y > ScreenHeight){
            rect.y = -rect.height;
        }
        else if(rect.y + rect.height < 0){
            rect.y = ScreenHeight;
        }
    }
    
    public void initializeObjectsInSpace(Vector<ThreeDObject> scene){ //init
        Point middle = new Point(0, 0, 0);
        Cube newCube = new Cube(middle, 500);
        Point p1 = new Point(50, 50, 0);
        Point p2 = new Point(1000, 0, 0);
        Point p3 = new Point(0, 1000, 0);
        ThreeDObject shape = new ThreeDObject();
        Triangle t1 = new Triangle(p1, p2, p3);
        shape.addFace(t1);
        
        
        
        scene.add(shape);
        scene.add(newCube);
    }
    
    public void processImages(Vector<ThreeDObject> scene){ // move everything a frame
        for(int k = 0; k < scene.size(); k++){
            for(int i = 0; i < scene.elementAt(k).faces.size(); i++){
                scene.elementAt(k).translate(0, 0, 1);
            }
        }
        //scene.elementAt(1).rotate(4);
    }
    
    public void drawImages(Graphics g, Vector<ThreeDObject> scene){ // draw them to screen
        
        for(int k = 0; k < scene.size(); k++){
            scene.elementAt(k).collapseToPlane();
            for(int i = 0; i < scene.elementAt(k).faces.size(); i++){
                g.setColor(scene.elementAt(k).faces.elementAt(i).triangleColor);
                g.fillPolygon(scene.elementAt(k).faces.elementAt(i).apparentXCoordinates, 
                        scene.elementAt(k).faces.elementAt(i).apparentYCoordinates, 
                        scene.elementAt(k).faces.elementAt(i).apparentYCoordinates.length);
            }
        }
    }
}
