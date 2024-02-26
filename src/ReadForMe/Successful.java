package ReadForMe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Successful extends JFrame {
    JButton back;
    JLabel imageLabel;

    Successful() {
        
        getContentPane().setBackground(new Color(250, 231, 201));

        
        setVisible(true);
        setSize(500, 476);
        setTitle("Mission Accomplished");
        setLocation(550, 155);
        setResizable(false);

        
        JPanel panel = new JPanel(new BorderLayout());

        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Images/success.jpg"));

        
        Image image = imageIcon.getImage();

        
        Image resizedImage = image.getScaledInstance(500, 436, Image.SCALE_SMOOTH);

      
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

      
        imageLabel = new JLabel(resizedImageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

      
        back = new JButton("Back to Login");
        back.setBackground(new Color(176, 146, 106));
        back.setForeground(Color.white);
        back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Login();
			}
        	
        });

        
        panel.add(back, BorderLayout.SOUTH);

       
        setContentPane(panel);
    }

    public static void main(String[] args) {
        
        new Successful();
    }
}
