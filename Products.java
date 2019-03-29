package semester_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Products extends JFrame {

	private JPanel contentPane;
	private JTextField pid;
	private JTextField quantity;
	private JTextField price;
	private JTextField sid;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products frame = new Products();
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
	public Products() {
		setTitle("PRODUCTS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducts = new JLabel("PRODUCTS");
		lblProducts.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProducts.setBounds(250, 25, 110, 14);
		contentPane.add(lblProducts);
		
		JLabel lblAddTheDetails = new JLabel("Add the details of the products:");
		lblAddTheDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddTheDetails.setBounds(56, 64, 218, 14);
		contentPane.add(lblAddTheDetails);
		
		JLabel lblNewLabel = new JLabel("Product ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(159, 103, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(159, 160, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(159, 215, 80, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(159, 281, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Supplier ID:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(159, 342, 80, 17);
		contentPane.add(lblNewLabel_4);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url = "jdbc:sqlserver://localhost:1433;databaseName=Stock Management System;user=sa;password=1234;";   
		            
		            Connection con = DriverManager.getConnection(url);
		            String query="Insert into Products(p_id, p_name, quantity, price, s_id)values(?, ?, ?, ?, ?)";
		            PreparedStatement pst=con.prepareStatement(query);
		            pst.setString(1, pid.getText());
		            pst.setString(2, name.getText());
		            pst.setString(3, quantity.getText());
		            pst.setString(4, price.getText());
		            
		            if(sid.getText().equals(""))
		            {
		            	pst.setString(5, null);
			            pst.executeUpdate();
		            }else
		            {
		            	pst.setString(5, sid.getText());
			            pst.executeUpdate();
		            }
		            
		            JOptionPane.showMessageDialog(null, "Values inserted successfully!");
		            int choose=0;
		            if(choose==JOptionPane.OK_OPTION)
		            {
		            	Menu field=new Menu();
		            	field.setVisible(true);
		            	setVisible(false);
		            }
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnAdd.setBounds(56, 430, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pid.setText("");
				name.setText("");
				quantity.setText("");
				price.setText("");
				sid.setText("");
			}
		});
		btnReset.setBounds(251, 430, 89, 23);
		contentPane.add(btnReset);
		
		JButton button = new JButton("<Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddConfirm field=new AddConfirm();
				field.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(459, 430, 89, 23);
		contentPane.add(button);
		
		pid = new JTextField();
		pid.setBounds(332, 100, 103, 20);
		contentPane.add(pid);
		pid.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(332, 212, 103, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		price = new JTextField();
		price.setBounds(332, 278, 103, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		sid = new JTextField();
		sid.setBounds(332, 339, 103, 20);
		contentPane.add(sid);
		sid.setColumns(10);
		
		name = new JTextField();
		name.setBounds(332, 159, 103, 20);
		contentPane.add(name);
		name.setColumns(10);
	}

}
