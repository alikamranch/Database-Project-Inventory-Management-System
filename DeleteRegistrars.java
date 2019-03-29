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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DeleteRegistrars extends JFrame {

	private JPanel contentPane;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteRegistrars frame = new DeleteRegistrars();
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
	public DeleteRegistrars() {
		setTitle("DELETE REGISTRARS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteFromRegistrars = new JLabel("DELETE FROM REGISTRARS");
		lblDeleteFromRegistrars.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDeleteFromRegistrars.setBounds(142, 11, 257, 14);
		contentPane.add(lblDeleteFromRegistrars);
		
		JLabel lblEnterTheUsername = new JLabel("Enter the Username you want to delete from the Registrars");
		lblEnterTheUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterTheUsername.setBounds(10, 36, 399, 14);
		contentPane.add(lblEnterTheUsername);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(142, 96, 90, 14);
		contentPane.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(268, 95, 131, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url = "jdbc:sqlserver://localhost:1433;databaseName=Stock Management System;user=sa;password=1234;";   
		            
		            Connection con = DriverManager.getConnection(url);
		           
		            String sql="Delete from Login where username='"+(username.getText()+"';");
		            PreparedStatement pst = con.prepareStatement(sql);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, (username.getText())+" deleted from the Registrations!");
		            int choose=0;
		            if(choose==JOptionPane.OK_OPTION)
		            {
		            	DeleteConfirm field=new DeleteConfirm();
		            	field.setVisible(true);
		            	setVisible(false);
		            }
		            con.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			}
		});
		btnNewButton.setBounds(37, 176, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
			}
		});
		btnNewButton_1.setBounds(230, 176, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteConfirm field=new DeleteConfirm();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(416, 176, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
