import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void setVisible(boolean b){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMenu window = new UserMenu();
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
	public UserMenu() {
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
		
		JLabel lblNewLabel = new JLabel("USER MENU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(139, 25, 132, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ISSUE BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBook.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(52, 102, 121, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReturnBook = new JButton("RETURN BOOK");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.setVisible(true);
				frame.setVisible(false);
			}
			
			
		});
		btnReturnBook.setBounds(247, 102, 121, 31);
		frame.getContentPane().add(btnReturnBook);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin.setVisible(true);
			
				frame.setVisible(false);
				
			}
		});
		btnBack.setBounds(247, 164, 121, 31);
		frame.getContentPane().add(btnBack);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBook.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSearch.setBounds(52, 168, 121, 31);
		frame.getContentPane().add(btnSearch);
	}

	
}
