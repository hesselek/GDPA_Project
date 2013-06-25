package view.equipo;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JToggleButton;

import controller.MainGUIController;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;




public class Equipo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;


	/**
	 * Launch the application.
	 * @param mainGUIController 
	 */
	MainGUIController mainGUIController;
	private JPanel contenedor;
	
	public Equipo(MainGUIController mainGUIController) {
		super("Equipo",true,true,true,true);
		this.mainGUIController = mainGUIController;
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	

			setBounds(100, 100, 629, 429);
			getContentPane().setLayout(new BorderLayout(0, 0));
			
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			
			JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
			
			JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("New toggle button");
			
			JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("New toggle button");
			
			JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Nuevo Objeto");
			tglbtnNewToggleButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nuevoItem();
				}

				
			});
			
			JScrollPane scrollPane = new JScrollPane();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(scrollPane, Alignment.LEADING)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(tglbtnNewToggleButton)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tglbtnNewToggleButton_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tglbtnNewToggleButton_2)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tglbtnNewToggleButton_3)
						.addContainerGap(123, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(tglbtnNewToggleButton)
							.addComponent(tglbtnNewToggleButton_1)
							.addComponent(tglbtnNewToggleButton_2)
							.addComponent(tglbtnNewToggleButton_3))
						.addGap(8)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(124, Short.MAX_VALUE))
			);
			
			contenedor = new JPanel();
			scrollPane.setViewportView(contenedor);
			contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
			panel.setLayout(gl_panel);
			setVisible(true);
	}
	private void nuevoItem() {
		mainGUIController.nuevoItem();
		
	}
	public JPanel getContenedor() {
		return contenedor;
	}
	public void setContenedor(JPanel contenedor) {
		this.contenedor = contenedor;
	}
	
}
