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
import java.awt.event.ActionEvent;

public class IssueBook {

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
					IssueBook window = new IssueBook();
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
	public IssueBook() {
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
		
		JLabel lblUsename = new JLabel("USERNAME");
		lblUsename.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsename.setBounds(72, 88, 96, 25);
		frame.getContentPane().add(lblUsename);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(230, 92, 96, 20);
		frame.getContentPane().add(textField);
		
		JButton btnIssue = new JButton("ISSUE");
		btnIssue.addActionListener(new ActionListener() {
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
					
					String query4="SELECT * FROM userbook WHERE bookname='"+textField_1.getText()+"'AND username='"+textField.getText()+"' ";	
                    PreparedStatement stmt4=conn.prepareStatement(query4);
					
					ResultSet rs4=stmt4.executeQuery(query4);
				if (rs4.next())
				{	
					JOptionPane.showMessageDialog(null,"BOOK already issued");	
				}
				else
				{
					
					
					String query="select * from register where usernme='"+textField.getText()+"'";	
					
                        PreparedStatement stmt=conn.prepareStatement(query);
					
					ResultSet rs=stmt.executeQuery(query);
				      if (rs.next())
				           {
					      
						    String query1="select * from bookdb where name='"+textField_1.getText()+"'";	
			                PreparedStatement stmt1=conn.prepareStatement(query1);
							ResultSet rs1=stmt1.executeQuery(query1);
							if (rs1.next())	
							{  
								    int q=rs1.getInt("qty");
								if(q!=0)
								    {
								    	String book=rs1.getString("name");
								    	
								    	
								    	
								    	String query2="insert into userbook values(?,?)";	
										
								    
										PreparedStatement pstmt=conn.prepareStatement(query2);
										
										pstmt.setString(1,textField.getText());
										pstmt.setString(2,book);
									
										pstmt.executeUpdate();
									
										String query3= "UPDATE bookdb SET qty = ? WHERE name = '"+book+"' ";
										 PreparedStatement pSt = conn.prepareStatement(query3);
					                        pSt.setInt(1,q-1);

					                        pSt.executeUpdate();
					                        JOptionPane.showMessageDialog(null,"Book Added Successfully  ");	
								    }
								    else
								    {
								    	JOptionPane.showMessageDialog(null,"BOOKS finished");	
								    }
								
								
								
								
								
							}
							else
							{
								JOptionPane.showMessageDialog(null,"BOOK NOT FOUND");	
							}
					
					
					
					
					
					
				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"incorrect usernme ");	
					
				
				}
				
					
				}
				      
				      
				      
				      
					conn.close();
					
					
				}
				catch(Exception ae)
				{
					System.err.println(ae);
				}
				
				
				
				}
		});
		btnIssue.setBounds(95, 187, 103, 34);
		frame.getContentPane().add(btnIssue);
		
		JLabel lblIssueBook = new JLabel("ISSUE BOOK");
		lblIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblIssueBook.setBounds(113, 33, 147, 37);
		frame.getContentPane().add(lblIssueBook);
		
		JLabel label_1 = new JLabel("BOOK NAME");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(72, 131, 96, 25);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(230, 136, 96, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMenu.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnBack.setBounds(230, 187, 103, 34);
		frame.getContentPane().add(btnBack);
	}

	
}
