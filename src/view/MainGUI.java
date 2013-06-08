package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import org.jdesktop.swingx.JXStatusBar;
import controller.MainGUIController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.awt.SystemColor;


public class MainGUI extends JFrame {
	private JDesktopPane desktopPane; 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MainGUIController guiController;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param gUIController 
	 * @throws PropertyVetoException 
	 */
	public MainGUI(MainGUIController gUIController) {
		this.guiController = gUIController;
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 511);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnEquipo = new JMenu("Equipo");
		menuBar.add(mnEquipo);
		
		JMenuItem mntmVerEquipo = new JMenuItem("Ver Equipo...");
		mntmVerEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoEquipo();
			}

			
		});
		mnEquipo.add(mntmVerEquipo);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		
		
		JXStatusBar status = new JXStatusBar();
		status.setBorder(null);
		status.setPreferredSize(getPreferredSize());
		
		contentPane.add(status, BorderLayout.SOUTH);	
		
	}
	
	
	private void DialogoEquipo() {
		
		this.guiController.DialogoEquipo();
		
	}


	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}
	
	
}
