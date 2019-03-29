package semester_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField pid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setTitle("DELETE PRODUCTS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteFromInventory = new JLabel("DELETE FROM INVENTORY");
		lblDeleteFromInventory.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDeleteFromInventory.setBounds(198, 11, 257, 14);
		contentPane.add(lblDeleteFromInventory);
		
		JLabel lblEnterTheName = new JLabel("Enter the product ID and the name of the product you want to delete from the inventory");
		lblEnterTheName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterTheName.setBounds(10, 47, 597, 14);
		contentPane.add(lblEnterTheName);
		
		JLabel lblNewLabel = new JLabel("Product ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(198, 121, 90, 14);
		contentPane.add(lblNewLabel);
		
		pid = new JTextField();
		pid.setBounds(337, 120, 118, 20);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url = "jdbc:sqlserver://localhost:1433;databaseName=Stock Management System;user=sa;password=1234;";   
		            
		            Connection con = DriverManager.getConnection(url);
		           
		            String sql="Delete from Products where p_id='"+(pid.getText()+"';");
		            PreparedStatement pst = con.prepareStatement(sql);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, (pid.getText())+" deleted from the inventory!");
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
		btnNewButton.setBounds(58, 216, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pid.setText("");
			}
		});
		btnNewButton_1.setBounds(287, 216, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteConfirm field=new DeleteConfirm();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(513, 216, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
