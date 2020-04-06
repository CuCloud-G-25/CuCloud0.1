import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.List;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.JTextArea;
public class UserHome {

	private JFrame frame;
	private JTextField txtPartitionName;
	private JTextField txtSize;
	private JTextArea txtGetPartition;
	String line = "";
	String str,str1;
	String text;
	
	public void GetPartition() {
			
	        try{
	               
	                String[] password = {"sudo","-S", "fdisk","-l"};
	              
	                Process proc2 = Runtime.getRuntime().exec(password);
	                OutputStream os = proc2.getOutputStream();
	                os.write("Sushant@123\n".getBytes());
	       
	                BufferedReader reader2 =  
	               new BufferedReader(new InputStreamReader(proc2.getInputStream()));
	                              
	                while((line = reader2.readLine()) != null) 
	                {
	                	System.out.println(line + "\n");
	                //text = line;
	                	//txtGetPartition.setText(line);
	                }
	                proc2.waitFor(); 
	            }
	catch(Exception e)
	{
	        System.out.println(e);   
	}
			
	} 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHome window = new UserHome();
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
	public UserHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserHome = new JLabel("User Home");
		lblUserHome.setBounds(296, 12, 88, 15);
		frame.getContentPane().add(lblUserHome);
		
		JButton btnNewButton = new JButton("Get Partition");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get partition program
				UserHome userhome = new UserHome();
				userhome.GetPartition();
				//txtGetPartition.setText(line.getText());
				//txtGetPartition.setText(text);
				
			}
		});
		btnNewButton.setBounds(92, 39, 122, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblDriveName = new JLabel("Partition Name");
		lblDriveName.setBounds(333, 94, 103, 15);
		frame.getContentPane().add(lblDriveName);
		
		txtPartitionName = new JTextField();
		txtPartitionName.setBounds(479, 92, 124, 19);
		frame.getContentPane().add(txtPartitionName);
		txtPartitionName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Size (GB)");
		lblNewLabel.setBounds(342, 173, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
		txtSize = new JTextField();
		txtSize.setToolTipText("Enter Size in MB");
		txtSize.setBounds(479, 171, 124, 19);
		frame.getContentPane().add(txtSize);
		txtSize.setColumns(10);
		
		JButton btnCreatePartition = new JButton("Create Partition");
		btnCreatePartition.setBounds(319, 256, 143, 25);
		frame.getContentPane().add(btnCreatePartition);
		
		JButton btnShare = new JButton("Share");
		btnShare.setBounds(489, 256, 114, 25);
		frame.getContentPane().add(btnShare);
		
		txtGetPartition = new JTextArea();
		txtGetPartition.setEditable(false);
		txtGetPartition.setBounds(12, 76, 275, 335);
		frame.getContentPane().add(txtGetPartition);
	}
}
