package semester_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddConfirm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddConfirm frame = new AddConfirm();
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
	public AddConfirm() {
		setTitle("ADD CONFIRMATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddConfirmation = new JLabel("ADD CONFIRMATION");
		lblAddConfirmation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddConfirmation.setBounds(108, 11, 218, 14);
		contentPane.add(lblAddConfirmation);
		
		JButton btnNewButton = new JButton("Suppliers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suppliers field= new Suppliers();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(162, 84, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Products");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products field= new Products();
				field.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(162, 150, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("<Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu field= new Menu();
				field.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(323, 240, 89, 23);
		contentPane.add(button);
	}
}
