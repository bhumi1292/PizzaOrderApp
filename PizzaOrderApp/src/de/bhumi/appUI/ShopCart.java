package de.bhumi.appUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import de.bhumi.backend.ShopDB;
import de.bhumi.middleTier.CartService;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

/**
 * Class extends Frame for user interface.
 * methods to fetch data as per user selection.
 * Listeners to insert and show the data.
 * 
 * @author bhumi
 *
 */
@SuppressWarnings("serial")
public class ShopCart extends JFrame {
	@SuppressWarnings("rawtypes")
	private JComboBox cboFlavor;
	private JRadioButton rdoMedium;
	private JRadioButton rdoLarge;
	private JCheckBox chkExtraCheese;
	private JCheckBox chkExtraMeat;
	private JCheckBox chkBlackOlives;
	private JCheckBox chkMushroom;
	private JCheckBox chkOnion;
	private JCheckBox chkSausage;
	private JRadioButton rdoDineIn;
	private JRadioButton rdoTakeOut;
	private JRadioButton rdoDelivery;
	private JButton btnBillOut;
	private JButton btnOrderAgain;
	private String[] flavor = { "Pepproni", "BBQ Chicken", "Hawaiian", "Vegetarian", "Bacon and Cheese" };
	private JLabel lblPriceSm;
	private JLabel lblPriceMed;
	private JLabel lblPriceLarge;
	private double addOnPrice = 0.00;
	private JTextArea ShowDetailtxt;
	private JRadioButton rdoSmall;
	private JLabel lblQuentity;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnQnt;
	private JButton btnQnty;
	private int qnt = 1;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public ShopCart() {
		// window Listener to call method which Load Flavor
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				loadFlavors();
			}

		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopCart.class.getResource("/resources/logo.jpg")));
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("Pizza Shopping Cart");
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel contentPanel = new JPanel();
		contentPanel.setForeground(new Color(0, 0, 0));
		contentPanel.setBackground(new Color(255, 127, 80));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Food Flavore:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 20, 232, 19);
		contentPanel.add(lblNewLabel);

		cboFlavor = new JComboBox();
		// Action Listener to call method which fetch Price
		cboFlavor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPrice();
			}
		});
		cboFlavor.setBounds(20, 59, 232, 21);
		contentPanel.add(cboFlavor);

		JLabel sad = new JLabel("Size and Price:");
		sad.setFont(new Font("Dialog", Font.PLAIN, 13));
		sad.setBounds(10, 94, 232, 19);
		contentPanel.add(sad);

		rdoSmall = new JRadioButton("Small");
		buttonGroup.add(rdoSmall);
		rdoSmall.setBackground(new Color(255, 160, 122));
		rdoSmall.setBounds(20, 132, 153, 21);
		contentPanel.add(rdoSmall);

		rdoMedium = new JRadioButton("Medium");
		buttonGroup.add(rdoMedium);
		rdoMedium.setBackground(new Color(255, 160, 122));
		rdoMedium.setName("rdoMedium");
		rdoMedium.setBounds(20, 170, 153, 21);
		contentPanel.add(rdoMedium);

		rdoLarge = new JRadioButton("Large");
		buttonGroup.add(rdoLarge);
		rdoLarge.setBackground(new Color(255, 160, 122));
		rdoLarge.setBounds(20, 210, 153, 21);
		contentPanel.add(rdoLarge);

		JLabel lblAddOns = new JLabel("Add Ons:");
		lblAddOns.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAddOns.setBounds(10, 252, 232, 19);
		contentPanel.add(lblAddOns);

		chkExtraCheese = new JCheckBox("Extra Cheese");
		chkExtraCheese.setName("");
		chkExtraCheese.setBackground(new Color(255, 160, 122));
		chkExtraCheese.setBounds(20, 289, 114, 21);
		contentPanel.add(chkExtraCheese);

		chkExtraMeat = new JCheckBox("Extra Meat");
		chkExtraMeat.setName("");
		chkExtraMeat.setBackground(new Color(255, 160, 122));
		chkExtraMeat.setBounds(20, 327, 114, 21);
		contentPanel.add(chkExtraMeat);

		chkMushroom = new JCheckBox("Mushroom");
		chkMushroom.setName("");
		chkMushroom.setBackground(new Color(255, 160, 122));
		chkMushroom.setBounds(20, 365, 114, 21);
		contentPanel.add(chkMushroom);

		chkBlackOlives = new JCheckBox("Black Olives");
		chkBlackOlives.setName("");
		chkBlackOlives.setBackground(new Color(255, 160, 122));
		chkBlackOlives.setBounds(159, 289, 103, 21);
		contentPanel.add(chkBlackOlives);

		chkOnion = new JCheckBox("Onions");
		chkOnion.setName("");
		chkOnion.setBackground(new Color(255, 160, 122));
		chkOnion.setBounds(159, 327, 103, 21);
		contentPanel.add(chkOnion);

		chkSausage = new JCheckBox("Sausage");
		chkSausage.setName("");
		chkSausage.setBackground(new Color(255, 160, 122));
		chkSausage.setBounds(159, 365, 103, 21);
		contentPanel.add(chkSausage);

		JLabel lblChoose = new JLabel("Choose");
		lblChoose.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblChoose.setBounds(10, 411, 232, 13);
		contentPanel.add(lblChoose);

		rdoDineIn = new JRadioButton("Dine In");
		buttonGroup_1.add(rdoDineIn);
		rdoDineIn.setName("Choosegroup");
		rdoDineIn.setBackground(new Color(255, 160, 122));
		rdoDineIn.setBounds(20, 441, 153, 21);

		contentPanel.add(rdoDineIn);

		rdoTakeOut = new JRadioButton("Take Out");
		buttonGroup_1.add(rdoTakeOut);
		rdoTakeOut.setName("Choosegroup");
		rdoTakeOut.setBackground(new Color(255, 160, 122));
		rdoTakeOut.setBounds(20, 483, 153, 21);

		contentPanel.add(rdoTakeOut);

		rdoDelivery = new JRadioButton("For Delivery");
		buttonGroup_1.add(rdoDelivery);
		rdoDelivery.setName("Choosegroup");
		rdoDelivery.setBackground(new Color(255, 160, 122));
		rdoDelivery.setBounds(20, 524, 153, 21);

		contentPanel.add(rdoDelivery);

		JLabel sss = new JLabel("Quantity:");
		sss.setFont(new Font("Dialog", Font.PLAIN, 13));
		sss.setBounds(20, 551, 222, 19);
		contentPanel.add(sss);

		btnQnt = new JButton("-");
		btnQnt.setBackground(new Color(255, 160, 122));
		btnQnt.setForeground(new Color(0, 0, 0));
		btnQnt.setFont(new Font("Dialog", Font.BOLD, 20));
		btnQnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qnt--;
				lblQuentity.setText(String.valueOf(qnt));

			}
		});
		btnQnt.setBounds(40, 580, 68, 29);
		contentPanel.add(btnQnt);

		btnQnty = new JButton("+");
		btnQnty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qnt++;
				lblQuentity.setText(String.valueOf(qnt));
			}
		});
		btnQnty.setBackground(new Color(255, 160, 122));
		btnQnty.setForeground(new Color(0, 0, 0));
		btnQnty.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQnty.setBounds(157, 580, 68, 29);
		contentPanel.add(btnQnty);

		btnBillOut = new JButton("Bill Out");

		// Action Listener insert the data into the database by the reference of shopeDB
		// class.
		btnBillOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOrderDetails();
				String foodFlavor = String.valueOf(cboFlavor.getSelectedItem());
				String size = sizeofpizza();
				double price = priceOfPizza();
				String addOns = addOnPrice();
				String choose = serviceMethod();
				int quantity = quentity();
				double total = subtotal() - addOnPrice;

				ShopDB db = new ShopDB();
				CartService service = new CartService(db);
				service.writedata(foodFlavor, size, price, addOns, choose, quantity, total);

			}
		});
		btnBillOut.setBounds(88, 623, 103, 21);
		contentPanel.add(btnBillOut);

		lblQuentity = new JLabel("1");
		lblQuentity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuentity.setBounds(128, 584, 45, 13);
		contentPanel.add(lblQuentity);

		btnOrderAgain = new JButton("Order Again");
		// Button Action Listener to call the method which shows selected data
		btnOrderAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ShowDetailtxt.setText(null);

			}
		});
		btnOrderAgain.setBounds(88, 660, 103, 21);
		contentPanel.add(btnOrderAgain);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(ShopCart.class.getResource("/resources/th.jpg")));
		lblNewLabel_6.setBounds(302, 10, 164, 123);
		contentPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("New label");
		lblNewLabel_6_1.setIcon(new ImageIcon(ShopCart.class.getResource("/resources/pizza1.jpg")));
		lblNewLabel_6_1.setBounds(476, 10, 153, 123);
		contentPanel.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("New label");
		lblNewLabel_6_2.setIcon(new ImageIcon(ShopCart.class.getResource("/resources/th (3).jpg")));
		lblNewLabel_6_2.setBounds(639, 10, 149, 123);
		contentPanel.add(lblNewLabel_6_2);

		JLabel lblOrderDetails = new JLabel("Order Details:");
		lblOrderDetails.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblOrderDetails.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblOrderDetails.setBounds(302, 136, 93, 13);
		contentPanel.add(lblOrderDetails);

		ShowDetailtxt = new JTextArea();
		ShowDetailtxt.setBounds(302, 169, 486, 454);
		contentPanel.add(ShowDetailtxt);

		lblPriceSm = new JLabel("");
		lblPriceSm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceSm.setBounds(179, 132, 73, 21);
		contentPanel.add(lblPriceSm);

		lblPriceMed = new JLabel("");
		lblPriceMed.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceMed.setBounds(179, 170, 73, 21);
		contentPanel.add(lblPriceMed);

		lblPriceLarge = new JLabel("");
		lblPriceLarge.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceLarge.setBounds(179, 210, 73, 21);
		contentPanel.add(lblPriceLarge);

		setBounds(150, 150, 812, 723);
	}
	// add items in the combobox

	@SuppressWarnings("unchecked")
	private void loadFlavors() {
		for (String flavors : flavor) {
			cboFlavor.addItem(flavors);
		}
	}

	// Method create to set price into the Label
	private void showPrice() {
		if (cboFlavor.getSelectedIndex() == 0) {
			lblPriceSm.setText("10.00");
			lblPriceMed.setText("12.00");
			lblPriceLarge.setText("14.00");
		} else if (cboFlavor.getSelectedIndex() == 1) {
			lblPriceSm.setText("13.00");
			lblPriceMed.setText("15.00");
			lblPriceLarge.setText("17.00");
		} else if (cboFlavor.getSelectedIndex() == 2) {
			lblPriceSm.setText("9.00");
			lblPriceMed.setText("11.00");
			lblPriceLarge.setText("15.00");
		} else if (cboFlavor.getSelectedIndex() == 3) {
			lblPriceSm.setText("14.00");
			lblPriceMed.setText("15.00");
			lblPriceLarge.setText("17.00");
		} else {
			lblPriceSm.setText("12.00");
			lblPriceMed.setText("15.00");
			lblPriceLarge.setText("17.00");
		}
	}

	// Method create for return the string for addons
	private String addOnPrice() {
		String addOns = "";
		if (chkExtraCheese.isSelected()) {
			addOnPrice += 1.00;
			addOns = addOns + "\n\t" + chkExtraCheese.getText() + "\t\t" + "1.00";
		}
		if (chkExtraMeat.isSelected()) {
			addOnPrice += 0.50;
			addOns = addOns + "\n\t" + chkExtraMeat.getText() + "\t\t" + "0.50";
		}
		if (chkMushroom.isSelected()) {
			addOnPrice += 1.00;
			addOns = addOns + "\n\t" + chkMushroom.getText() + "\t\t" + "1.00";
		}
		if (chkBlackOlives.isSelected()) {
			addOnPrice += 2.00;
			addOns = addOns + "\n\t" + chkBlackOlives.getText() + "\t\t" + "2.00";
		}
		if (chkOnion.isSelected()) {
			addOnPrice += 3.00;
			addOns = addOns + "\n\t" + chkOnion.getText() + "\t\t" + "3.00";
		}
		if (chkSausage.isSelected()) {
			addOnPrice += 2.00;
			addOns = addOns + "\n\t" + chkSausage.getText() + "\t\t" + "2.00";
		}

		return addOns;
	}

	// Method creates for fetching size of Pizza
	private String sizeofpizza() {
		String size = "";
		if (rdoSmall.isSelected())
			size = rdoSmall.getText();
		else if (rdoMedium.isSelected())
			size = rdoMedium.getText();
		else
			size = rdoLarge.getText();

		return size;
	}

	// Method creates for fetching Price of pizza
	private double priceOfPizza() {
		double pizzaPrice = 0;
		if (rdoSmall.isSelected())
			pizzaPrice = Double.parseDouble(lblPriceSm.getText());
		else if (rdoMedium.isSelected())
			pizzaPrice = Double.parseDouble(lblPriceMed.getText());
		else
			pizzaPrice = Double.parseDouble(lblPriceLarge.getText());
		return pizzaPrice;
	}

	// Method create to returns string as per selected service
	private String serviceMethod() {
		String service = "";
		if (rdoDineIn.isSelected()) {
			service = rdoDineIn.getText();

		} else if (rdoTakeOut.isSelected()) {
			service = rdoTakeOut.getText();
		} else
			service = rdoDelivery.getText() + "2.00";
		return service;
	}

	// Method create to returns fees of the service
	private double serviceFees() {
		double serviceFee = 0.00;
		if (rdoDineIn.isSelected())
			serviceFee = 0.00;
		else if (rdoTakeOut.isSelected())
			serviceFee = 0.00;
		else
			serviceFee = 2.00;
		return serviceFee;
	}

	// Method create to returns total price that is payable
	private double subtotal() {
		double pricetotal = 0;
		System.out.println(addOnPrice);
		pricetotal = ((priceOfPizza() + addOnPrice) * quentity()) + serviceFees();
		return pricetotal;
	}

	private int quentity() {
		int qnty = Integer.parseInt(lblQuentity.getText());
		return qnty;
	}

	// Method create to show the Order details
	private void showOrderDetails() {
		ShowDetailtxt.setText("\nFLAVOR: \t" + cboFlavor.getSelectedItem() + "\n\nSIZE: \t" + sizeofpizza()
				+ "\n\nPRICE: \t\t\t" + priceOfPizza() + "\n\n Add Ons : \t" + addOnPrice() + "\n\n Choose : \t"
				+ serviceMethod() + "\n\n Quentity: \t\t\t" + "X" + quentity()
				+ "\n\n********************************************************************"
				+ "\n\n Service Fees : \t\t\t" + serviceFees() + "\n\n Total Amount : \t\t\t" + subtotal());
	}
}
