package semester_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class RegistrarsTable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarsTable frame = new RegistrarsTable();
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
	public RegistrarsTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 301, 292);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("<Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu field=new Menu();
				field.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(222, 314, 89, 23);
		contentPane.add(button);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Stock Management System;user=sa;password=1234;";
            Connection con = DriverManager.getConnection(url);
            String query="Select username from Login";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}
	}

}
