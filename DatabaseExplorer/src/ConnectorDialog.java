import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectorDialog extends JDialog {

	Properties dbProperties;
	boolean isCanceled = false;
	
	JTextField host = new JTextField();
	JLabel hostLabel = new JLabel("Host");
	
	JTextField port = new JTextField();
	JLabel portLabel = new JLabel("Port");
	
	JTextField dbName = new JTextField();
	JLabel dbNameLabel = new JLabel("DB Name");
	
	JTextField user = new JTextField();
	JLabel userLabel = new JLabel("User");
	
	JTextField password = new JTextField();
	JLabel passwordLabel = new JLabel("Passwrod");
	
	JButton submitBTN = new JButton("submit");
	JButton cancelBTN = new JButton("cancel");
	
	
	
	
	public ConnectorDialog(JFrame owner, String title, Properties props) {
		super(owner, title, true);
		
		setSize(400, 400);
		
		dbProperties = props;
		
		submitBTN.addActionListener(this::performOperation);
		cancelBTN.addActionListener(this::performOperation);
		
		JPanel dataPanel = new JPanel();
		
		dataPanel.setLayout(new GridLayout(5, 2));
		
		dataPanel.add(hostLabel);
		dataPanel.add(host);
		
		dataPanel.add(portLabel);
		dataPanel.add(port);
		
		dataPanel.add(dbNameLabel);
		dataPanel.add(dbName);
		
		dataPanel.add(userLabel);
		dataPanel.add(user);
		
		dataPanel.add(passwordLabel);
		dataPanel.add(password);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(submitBTN);
		buttonPanel.add(cancelBTN);
		
		add(dataPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		
		
	}
	

	private void performOperation(ActionEvent e) {
		if(e.getSource() == cancelBTN) 
		{
			this.isCanceled = true;
		}
		
		dispose();
	}


	public Properties getProps() {
		dbProperties.setProperty("db_name", dbName.getText());
		dbProperties.setProperty("db_host", host.getText());
		dbProperties.setProperty("db_port", port.getText());
		dbProperties.setProperty("db_user", user.getText());
		
		return dbProperties;
		
	}
	
}
