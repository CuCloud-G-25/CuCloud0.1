import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHome {

	private JFrame frame;
	private JTable table;
	private JTextField txtUserID;
	private JTextField txtUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
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
	public AdminHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminHome = new JLabel("Admin Home");
		lblAdminHome.setBounds(227, 12, 100, 15);
		frame.getContentPane().add(lblAdminHome);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(254, 59, 1, 357);
		frame.getContentPane().add(separator);
		
		table = new JTable();
		table.setBounds(22, 110, 225, 285);
		frame.getContentPane().add(table);
		
		JLabel lblUserList = new JLabel("User List");
		lblUserList.setBounds(92, 36, 66, 15);
		frame.getContentPane().add(lblUserList);
		
		JButton btnGetList = new JButton("Get List");
		btnGetList.setBounds(68, 60, 114, 25);
		frame.getContentPane().add(btnGetList);
		
		JLabel lblNewLabel = new JLabel("UserID");
		lblNewLabel.setBounds(273, 110, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setBounds(273, 175, 80, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(379, 108, 124, 19);
		frame.getContentPane().add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(379, 173, 124, 19);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JButton btnNewButton = new JButton("Grant");
		btnNewButton.setBounds(267, 221, 86, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRevoke = new JButton("Revoke");
		btnRevoke.setBounds(365, 221, 94, 25);
		frame.getContentPane().add(btnRevoke);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogOut.setBounds(471, 221, 94, 25);
		frame.getContentPane().add(btnLogOut);
	}
}
