import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*
;
import javax.swing.JPasswordField;public class AdminLogin {

	private JFrame frame;
	private JTextField txtAdminName;
	private JPasswordField txtAdminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminLoginForm = new JLabel("Admin Login Form");
		lblAdminLoginForm.setBounds(163, 12, 150, 15);
		frame.getContentPane().add(lblAdminLoginForm);
		
		JLabel lblNewLabel = new JLabel("Admin Name");
		lblNewLabel.setBounds(52, 71, 94, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(52, 125, 66, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtAdminName = new JTextField();
		txtAdminName.setBounds(189, 69, 124, 19);
		frame.getContentPane().add(txtAdminName);
		txtAdminName.setColumns(10);
		
		JButton btnAdminLogin = new JButton("Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtAdminName.getText();
				String password = txtAdminPassword.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cucloud","root","");
					Statement stmt = con.createStatement();
					String ss = "select * from AdminLogin where AdminName = ?";
					PreparedStatement st = con.prepareStatement(ss);
					st.setString(1,username);
					ResultSet rs;
					rs = st.executeQuery();
					while(rs.next())
					{
						String pass = rs.getString("AdminPassword").toString().trim();
						if(pass.equals(password))
						{
							JOptionPane.showMessageDialog(null,"Logged in successfully");
							AdminHome.main(null);
						}
						else {
							JOptionPane.showMessageDialog(null,"Check your credentials");
						}
					
					}
					
					con.close();
				
				
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
			}
		});
		btnAdminLogin.setBounds(70, 170, 114, 25);
		frame.getContentPane().add(btnAdminLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
			}
		});
		btnBack.setBounds(225, 170, 114, 25);
		frame.getContentPane().add(btnBack);
		
		txtAdminPassword = new JPasswordField();
		txtAdminPassword.setText("");
		txtAdminPassword.setBounds(189, 123, 124, 19);
		frame.getContentPane().add(txtAdminPassword);
	}
}
