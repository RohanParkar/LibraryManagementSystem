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

public class AdminLogin {

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
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
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
		
		JLabel label = new JLabel("ADMINLOGIN");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(146, 22, 136, 31);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("USERNAME");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(53, 87, 101, 24);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(186, 91, 146, 20);
		frame.getContentPane().add(textField);
		
		JLabel label_2 = new JLabel("PASSWORD");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(53, 131, 101, 24);
		frame.getContentPane().add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 135, 146, 20);
		frame.getContentPane().add(passwordField);
		
		JButton button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
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
				
					String query="SELECT * FROM adminlogin WHERE username = '"+textField.getText()+"'AND password = '"+passwordField.getText()+"' ";
				           
					PreparedStatement stmt=conn.prepareStatement(query);
					
					ResultSet rs=stmt.executeQuery(query);
				if (rs.next())
				{
					JOptionPane.showMessageDialog(null,"login successsfully");
				    frame.setVisible(false);
					AdminMenu.setVisible(true);
				
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
		button.setForeground(Color.BLACK);
		button.setBackground(Color.GREEN);
		button.setBounds(68, 196, 130, 37);
		frame.getContentPane().add(button);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.setVisible(false);
				
			}
		});
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(238, 196, 130, 37);
		frame.getContentPane().add(btnBack);
	}

	
}
