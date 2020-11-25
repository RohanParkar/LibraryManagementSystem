import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddBooks {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks window = new AddBooks();
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
	public AddBooks() {
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
		
		JLabel lblNewLabel = new JLabel("BOOK NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 75, 109, 27);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(175, 78, 118, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAuthor = new JLabel("AUTHOR");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuthor.setBounds(30, 113, 109, 27);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(30, 151, 109, 27);
		frame.getContentPane().add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(175, 118, 118, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(175, 156, 118, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("ADD ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{Connection conn = null;
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "library";
				String driver = "com.mysql.jdbc.Driver";
				String userName = "root"; 
				String password = "root";	 
				
				try{
						Class.forName(driver).newInstance();}
					catch(ClassNotFoundException e1)
					{
						System.err.println(e1);
					}
					conn = DriverManager.getConnection(url+dbName,userName,password);
					String query="insert into bookdb values(?,?,?)";	
					
					
					PreparedStatement pstmt=conn.prepareStatement(query);
					
					pstmt.setString(1,textField.getText());
					pstmt.setString(2,textField_1.getText());
					pstmt.setString(3,textField_2.getText());
					
					pstmt.executeUpdate();
					conn.close();
					JOptionPane.showMessageDialog(null,"Book Added Successfully  ");	
					
				}
				catch(Exception ae)
				{
					System.err.println(ae);
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(77, 205, 109, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblAddBook = new JLabel("ADD BOOK");
		lblAddBook.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAddBook.setBounds(135, 24, 109, 27);
		frame.getContentPane().add(lblAddBook);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminMenu.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(245, 205, 109, 34);
		frame.getContentPane().add(btnBack);
	}

}
