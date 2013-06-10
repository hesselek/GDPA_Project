package view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import controller.MainGUIController;
import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import javax.swing.JCheckBox;

import model.equipo.Categoria_Equipo;
import model.equipo.Coin;
import model.equipo.ItemEquipo;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoItemEquipo extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	
	
	private JTextField textNombre;
	private JTextField textPrecio;
	private JComboBox comboGrupo;
	private JComboBox<Categoria_Equipo> comboCategoria;
	private JTextField textPeso;
	private MainGUIController mainGUIController;
	private JCheckBox PesoDespreciable;
	private JCheckBox PesoInfimo;
	private JComboBox<Coin> comboMoneda;

	public NuevoItemEquipo(MainGUIController mainGUIController) {
		super("Nuevo Equipo",true,true,true,true);
		setBounds(100, 100, 446, 277);
		this.mainGUIController = mainGUIController;
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		
		JLabel lblGrupo = new JLabel("Grupo:");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		
		JLabel lblPrecio = new JLabel("Precio:");
		
		comboGrupo = new JComboBox();
		
		comboCategoria = new JComboBox<Categoria_Equipo>();
		comboCategoria.setModel(new DefaultComboBoxModel<Categoria_Equipo>(Categoria_Equipo.values()));
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		
		JButton btnNewButton = new JButton("Nuevo Grupo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoGrupo();
			}

			
		});
		
		comboMoneda = new JComboBox<Coin>();
		comboMoneda.setModel(new DefaultComboBoxModel<Coin>(Coin.values()));
		
		
		
		JLabel lblPesoenKg = new JLabel("Peso (en kg):");
		
		textPeso = new JTextField();
		textPeso.setColumns(10);
		
		PesoInfimo = new JCheckBox("Peso Infimo");
		PesoInfimo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				anularPeso();
			}
		});
		
		PesoDespreciable = new JCheckBox("Peso Despreciable");
		PesoDespreciable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				anularPeso();
			}
		});
		
		JButton btnGuardarObjeto = new JButton("Guardar Objeto");
		btnGuardarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblGrupo)
								.addComponent(lblCategora)
								.addComponent(lblPrecio))
							.addGap(34)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(textPrecio, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboMoneda, 0, 77, Short.MAX_VALUE))
										.addComponent(comboCategoria, 0, 188, Short.MAX_VALUE)
										.addComponent(comboGrupo, 0, 188, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewButton))
								.addComponent(textNombre, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPesoenKg)
									.addGap(18)
									.addComponent(textPeso, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(PesoInfimo))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnGuardarObjeto)
									.addGap(30)
									.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(PesoDespreciable))))
					.addGap(214))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrupo)
						.addComponent(comboGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategora)
						.addComponent(comboCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio)
						.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboMoneda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesoenKg)
						.addComponent(textPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PesoInfimo)
						.addComponent(PesoDespreciable))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardarObjeto)
						.addComponent(btnNewButton_1)
						.addComponent(btnCancelar))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		setVisible(true);
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void guardar() {
		int peso=0,precioMin,precioMax;
		
		byte cat = (byte) (comboCategoria.getSelectedIndex() & (0xff));
		if(!PesoDespreciable.isSelected() && !PesoInfimo.isSelected())
			peso = Integer.parseInt(textPeso.getText());
		
		ItemEquipo item = new ItemEquipo(textNombre.getText()
										,cat	
										,peso
										,0
										,Integer.parseInt(textPrecio.getText())
										,null);
	
		System.out.println(item.toString());
		mainGUIController.addItem(item);
	}

	protected void salir() {
		this.setVisible(false);
	}

	protected void anularPeso() {
		if(!PesoDespreciable.isSelected() && !PesoInfimo.isSelected()){
			textPeso.setEnabled(true);
			PesoDespreciable.setEnabled(true);
			PesoInfimo.setEnabled(true);
		}
		if(PesoDespreciable.isSelected()){
			textPeso.setEnabled(false);
			PesoInfimo.setEnabled(false);
		}
		if(PesoInfimo.isSelected()){
			textPeso.setEnabled(false);
			PesoDespreciable.setEnabled(false);
		}
		
	}	
	private void nuevoGrupo() {
		// TODO los grupos...
		
	}
}


