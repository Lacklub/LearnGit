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
/**
 *
 * @author Admin
 */
public class Pong
{
    JFrame frame;
    public Pong()
    {
        frame = new JFrame("PongTestText");
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(375, 300));
        frame.getContentPane().add(emptyLabel , BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);*/
        
        Graphics rect = frame.getGraphics();
        rect.fillRect(10, 10, 10, 10);
        rect.setColor(Color.yellow);

        //5. Show it.
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Pong();
    }
}
