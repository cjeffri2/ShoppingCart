package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.util.*;
import java.sql.*;

public class PendingPage 
{
	private JFrame frame;
	private JComboBox comboBox;
	private JLabel l,l1;
	private JTextField textField;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PendingPage window = new PendingPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PendingPage()
	{
		components();
		
		createComboBox();
		
		heading();
		
		
		approveButton();
		
		denyButton();
		
		
	}
	
	private void components() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 852, 634);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	}

	
	private void createComboBox()
	{
		
		
		
		
			
			
		
		comboBox = new JComboBox();
		comboBox.addItem("jake ");
		comboBox.addItem("paul");
		comboBox.addItem("Peter");
		
		
		comboBox.setEditable(false);
		comboBox.setBounds(120, 205 , 200, 20);
		frame.getContentPane().add(comboBox);
		
		
			
	}
	
	
	
	
	
	private void heading()
	{
		JTextPane loginTitle = new JTextPane();
		loginTitle.setEditable(false);
		loginTitle.setFont(new Font("Tahoma", Font.PLAIN, 33));
		loginTitle.setBounds(307, 20, 329 , 102);
		loginTitle.setText("Pending Orders");
		frame.getContentPane().add(loginTitle);
	}
	
	
	private void approveButton()
	{
		JButton button1 = new JButton("Approve");
		
		button1.setBounds(650, 420 , 100, 20);
		frame.getContentPane().add(button1);

		
	}
	
	
	
	
	
	private void denyButton()
	{
		
	
			JButton button2 = new JButton("Deny");
			button2.setBounds(650, 450 , 100, 20);
			frame.getContentPane().add(button2);
		
		
	}

	}
