package semester_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMenu.setBounds(226, 23, 76, 14);
		contentPane.add(lblMenu);
		
		JLabel lblWelcome = new JLabel("Welcome: "+Login.login);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWelcome.setBounds(42, 59, 139, 14);
		contentPane.add(lblWelcome);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(10, 81, 516, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblActions = new JLabel("ACTIONS");
		lblActions.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActions.setBounds(84, 9, 80, 14);
		panel.add(lblActions);
		
		JLabel lblDisplay = new JLabel("DISPLAY TABLES");
		lblDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDisplay.setBounds(317, 9, 121, 14);
		panel.add(lblDisplay);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(242, 11, 2, 265);
		panel.add(separator);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddConfirm field=new AddConfirm();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnAdd.setBounds(62, 58, 121, 23);
		panel.add(btnAdd);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search field=new Search();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnSearch.setBounds(62, 105, 121, 23);
		panel.add(btnSearch);
		
		JButton btnSale = new JButton("Sale");
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sale field=new Sale();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnSale.setBounds(62, 155, 121, 23);
		panel.add(btnSale);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteConfirm field=new DeleteConfirm();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnDelete.setBounds(62, 209, 121, 23);
		panel.add(btnDelete);
		
		JButton btnRegistrars = new JButton("Registrars");
		btnRegistrars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarsTable field=new RegistrarsTable();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrars.setBounds(317, 58, 121, 23);
		panel.add(btnRegistrars);
		
		JButton btnSuppliers = new JButton("Suppliers");
		btnSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuppliersTable field=new SuppliersTable();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnSuppliers.setBounds(317, 105, 121, 23);
		panel.add(btnSuppliers);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductsTable field=new ProductsTable();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnProducts.setBounds(317, 155, 121, 23);
		panel.add(btnProducts);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login field=new Login();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnLogout.setBounds(437, 395, 89, 23);
		contentPane.add(btnLogout);
	}
}
