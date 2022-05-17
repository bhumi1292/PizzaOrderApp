package de.bhumi.appUI;



import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

/**
 * This is the application window used for the authentication for the admin
 * where admin can log in with unique user name and password.
 *
 * 
 * @author bhumi
 *
 */
public class AdminLogIn {

	private JFrame frmAdminLogin;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	/**
	 * Create the application.
	 */
	public AdminLogIn() {
		initialize();
		frmAdminLogin.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setIconImage(
				Toolkit.getDefaultToolkit().getImage(AdminLogIn.class.getResource("/resources/logo.jpg")));
		frmAdminLogin.setFont(new Font("Dialog", Font.BOLD, 15));
		frmAdminLogin.setTitle("Admin LogIn");
		frmAdminLogin.getContentPane().setBackground(new Color(255, 127, 80));
		frmAdminLogin.setBounds(100, 100, 467, 340);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);

		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setText("Username");
		txtUsername.setBounds(158, 63, 96, 19);
		frmAdminLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JButton btnNewButton = new JButton("SignIn");
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if (txtUsername.getText().equals("admin") && pwdPassword.getText().equals("admin")) {
					JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
					AdminOrderData adminData = new AdminOrderData();
					adminData.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
				}

			}
		});
		btnNewButton.setBounds(158, 163, 96, 21);
		frmAdminLogin.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Wellcome admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(137, 21, 238, 25);
		frmAdminLogin.getContentPane().add(lblNewLabel);

		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				} else {
					pwdPassword.selectAll();
				}
			}

			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char) 0);
				}
			}
		});
		pwdPassword.setText("Password");
		pwdPassword.setBounds(158, 115, 96, 19);
		frmAdminLogin.getContentPane().add(pwdPassword);
	}

}
