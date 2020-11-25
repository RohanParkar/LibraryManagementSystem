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

public class SearchBook {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void setVisible(boolean b){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook window = new SearchBook();
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
	public SearchBook() {
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
		
		JLabel lblNewLabel = new JLabel("SEARCH BOOK");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(134, 27, 147, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBookName = new JLabel("BOOK NAME");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookName.setBounds(49, 106, 96, 25);
		frame.getContentPane().add(lblBookName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(199, 106, 96, 20);
		frame.getContentPane().add(textField);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
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
					String query="SELECT * FROM bookdb WHERE name = '"+textField.getText()+"'";
				    
					PreparedStatement stmt=conn.prepareStatement(query);
					
					ResultSet rs=stmt.executeQuery(query);
				if (rs.next())
				{
					String bkname=textField.getText();
					String author=rs.getString("author");
					int q=rs.getInt("qty");
					
					JOptionPane.showMessageDialog(null,"BOOK NAME : "+bkname+"\n AUTHOR : "+author+"\n QUANTITY : "+q+" ");
					
				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Book not Found");	
					
				
				}
				conn.close();
				}
				catch(Exception ae)
				{
					System.err.println(ae);
				}
				
			}

			private int getInt(String string) {
				// TODO Auto-generated method stub
				return 0;
			}

			private String getString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnSearch.setBounds(82, 167, 103, 34);
		frame.getContentPane().add(btnSearch);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMenu.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnBack.setBounds(245, 167, 103, 34);
		frame.getContentPane().add(btnBack);
	}


}
