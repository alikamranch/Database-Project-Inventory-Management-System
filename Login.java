package semester_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment_1.MainPage;

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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	static String login="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStockManagementSystem = new JLabel("STOCK MANAGEMENT SYSTEM");
		lblStockManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStockManagementSystem.setBounds(97, 23, 288, 14);
		contentPane.add(lblStockManagementSystem);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(213, 56, 66, 14);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(135, 105, 66, 14);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(135, 173, 66, 14);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(250, 104, 104, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(250, 172, 104, 20);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url = "jdbc:sqlserver://localhost:1433;databaseName=Stock Management System;user=sa;password=1234;";   
		            
		            Connection con = DriverManager.getConnection(url);
		           
		            String sql="select * from Login where username=? and password=?";
		            PreparedStatement pst = con.prepareStatement(sql);
		            pst.setString(1, username.getText());
		            pst.setString(2, password.getText());
		            login=username.getText();
		            ResultSet rs=pst.executeQuery();
		            if(rs.next())
		            {
		                JOptionPane.showMessageDialog(null, "Login Successfull!");
		                Menu field=new Menu();
		                field.setVisible(true);
		                setVisible(false);
		            }
		            else {
			            JOptionPane.showMessageDialog(null, "Username or Password not correct!", "ERROR", JOptionPane.ERROR_MESSAGE);
			            username.setText("");
			            password.setText("");
		            }
		            con.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			}
		});
		btnNewButton.setBounds(68, 268, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		btnReset.setBounds(190, 268, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration field=new Registration();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(314, 268, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
