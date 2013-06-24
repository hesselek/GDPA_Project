package view.equipo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import java.awt.Component;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

import utilities.Coin;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;

public class NuevoItemEquipo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private MainGUIController mainGUIController;
	private JTextField textNombre;
	private JComboBox comboGrupo;
	private JFormattedTextField textPrecio;
	private JFormattedTextField textPeso;
	private JTextField textGrupo;
	private JFormattedTextField textPrecioMin;
	private JFormattedTextField textPrecioMax;
	private JComboBox<Coin> comboMax;
	private JComboBox<Coin> comboMin;
	private JComboBox<Coin> comboMoneda;
	private JComboBox<Categoria_Equipo> comboCategoria;
	private JTextField textPrecioEspecial;
	private JPanel panelOpciones;
	private JButton btnMasDetalles;
	private DefaultComboBoxModel<Coin>moneda;
	private DefaultComboBoxModel<Categoria_Equipo>categoria;
	private JCheckBox chckbxPesoInfimo;
	private JCheckBox chckbxPesoDespreciable;


	public NuevoItemEquipo(final MainGUIController mainGUIController) {
		super("Nuevo Equipo",false,true,false,true);
		setSize(new Dimension(570, 722));
		
		this.mainGUIController = mainGUIController;
		moneda = new DefaultComboBoxModel<Coin>(Coin.values());
		categoria = new DefaultComboBoxModel<Categoria_Equipo>(Categoria_Equipo.values());
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 393, 531);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel container = new JPanel();
		container.setAlignmentX(Component.LEFT_ALIGNMENT);
		container.setAlignmentY(Component.TOP_ALIGNMENT);
		getContentPane().add(container);
		
		JPanel panel = new JPanel();
		
		panelOpciones = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(
			gl_container.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_container.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelOpciones, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_container.createSequentialGroup()
							.addGap(10)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_container.setVerticalGroup(
			gl_container.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelOpciones, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(4, Short.MAX_VALUE))
		);
		gl_container.setAutoCreateContainerGaps(true);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				mainGUIController.addItem();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainGUIController.limpiar();
			}
		});
		
		btnMasDetalles = new JButton("Mas Detalles");
		btnMasDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opciones();
			}

			
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnCancelar)
					.addGap(6)
					.addComponent(btnMasDetalles)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSalir)
						.addComponent(btnGuardar)
						.addComponent(btnCancelar)
						.addComponent(btnMasDetalles))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "  Precio  ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNuevoGrupo = new JLabel("Nuevo Grupo:");
		
		textGrupo = new JTextField();
		textGrupo.setColumns(10);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGUIController.nuevoGrupo();
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "  Peso  ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		chckbxPesoInfimo = new JCheckBox("Peso Infimo");
		chckbxPesoInfimo.setIcon(null);
		chckbxPesoInfimo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				checkPeso(arg0);
			}
		});
		
		chckbxPesoDespreciable = new JCheckBox("Peso Despreciable");
		chckbxPesoDespreciable.setIcon(null);
		chckbxPesoDespreciable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				checkPeso(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("Estos art\u00EDculos pesan poco individualmente. Diez de ellos pesanmedio kilo.");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Desarrollo JEE\\Workspace\\GDPA\\img\\icon-info.gif"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setToolTipText("Esos objetos no tienen peso apreciable y no deben ser tomados en cuenta para la carga a menos que sean llevados a centenares.");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Desarrollo JEE\\Workspace\\GDPA\\img\\icon-info.gif"));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxPesoInfimo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(chckbxPesoDespreciable)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(chckbxPesoDespreciable)
						.addComponent(lblNewLabel_3)
						.addComponent(chckbxPesoInfimo, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_4.linkSize(SwingConstants.VERTICAL, new Component[] {chckbxPesoInfimo, chckbxPesoDespreciable, lblNewLabel_2, lblNewLabel_3});
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_panelOpciones = new GroupLayout(panelOpciones);
		gl_panelOpciones.setHorizontalGroup(
			gl_panelOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOpciones.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelOpciones.createSequentialGroup()
									.addComponent(lblNuevoGrupo)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textGrupo, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
							.addGap(7))))
		);
		gl_panelOpciones.setVerticalGroup(
			gl_panelOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOpciones.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNuevoGrupo)
						.addComponent(textGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
					.addGap(20))
		);
		
		JLabel lblNewLabel = new JLabel("Rango:");
		
		textPrecioMin = new JFormattedTextField(new Integer(0));
		textPrecioMin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				limpiarImputText(e);
			}
		});
		textPrecioMin.setColumns(10);
		
		comboMin = new JComboBox<Coin>();
		comboMin.setModel(new DefaultComboBoxModel<Coin>(Coin.values()));
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		
		textPrecioMax = new JFormattedTextField(new Integer(0));
		textPrecioMax.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				limpiarImputText(e);
			}
		});
		textPrecioMax.setColumns(10);
		
		comboMax = new JComboBox<Coin>();
		comboMax.setModel(new DefaultComboBoxModel<Coin>(Coin.values()));
		
		JLabel lblPrecioEspecial = new JLabel("Precio Especial:");
		
		textPrecioEspecial = new JTextField();
		textPrecioEspecial.setColumns(10);
		
		JButton button = new JButton("A\u00F1adir");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblPrecioEspecial)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textPrecioEspecial)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(textPrecioMin, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboMin, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textPrecioMax, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboMax, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPrecioMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textPrecioMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPrecioEspecial)
					.addGap(8)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPrecioEspecial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(0, 9, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panelOpciones.setLayout(gl_panelOpciones);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		JLabel lblPrecio = new JLabel("Precio:");
		
		comboGrupo = new JComboBox();
		
		comboCategoria = new JComboBox<Categoria_Equipo>();
		comboCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGUIController.refrescarGrupos();
			}
		});
		comboCategoria.setModel(categoria);
		
		textPrecio = new JFormattedTextField(new Integer(0));
		textPrecio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				limpiarImputText(arg0);
			}
		});
		textPrecio.setColumns(10);
		
		JLabel lblPesoenKg = new JLabel("Peso (en Kg):");
		
		comboMoneda = new JComboBox<Coin>();
		comboMoneda.setModel(moneda);
		
		
		
		textPeso = new JFormattedTextField(new Float(0));
		textPeso.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				limpiarImputText(arg0);
			}
		});
		textPeso.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCategoria)
						.addComponent(lblPrecio)
						.addComponent(lblGrupo)
						.addComponent(lblNombre)
						.addComponent(lblPesoenKg))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboMoneda, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addComponent(comboCategoria, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboGrupo, 0, 196, Short.MAX_VALUE))
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrupo)
						.addComponent(comboGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategoria)
						.addComponent(comboCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio)
						.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboMoneda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesoenKg)
						.addComponent(textPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		container.setLayout(gl_container);
		panelOpciones.setVisible(false);
		
		pack();
		setVisible(true);
		try {
			setSelected(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	protected void limpiarImputText(FocusEvent arg0) {
		JFormattedTextField campo = (JFormattedTextField) arg0.getSource();
		campo.setText("");
		
	}

	protected void checkPeso(ItemEvent arg0) {
		if(arg0.getStateChange() == ItemEvent.SELECTED){
			if(chckbxPesoDespreciable == arg0.getSource())
				chckbxPesoInfimo.setSelected(false);
			
			if(chckbxPesoInfimo == arg0.getSource()){
				chckbxPesoDespreciable.setSelected(false);
			}
			
				
		textPeso.setText("");
		textPeso.setEnabled(false);
		}
	
		if(arg0.getStateChange() == ItemEvent.DESELECTED){
			textPeso.setEnabled(true);
		}
		
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JComboBox getComboGrupo() {
		return comboGrupo;
	}

	public void setComboGrupo(JComboBox comboGrupo) {
		this.comboGrupo = comboGrupo;
	}

	public JFormattedTextField getTextPrecio() {
		return textPrecio;
	}

	public void setTextPrecio(JFormattedTextField textPrecio) {
		this.textPrecio = textPrecio;
	}

	public JFormattedTextField getTextPeso() {
		return textPeso;
	}

	public void setTextPeso(JFormattedTextField textPeso) {
		this.textPeso = textPeso;
	}

	public JTextField getTextGrupo() {
		return textGrupo;
	}

	public void setTextGrupo(JTextField textGrupo) {
		this.textGrupo = textGrupo;
	}

	public JFormattedTextField getTextPrecioMin() {
		return textPrecioMin;
	}

	public void setTextPrecioMin(JFormattedTextField textPrecioMin) {
		this.textPrecioMin = textPrecioMin;
	}

	public JFormattedTextField getTextPrecioMax() {
		return textPrecioMax;
	}

	public void setTextPrecioMax(JFormattedTextField textPrecioMax) {
		this.textPrecioMax = textPrecioMax;
	}

	public JComboBox<Coin> getComboMax() {
		return comboMax;
	}

	public void setComboMax(JComboBox<Coin> comboMax) {
		this.comboMax = comboMax;
	}

	public JComboBox<Coin> getComboMin() {
		return comboMin;
	}

	public void setComboMin(JComboBox<Coin> comboMin) {
		this.comboMin = comboMin;
	}

	public JComboBox<Coin> getComboMoneda() {
		return comboMoneda;
	}

	public void setComboMoneda(JComboBox<Coin> comboMoneda) {
		this.comboMoneda = comboMoneda;
	}

	public JComboBox<Categoria_Equipo> getComboCategoria() {
		return comboCategoria;
	}

	public void setComboCategoria(JComboBox<Categoria_Equipo> comboCategoria) {
		this.comboCategoria = comboCategoria;
	}

	public JTextField getTextPrecioEspecial() {
		return textPrecioEspecial;
	}

	public void setTextPrecioEspecial(JTextField textPrecioEspecial) {
		this.textPrecioEspecial = textPrecioEspecial;
	}

	public JCheckBox getChckbxPesoInfimo() {
		return chckbxPesoInfimo;
	}

	public void setChckbxPesoInfimo(JCheckBox chckbxPesoInfimo) {
		this.chckbxPesoInfimo = chckbxPesoInfimo;
	}

	public JCheckBox getChckbxPesoDespreciable() {
		return chckbxPesoDespreciable;
	}

	public void setChckbxPesoDespreciable(JCheckBox chckbxPesoDespreciable) {
		this.chckbxPesoDespreciable = chckbxPesoDespreciable;
	}

	protected void salir() {
		this.setVisible(false);
	}

	private void opciones() {
		if(!panelOpciones.isVisible()){
			panelOpciones.setVisible(true);
			btnMasDetalles.setText("Menos Detalles");
			this.pack();
		}else{
			panelOpciones.setVisible(false);
			btnMasDetalles.setText("Mas Detalles");
			this.pack();
		}
		
	}
}


