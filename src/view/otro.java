package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class otro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					otro frame = new otro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public otro() {
		setBorder(null);
		setClosable(true);
		//setIcon(true);
		setIconifiable(true);
		setMaximizable(true);
		

	}

}
