package view.equipo;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.equipo.ItemEquipo;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.MainGUIController;
import utilities.Utilidades;
import java.awt.Dimension;


public class PaneRopa extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Utilidades util;
	private MainGUIController mainGUI;

	
	public PaneRopa(List<ItemEquipo> datosModel, MainGUIController mainGUIController) {
		util = new Utilidades();
		this.mainGUI = mainGUIController;

		String columna[]=new String[]{"Objeto","Coste",""};
		DefaultTableModel modelo = new  DefaultTableModel(null,columna);
		List<ItemEquipo> objetos = datosModel;
		Object[] dato = new Object[3];
		
		for(int i=0; i<objetos.size();i++){
			if(objetos.get(i).getEquipo()!=null){
				dato[0] = "   "+objetos.get(i).getNombre();
			}else{
				dato[0] = objetos.get(i).getNombre();
			}
			if(objetos.get(i).getPrecioMax()==0)
				dato[1] = " ";
			else
				dato[1] = util.conversorDb(objetos.get(i).getPrecioMax());
			
			if(objetos.get(i).isEspecial())
				dato[1] = mainGUI.getSpecialPrice(objetos.get(i).getNombre());
			
			if(objetos.get(i).getPrecioMin() != 0)
					dato[1] = util.conversorDb(objetos.get(i).getPrecioMin())+ " / "+util.conversorDb(objetos.get(i).getPrecioMax());
				
			
			modelo.addRow(dato);
		}
		JLabel lblNewLabel = new JLabel("Ropa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(267, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setRowMargin(3);
		
		table.setColumnSelectionAllowed(true);
		table.setShowVerticalLines(false);
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		table.getColumn("Coste").setCellRenderer( rightRenderer );
		
		table.setIntercellSpacing(new Dimension(10, 3));
		setLayout(groupLayout);

	}


	

}
