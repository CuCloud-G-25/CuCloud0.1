import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*
;public class Login {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
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
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setBounds(183, 12, 91, 15);
		frame.getContentPane().add(lblLoginForm);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(49, 63, 104, 15);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(49, 120, 104, 15);
		frame.getContentPane().add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(181, 61, 124, 19);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(181, 118, 124, 19);
		frame.getContentPane().add(txtPassword);
		
		JButton btnUserLogin = new JButton("User Login");
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUserName.getText();
				String password = txtPassword.getText();
				//creating mysql connection
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cucloud","root","");
					Statement stmt = con.createStatement();
					String ss = "select * from SignUp where Username = ?";
					PreparedStatement st = con.prepareStatement(ss);
					st.setString(1,username);
					ResultSet rs;
					rs = st.executeQuery();
					while(rs.next())
					{
						String pass = rs.getString("Password").toString().trim();
						if(pass.equals(password))
						{
							JOptionPane.showMessageDialog(null,"Logged in successfully");
							UserHome.main(null);
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
				
				/*if(password.contains("ubuntu") && username.contains("dypcet")) {
					JOptionPane.showMessageDialog(null, "Logged in Successful");
				}
				else {
					JOptionPane.showMessageDialog(null, "Check Your Credentials");
				}*/
				
			}
		
		});
		btnUserLogin.setBounds(24, 191, 114, 25);
		frame.getContentPane().add(btnUserLogin);
		
		JButton btnAdminLogin = new JButton("Login as Admin");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLogin add=new AdminLogin();
				AdminLogin.main(null);
			}
		});
		btnAdminLogin.setBounds(152, 191, 153, 25);
		frame.getContentPane().add(btnAdminLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp();
				SignUp.main(null);
			}
		});
		btnSignUp.setBounds(314, 191, 114, 25);
		frame.getContentPane().add(btnSignUp);
	}
}
