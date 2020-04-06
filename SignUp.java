import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JPasswordField txtConPassword;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
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
		
		JLabel lblSignUpForm = new JLabel("Sign Up Form");
		lblSignUpForm.setBounds(188, 12, 110, 15);
		frame.getContentPane().add(lblSignUpForm);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(50, 59, 125, 15);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 95, 125, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(50, 128, 125, 15);
		frame.getContentPane().add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(50, 161, 125, 15);
		frame.getContentPane().add(lblEmail);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(249, 55, 124, 19);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(249, 93, 124, 19);
		frame.getContentPane().add(txtPassword);
		
		txtConPassword = new JPasswordField();
		txtConPassword.setBounds(249, 126, 124, 19);
		frame.getContentPane().add(txtConPassword);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(249, 159, 124, 19);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cucloud","root","");
					Statement stmt = con.createStatement();
					int UserID=0;
					String Username,Password,email;
					Username = txtUserName.getText();
					Password = txtPassword.getText();
					email = txtEmail.getText();
					String s = "insert into SignUp (Username,Password,email) values('"+Username+"','"+Password+"','"+email+"')";
					PreparedStatement st = con.prepareStatement(s);

						JOptionPane.showMessageDialog(null,"Logged in successfully");
						Login.main(null);
						st.execute();
						con.close();
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSignUp.setBounds(89, 206, 114, 25);
		frame.getContentPane().add(btnSignUp);
		
		JButton btnBackS = new JButton("Back");
		btnBackS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
			}
		});
		btnBackS.setBounds(223, 206, 114, 25);
		frame.getContentPane().add(btnBackS);
	}

}
