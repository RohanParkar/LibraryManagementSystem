import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void setVisible(boolean b){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu window = new AdminMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN MENU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(137, 25, 141, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADD BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBooks.setVisible(true);
				frame.setVisible(false);
				
				}
		});
		btnNewButton.setBounds(40, 97, 141, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCustomerDetails = new JButton("CUSTOMER DETAILS");
		btnCustomerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewCustomerDetails.setVisible(true);
				
				frame.setVisible(false);
				
			}
		});
		btnCustomerDetails.setBounds(40, 167, 141, 30);
		frame.getContentPane().add(btnCustomerDetails);
		
		JButton btnDeleteBook = new JButton("DELETE BOOK");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBooks.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnDeleteBook.setBounds(234, 97, 141, 30);
		frame.getContentPane().add(btnDeleteBook);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnBack.setBounds(234, 167, 141, 30);
		frame.getContentPane().add(btnBack);
	}

	
}
