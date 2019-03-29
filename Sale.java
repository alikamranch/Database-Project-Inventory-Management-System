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

public class Sale extends JFrame {

	private JPanel contentPane;
	private JTextField pid;
	private JTextField quantity;
	private int SaleQuantity=0;
	private int DatabaseQuantity=0;
	private int newQuantity=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale frame = new Sale();
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
	public Sale() {
		setTitle("SALE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSale = new JLabel("SALE");
		lblSale.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSale.setBounds(233, 11, 56, 14);
		contentPane.add(lblSale);
		
		JLabel lblMakeASale = new JLabel("Make a sale from the inventory:");
		lblMakeASale.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMakeASale.setBounds(10, 47, 206, 14);
		contentPane.add(lblMakeASale);
		
		JLabel lblNewLabel = new JLabel("Product ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(159, 116, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(159, 176, 75, 17);
		contentPane.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setBounds(273, 113, 86, 20);
		contentPane.add(pid);
		pid.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(273, 173, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JButton btnNewButton = new JButton("Sell");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url = "jdbc:sqlserver://localhost:1433;databaseName=Stock Management System;user=sa;password=1234;";   
		            
		            Connection con = DriverManager.getConnection(url);
		            String sql="select quantity from Products where p_id= '"+pid.getText()+"';";
		            PreparedStatement pst = con.prepareStatement(sql);
		            ResultSet rs=pst.executeQuery();
		            while(rs.next())
		            {
		            	DatabaseQuantity=rs.getInt("quantity");
		            }
		            SaleQuantity=Integer.parseInt(quantity.getText());
		            if(DatabaseQuantity>=SaleQuantity)
		            {
		            	newQuantity=DatabaseQuantity-SaleQuantity;
		            	Connection con2 = DriverManager.getConnection(url);
		            	String query="Update Products set quantity="+newQuantity+" where p_id='"+pid.getText()+"';";
		            	PreparedStatement pst2=con2.prepareStatement(query);
		            	pst2.executeUpdate();
		            	JOptionPane.showMessageDialog(null, "Sale made successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		            	int choose=0;
				            if(choose==JOptionPane.OK_OPTION)
				            {
				            	Menu field=new Menu();
				            	field.setVisible(true);
				            	setVisible(false);
				            }
		            }else
		            {
		            	JOptionPane.showMessageDialog(null, "Inventory has only "+DatabaseQuantity+" items of the given Product Id!", "Failure", JOptionPane.ERROR_MESSAGE);
		            }
		          
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			}
		});
		btnNewButton.setBounds(41, 277, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pid.setText("");
				quantity.setText("");
			}
		});
		btnNewButton_1.setBounds(212, 277, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu field=new Menu();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(395, 277, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
