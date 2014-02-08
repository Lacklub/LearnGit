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
import java.util.Timer;
import java.util.Random;
/**
 *
 * @author Admin
 */
public class Pong extends JPanel{

    // Create a constructor method
    public Pong(){
        super();
    }

     public void paintComponent(Graphics g){
        Random rand = new Random();
        g.setColor(Color.getHSBColor(0, 255, 0));
        g.fillRect(0, 0, 500, 500);
        
        
        g.setColor(Color.getHSBColor(rand.nextInt(256), rand.nextInt(128)+128, rand.nextInt(256)));
        g.drawLine(0,0,500,500); // Draw a line from (10,10) to (150,150)
        for(int i = 0; i < rand.nextInt(30)+10; i++){
            g.setColor(Color.getHSBColor(rand.nextInt(256), rand.nextInt(128)+128, rand.nextInt(256)));
            g.fillRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(50), rand.nextInt(50));
        }
        
    }

    public static void main(String arg[]){
        JFrame frame = new JFrame("BasicPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        Timer timer = new Timer();
        
        
        Pong panel = new Pong();
        frame.setContentPane(panel);          
        frame.setVisible(true);                   
    }
}
