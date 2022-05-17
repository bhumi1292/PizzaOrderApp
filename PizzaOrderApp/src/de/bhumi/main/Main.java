package de.bhumi.main;

import java.awt.EventQueue;
import de.bhumi.appUI.signIn;

/*
 *class creates to run the main method.
 */
public class Main {

	public static void main(String[] args) {

		/**
		 * Launch the application.
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signIn window = new signIn();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
