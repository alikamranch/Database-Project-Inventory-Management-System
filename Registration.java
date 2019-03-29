package semester_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment_1.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField cpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setTitle("REGISTRATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("REGISTER");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSignUp.setBounds(216, 29, 109, 14);
		contentPane.add(lblSignUp);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(137, 95, 76, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(137, 148, 76, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(137, 206, 129, 14);
		contentPane.add(lblConfirmPassword);
		
		username = new JTextField();
		username.setBounds(281, 94, 100, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(281, 147, 100, 20);
		contentPane.add(password);
		
		cpassword = new JPasswordField();
		cpassword.setBounds(281, 205, 100, 20);
		contentPane.add(cpassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url = "jdbc:sqlserver://localhost:1433;databaseName=Stock Management System;user=sa;password=1234;";   
		            
		            Connection con = DriverManager.getConnection(url);
		            String query="Insert into Login(username, password)values(?, ?)";
		            PreparedStatement pst=con.prepareStatement(query);
		            if(password.getText().equals(cpassword.getText()))
		            {
		            	pst.setString(1, username.getText());
			            pst.setString(2, password.getText());
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Signed up successfully!");
			            int choose=0;
			            if(choose==JOptionPane.OK_OPTION)
			            {
			            	Login field=new Login();
			            	field.setVisible(true);
			            	setVisible(false);
			            }
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
		            	password.setText("");
						cpassword.setText("");
		            }
		            
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnRegister.setBounds(124, 298, 89, 23);
		contentPane.add(btnRegister);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
				cpassword.setText("");
			}
		});
		btnNewButton.setBounds(305, 298, 89, 23);
		contentPane.add(btnNewButton);
	}

}
