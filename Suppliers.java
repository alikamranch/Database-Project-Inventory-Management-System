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
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Suppliers extends JFrame {

	private JPanel contentPane;
	private JTextField sid;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField phone;
	private JTextField city;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppliers frame = new Suppliers();
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
	public Suppliers() {
		setTitle("SUPPLIERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSuppliers = new JLabel("SUPPLIERS");
		lblSuppliers.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSuppliers.setBounds(250, 24, 109, 14);
		contentPane.add(lblSuppliers);
		
		JLabel lblAddTheSupplier = new JLabel("Add the details of the supplier of the product:");
		lblAddTheSupplier.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddTheSupplier.setBounds(47, 54, 331, 14);
		contentPane.add(lblAddTheSupplier);
		
		JLabel lblSupplierId = new JLabel("Supplier ID:");
		lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSupplierId.setBounds(157, 95, 84, 19);
		contentPane.add(lblSupplierId);
		
		JLabel lblNewLabel = new JLabel("First name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(157, 148, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(157, 203, 98, 14);
		contentPane.add(lblLastName);
		
		JLabel lblPhoneNumebr = new JLabel("Phone number:");
		lblPhoneNumebr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumebr.setBounds(157, 265, 109, 14);
		contentPane.add(lblPhoneNumebr);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCity.setBounds(157, 327, 84, 17);
		contentPane.add(lblCity);
		
		sid = new JTextField();
		sid.setBounds(335, 94, 109, 20);
		contentPane.add(sid);
		sid.setColumns(10);
		
		firstname = new JTextField();
		firstname.setBounds(335, 147, 109, 20);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(335, 202, 109, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(335, 264, 109, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		city = new JTextField();
		city.setBounds(335, 327, 109, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url = "jdbc:sqlserver://localhost:1433;databaseName=Stock Management System;user=sa;password=1234;";   
		            
		            Connection con = DriverManager.getConnection(url);
		            String query="Insert into Suppliers(s_id, s_fname, s_lname, phone, city)values(?, ?, ?, ?, ?)";
		            PreparedStatement pst=con.prepareStatement(query);
		            pst.setString(1, sid.getText());
		            pst.setString(2, firstname.getText());
		            pst.setString(3, lastname.getText());
		            pst.setString(4, phone.getText());
		            pst.setString(5, city.getText());
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Values inserted successfully!");
		            int choose=0;
		            if(choose==JOptionPane.OK_OPTION)
		            {
		            	Products field=new Products();
		            	field.setVisible(true);
		            	setVisible(false);
		            }
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnAdd.setBounds(71, 405, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sid.setText("");
				firstname.setText("");
				lastname.setText("");
				phone.setText("");
				city.setText("");
			}
		});
		btnReset.setBounds(258, 405, 89, 23);
		contentPane.add(btnReset);
		
		JButton button = new JButton("<Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddConfirm field=new AddConfirm();
				field.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(452, 405, 89, 23);
		contentPane.add(button);
	}
}
