package view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;

public class NuevoItemEquipo extends JInternalFrame {
	private MainGUIController mainGUIController;
	private JTextField textNombre;
	private JComboBox comboGrupo;
	private JTextField textPrecio;
	private JTextField textPeso;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboMax;
	private JComboBox comboMin;
	private JComboBox comboMoneda;
	private JComboBox comboCategoria;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public NuevoItemEquipo(MainGUIController mainGUIController) {
		super("Nuevo Equipo",true,true,true,true);
		this.mainGUIController = mainGUIController;
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 404, 542);
		
		JPanel container = new JPanel();
		getContentPane().add(container, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(
			gl_container.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container.createSequentialGroup()
					.addGroup(gl_container.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 385, Short.MAX_VALUE))
						.addGroup(gl_container.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_container.createSequentialGroup()
								.addContainerGap()
								.addComponent(separator))
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_container.setVerticalGroup(
			gl_container.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JButton btnGuardar = new JButton("Guardar");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnMasDetalles = new JButton("Mas Detalles");
		
		JButton btnSalir = new JButton("Salir");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMasDetalles, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnCancelar)
						.addComponent(btnMasDetalles)
						.addComponent(btnSalir))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "  Precio  ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNuevoGrupo = new JLabel("Nuevo Grupo:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		
		JSeparator separator_1 = new JSeparator();
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "  Peso  ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JCheckBox chckbxPesoInfimo = new JCheckBox("Peso Infimo");
		buttonGroup.add(chckbxPesoInfimo);
		
		JCheckBox chckbxPesoDespreciable = new JCheckBox("Peso Despreciable");
		buttonGroup.add(chckbxPesoDespreciable);
		
		JCheckBox chckbxSinPeso = new JCheckBox("Sin Peso");
		buttonGroup.add(chckbxSinPeso);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxPesoInfimo)
					.addGap(18)
					.addComponent(chckbxPesoDespreciable)
					.addGap(18)
					.addComponent(chckbxSinPeso)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxPesoInfimo)
						.addComponent(chckbxPesoDespreciable)
						.addComponent(chckbxSinPeso))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 335, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNuevoGrupo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addGap(101))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNuevoGrupo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Rango:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		comboMin = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		comboMax = new JComboBox();
		
		JLabel lblPrecioEspecial = new JLabel("Precio Especial:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
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
								.addComponent(textField_3)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboMin, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPrecioEspecial)
					.addGap(8)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(0, 9, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		JLabel lblPrecio = new JLabel("Precio:");
		
		comboGrupo = new JComboBox();
		
		comboCategoria = new JComboBox();
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		
		JLabel lblPesoenKg = new JLabel("Peso (en Kg):");
		
		comboMoneda = new JComboBox();
		
		textPeso = new JTextField();
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
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboMoneda, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addComponent(comboCategoria, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboGrupo, Alignment.LEADING, 0, 196, Short.MAX_VALUE)))
					.addContainerGap(39, Short.MAX_VALUE))
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
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		container.setLayout(gl_container);
		setVisible(true);
	
	}
}


