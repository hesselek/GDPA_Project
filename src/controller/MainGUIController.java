package controller;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.PersistenceUnit;

import view.MainGUI;

public class MainGUIController {
	
	private MainGUI frame;
	private JInternalFrame equipo;

	public MainGUIController(PersistenceUnit persistence) {
		//this.frame = frame;
	}



	public void launch() {
		 try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				frame = new MainGUI(this);
				frame.setVisible(true);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		
	}



	public void DialogoEquipo() {
		if(equipo == null){
			equipo = new JInternalFrame("Equipo");
			equipo.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
			equipo.setResizable(true);
			equipo.setMaximizable(true);
			equipo.setIconifiable(true);
			equipo.setClosable(true);
			equipo.setBounds(90, 107, 385, 186);
			frame.getDesktopPane().add(equipo);
		
			JPanel panel = new JPanel();
			equipo.getContentPane().add(panel, BorderLayout.CENTER);
			equipo.setVisible(true);
		}
		else{
			try {
				equipo.setVisible(true);
				equipo.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
		
	}

}
