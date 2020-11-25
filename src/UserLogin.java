import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;



import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class UserLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
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
	public UserLogin() {
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
		
		JLabel label = new JLabel("USERNAME");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(40, 63, 109, 39);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(180, 74, 138, 20);
		frame.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(40, 113, 109, 39);
		frame.getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 124, 138, 20);
		frame.getContentPane().add(passwordField);
		
		JButton button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
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
				
					@SuppressWarnings("deprecation")
					String query="SELECT * FROM register WHERE usernme = '"+textField.getText()+"'AND password = '"+passwordField.getText()+"' ";
				    
					PreparedStatement stmt=conn.prepareStatement(query);
					
					ResultSet rs=stmt.executeQuery(query);
				if (rs.next())
				{
					JOptionPane.showMessageDialog(null,"login successsfully");
					UserMenu.setVisible(true);
					frame.setVisible(false);
					
				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"incorrect usernme or pssword");	
					
				
				}
				conn.close();
				}
				catch(Exception ae)
				{
					System.err.println(ae);
				}
				
				
			}	
				
		});
		button.setBackground(Color.GREEN);
		button.setBounds(40, 217, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("REGISTER");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistration.setVisible(true);
frame.setVisible(false);
			}
		});
		button_1.setBackground(new Color(100, 149, 237));
		button_1.setBounds(160, 217, 109, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("BACK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.setVisible(false);
				
			}
		});
		button_2.setBackground(Color.RED);
		button_2.setBounds(306, 217, 89, 23);
		frame.getContentPane().add(button_2);
		
		JLabel lblUserLogin = new JLabel("USER LOGIN");
		lblUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserLogin.setBounds(140, 11, 109, 39);
		frame.getContentPane().add(lblUserLogin);
	}

	
}
