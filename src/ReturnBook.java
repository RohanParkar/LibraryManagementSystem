import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ReturnBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
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
	public ReturnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("BOOK NAME");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(83, 136, 96, 25);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(239, 140, 96, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblReturnBook = new JLabel("RETURN BOOK");
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblReturnBook.setBounds(119, 34, 147, 37);
		frame.getContentPane().add(lblReturnBook);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserName.setBounds(83, 93, 96, 25);
		frame.getContentPane().add(lblUserName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(239, 97, 96, 20);
		frame.getContentPane().add(textField_1);
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					Connection conn = null;
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "library";
				String driver = "com.mysql.jdbc.Driver";
				String userName = "root"; 
				String password = "root";	 
				
				try{
						Class.forName(driver).newInstance();
						}
					catch(ClassNotFoundException e1)
					{
						System.err.println(e1);
					}
					conn = DriverManager.getConnection(url+dbName,userName,password);
					String query="DELETE FROM userbook WHERE bookname='"+textField.getText()+"'AND username='"+textField_1.getText()+"' ";	
					
                 Statement stmt=conn.createStatement();
                 stmt.executeUpdate(query);
					
				
					
					
                 
					  String query1="select * from bookdb where name='"+textField.getText()+"'";	
		                PreparedStatement stmt1=conn.prepareStatement(query1);
						ResultSet rs1=stmt1.executeQuery(query1);
						if (rs1.next())	
						{  
						int q=rs1.getInt("qty");
						
					
						String query3= "UPDATE bookdb SET qty = ? WHERE name = '"+textField.getText()+"' ";
					 PreparedStatement pSt = conn.prepareStatement(query3);
                       pSt.setInt(1,q+1);

                       pSt.executeUpdate();
					
                       JOptionPane.showMessageDialog(null,"Book RETURNED successsfully");
						}
						else
						{
							  JOptionPane.showMessageDialog(null,"Book not found");
						}
					
			
					conn.close();
					
					
				}
				catch(Exception ae)
				{
					System.err.println(ae);
				}
				
				
				
				
				
				
				
			}
		});
		btnReturn.setBounds(83, 200, 103, 34);
		frame.getContentPane().add(btnReturn);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMenu.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnBack.setBounds(239, 200, 103, 34);
		frame.getContentPane().add(btnBack);
		
	
	}

}
