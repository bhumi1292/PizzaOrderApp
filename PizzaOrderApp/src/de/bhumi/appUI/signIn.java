package de.bhumi.appUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import de.bhumi.backend.RegiDB;
import de.bhumi.middleTier.RegiService;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

/**
 * Class demonstrate authorized user by comparing the data from the datase.
 * @author bhumi
 *
 */
public class signIn implements ActionListener {

	private JFrame frmSignin;
	private JTextField txtUsename;

	private JPasswordField pwdPassword;
	private JButton RegiBtn;

	/**
	 * Create the application.
	 */
	public signIn() {
		initialize();
		RegiBtn = new JButton("New User?Register");
		RegiBtn.setForeground(new Color(0, 0, 128));
		RegiBtn.setBounds(144, 209, 144, 21);

		RegiBtn.setActionCommand("open");
		RegiBtn.addActionListener(this);
		frmSignin.getContentPane().add(RegiBtn);
		frmSignin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignin = new JFrame();
		frmSignin.setTitle("SignIn");
		frmSignin.getContentPane().setBackground(new Color(250, 128, 114));
		frmSignin.setBounds(100, 100, 450, 300);
		frmSignin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignin.getContentPane().setLayout(null);
		frmSignin.setVisible(true);

		txtUsename = new JTextField();
		txtUsename.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsename.getText().equals("UserName")) {
					txtUsename.setText("");

				} else {
					txtUsename.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsename.getText().equals("")) {
					txtUsename.setText("UserName");
				}
			}
		});
		txtUsename.setText("UserName");
		txtUsename.setBounds(144, 61, 144, 26);
		frmSignin.getContentPane().add(txtUsename);
		txtUsename.setColumns(10);

		JButton btnNewButton = new JButton("SignIn");
		btnNewButton.setBackground(new Color(220, 20, 60));
		/**
		 * Action Listener create to match the data of user and database. if true then
		 * open new JFrame if false then shows message
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String firstname = txtUsename.getText();
				@SuppressWarnings("deprecation")
				String password = pwdPassword.getText();

				RegiDB db = new RegiDB();
				RegiService service = new RegiService(db);
				boolean success = service.istAlreadyUser(firstname, password);

				if (success) {
					frmSignin.dispose();

					ShopCart shop = new ShopCart();
					shop.setTitle("Wellcome " + firstname);
					shop.setVisible(true);
					JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
				}

			}
		});
		btnNewButton.setBounds(144, 157, 144, 26);
		frmSignin.getContentPane().add(btnNewButton);

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
					pwdPassword.setText("password");
					pwdPassword.setEchoChar((char) 0);
				}
			}
		});
		pwdPassword.setText("Password");
		pwdPassword.setBounds(144, 110, 144, 26);
		frmSignin.getContentPane().add(pwdPassword);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("open")) {
			frmSignin.dispose();
			new App();
		}

	}

	public JFrame getFrame() {
		return frmSignin;
	}

}
