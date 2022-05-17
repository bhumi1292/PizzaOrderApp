package de.bhumi.appUI;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import de.bhumi.backend.RegiDB;
import de.bhumi.middleTier.RegiService;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;

/*
 * Implements Action Listener for Register the user Data
 */

public class App implements ActionListener {

	private Image img = new ImageIcon(App.class.getResource("/resources/logo.jpg")).getImage().getScaledInstance(90, 90,
			Image.SCALE_SMOOTH);
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JTextField txtEmail;
	private JTextField txtLastName;
	private JLabel lbllogo;
	private JButton btnNewButton_3;
	private JRadioButton adminRdo;

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
		getFrame().setVisible(true);
		btnNewButton_3 = new JButton("Already a customer?SignIn");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setActionCommand("open");
		btnNewButton_3.setBounds(139, 450, 235, 21);
		getFrame().getContentPane().add(btnNewButton_3);

		adminRdo = new JRadioButton("Admin");
		adminRdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adminRdo.isSelected()) {
					getFrame().dispose();
					new AdminLogIn();

				}
			}
		});

		adminRdo.setBackground(new Color(255, 255, 255));
		adminRdo.setForeground(new Color(0, 0, 255));
		adminRdo.setBounds(139, 502, 103, 20);
		frame.getContentPane().add(adminRdo);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		getFrame().setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/resources/logo.jpg")));
		getFrame().setTitle("Wellcome To Shopyfi");
		getFrame().setBounds(new Rectangle(2, 2, 2, 2));
		getFrame().getContentPane().setBackground(new Color(255, 127, 80));
		getFrame().setBounds(100, 100, 564, 668);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("First Name")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("First Name");
				}
			}
		});
		txtUsername.setCaretColor(new Color(255, 255, 255));
		txtUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsername.setText("First Name");
		txtUsername.setToolTipText("");
		txtUsername.setBounds(139, 169, 105, 37);
		getFrame().getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		pwdPassword = new JPasswordField();
		// listener to focus on the user activity
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
		pwdPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pwdPassword.setEchoChar((char) 0);
		pwdPassword.setText("Password");
		pwdPassword.setToolTipText("Password must be 8 charactor,One uppercase,one lowercase, number");
		pwdPassword.setBounds(139, 289, 235, 37);
		getFrame().getContentPane().add(pwdPassword);

		JButton btnNewButton_2 = new JButton("SignUp");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				String firstname = txtUsername.getText();
				String lastname = txtLastName.getText();
				String email = txtEmail.getText();
				String password = pwdPassword.getText();

				RegiDB db = new RegiDB();
				RegiService servis = new RegiService(db);
				servis.writeUser(firstname, lastname, email, password);
				System.out.println(firstname + "" + lastname);
				getFrame().dispose();
				ShopCart shop = new ShopCart();

				shop.setVisible(true);

			}

		});

		btnNewButton_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(139, 361, 235, 37);

		txtEmail = new JTextField();
		// listener to focus on the user activity
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().equals("Email")) {
					txtEmail.setText("");
				} else {
					txtEmail.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().equals("")) {
					txtEmail.setText("Email");
				} else {
					txtEmail.selectAll();
				}
			}
		});
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setText("Email");
		txtEmail.setBounds(139, 227, 235, 37);
		getFrame().getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtLastName.getText().equals("Last Name")) {
					txtLastName.setText("");
				} else {
					txtLastName.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtLastName.getText().equals("")) {
					txtLastName.setText("Last Name");
				}
			}
		});
		txtLastName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLastName.setText("Last Name");
		txtLastName.setBounds(264, 169, 110, 37);
		getFrame().getContentPane().add(txtLastName);
		txtLastName.setColumns(10);

		lbllogo = new JLabel("");
		lbllogo.setBackground(new Color(250, 128, 114));
		lbllogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogo.setLabelFor(getFrame());
		lbllogo.setBounds(139, 72, 204, 74);
		lbllogo.setIcon(new ImageIcon(img));
		getFrame().getContentPane().add(lbllogo);

		getFrame().getContentPane().add(btnNewButton_2);
	}

//method for opening new JFrame.
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("open")) {
			getFrame().dispose();
			new signIn();
		}
	}

	// getter for JFrame
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
