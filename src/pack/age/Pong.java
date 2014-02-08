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
public class Pong extends JPanel{

    // Create a constructor method
    public Pong(JFrame frame){
        super();
        Timer timer = new Timer();
        final JFrame f = frame;
        
        final Vector<ExtendedRectangle> rects = new Vector<ExtendedRectangle>();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                
                f.removeAll();
                paintComponent(f.getGraphics(), rects);
                f.update(f.getGraphics());
            }
         }, 40, 40);
    }
    
    public void paintComponent(Graphics g, Vector<ExtendedRectangle> rects){
        
        Random rand = new Random();
        g.setColor(Color.getHSBColor(0, 255, 0));
        g.fillRect(-10, -10, 2000, 1500);
        //g.setColor(Color.getHSBColor(rand.nextInt(256), rand.nextInt(128)+128, rand.nextInt(256)));
        //g.drawLine(0,0,500,500); // Draw a line from (10,10) to (150,150)
        if(rects.isEmpty()){
            for(int i = 0; i < rand.nextInt(101)+400; i++){
                //g.setColor(Color.getHSBColor(rand.nextInt(256), rand.nextInt(128)+128, rand.nextInt(256)));
                
                ExtendedRectangle rect = new ExtendedRectangle(rand.nextInt(1680), rand.nextInt(1050), rand.nextInt(100), rand.nextInt(100));
                rect.H = rand.nextInt(256);
                rect.S = rand.nextInt(128)+128;
                rect.B = rand.nextInt(256);
                g.setColor(Color.getHSBColor(rect.H, rect.S, rect.B));
                g.fillRect(rect.x, rect.y, rect.width, rect.height);
                rects.addElement(rect);
            }
        }
        else
        {
            
            for(int i = 0; i < rects.size(); i++){
                ExtendedRectangle rect = rects.get(i);
                
                g.setColor(Color.getHSBColor(rect.H, rect.S, rect.B));
                
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
                
                rect.width += (float)(rand.nextInt(3) - 1)/2;
                rect.height += (float)(rand.nextInt(3) - 1)/2;
                
                rect.x += rect.xVelocity;
                rect.y += rect.yVelocity;
                
                keepOnScreen(rect);
                
                g.fillRect(rect.x, rect.y, rect.width, rect.height);
                
            }
        }
        
    }

    public static void main(String arg[]){
        JFrame frame = new JFrame("BasicPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1680,1050);
        

        
        
        Pong panel = new Pong(frame);
        frame.setContentPane(panel);
        frame.setVisible(true);
        
    }
    
    public void keepOnScreen(ExtendedRectangle rect){
        if(rect.x > 1680){
            rect.x = -rect.width;
        }
        else if(rect.x + rect.width < 0){
            rect.x = 1680;
        }
        
        if(rect.y > 1680){
            rect.y = -rect.height;
        }
        else if(rect.y + rect.height < 0){
            rect.y = 1680;
        }
    }
    
}
