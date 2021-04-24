package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginTest extends JFrame 
{
	private JFrame frame;
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTest window = new LoginTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginTest()
	{
		components();
	}
	
	
	private void components()
	{

		 frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 852, 634);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane loginTitle = new JTextPane();
		loginTitle.setEditable(false);
		loginTitle.setFont(new Font("Tahoma", Font.PLAIN, 33));
		loginTitle.setBounds(307, 20, 329 , 102);
		loginTitle.setText("Shopping Cart App");
		frame.getContentPane().add(loginTitle);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.CYAN);
		textArea.setLineWrap(true);
		textArea.setText(" Username: ");
		textArea.setBounds(250, 210, 70, 20);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setBackground(Color.CYAN);
		textArea1.setLineWrap(true);
		textArea1.setText(" Password: ");
		textArea1.setBounds(250, 250, 70, 20);
		frame.getContentPane().add(textArea1);
		
		JButton signButton = new JButton("Sign In ");
		signButton.setBounds(400,300,100,30);
		frame.getContentPane().add(signButton);
		
		JButton accButton = new JButton(" Create Account ");
		accButton.setBounds(300,350,300,30);
		frame.getContentPane().add(accButton);
	
		JTextField userField = new JTextField();
		userField.setBounds(350, 210, 200,20);
		frame.getContentPane().add(userField);
		

		JTextField passField = new JTextField();
		passField.setBounds(350, 250, 200,20);
		frame.getContentPane().add(passField);
		
		
	}
}
