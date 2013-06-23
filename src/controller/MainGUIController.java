package controller;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.PersistenceUnit;
import model.equipo.Equipo_Model;
import model.equipo.ItemEquipo;
import utilities.Coin;
import view.Equipo;
import view.MainGUI;
import view.NuevoItemEquipo;


public class MainGUIController {
	
	private MainGUI frame;
	private Equipo equipo;
	private NuevoItemEquipo nuevoItemEquipo;
	private Equipo_Model modelEquipo;
	private Object[] grupos;
	private ItemEquipo item;
	

	public MainGUIController(PersistenceUnit persistence) {
		grupos = new Object[9];
		modelEquipo = new Equipo_Model(persistence);
		modelEquipo.cargarGrupos(grupos);
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
			equipo = new Equipo(this);
			frame.getDesktopPane().add(equipo);
	
		}else{
			equipo.setVisible(true);
	
		}	
		
	}



	public void nuevoItem() {
		if(nuevoItemEquipo == null){
			nuevoItemEquipo = new NuevoItemEquipo(this);
			frame.getDesktopPane().add(nuevoItemEquipo);
			refrescarGrupos();
			
			
		}else{		
				nuevoItemEquipo.setVisible(true);
		}
		
	}



	public void addItem() {
		//TODO: Cambiar un poquito las cosas para que el peso se acepte en kilos o en libras
		item = null;
		item = new ItemEquipo(nuevoItemEquipo.getTextNombre().getText());
		item.setCategoria((byte)nuevoItemEquipo.getComboCategoria().getSelectedIndex());
		if(nuevoItemEquipo.getComboGrupo().getSelectedIndex() != -1)
			item.setEquipo(new ItemEquipo(nuevoItemEquipo.getComboGrupo().getSelectedItem().toString()));
		if(nuevoItemEquipo.getTextPeso().isEnabled()){
				item.setPeso((float)(nuevoItemEquipo.getTextPeso()).getValue());
		}else{
			if(nuevoItemEquipo.getChckbxPesoDespreciable().isSelected())
				item.setPeso(-1F);
			if(nuevoItemEquipo.getChckbxPesoInfimo().isSelected())
				item.setPeso(-2F);
		}
		
		if((int)nuevoItemEquipo.getTextPrecioMin().getValue() != 0){
				item.setPrecioMin(
						(int)nuevoItemEquipo.getTextPrecioMin().getValue()
						*
						((Coin)nuevoItemEquipo.getComboMin().getSelectedItem()).getValue()
						);
				item.setPrecioMax(
						(int)nuevoItemEquipo.getTextPrecioMax().getValue()
						*
						((Coin)nuevoItemEquipo.getComboMax().getSelectedItem()).getValue()
						);
		}else{
			if(nuevoItemEquipo.getTextPrecioEspecial().getText().equals("")){
				item.setPrecioMin(0);
				item.setPrecioMax(
						(int)nuevoItemEquipo.getTextPrecio().getValue()
						*
						((Coin)nuevoItemEquipo.getComboMoneda().getSelectedItem()).getValue()
						);
			}else{
				item.setEspecial(true);
			}
			
		}
		if(item.getNombre() != null && (item.getPrecioMax() !=0 || item.isEspecial()))
				modelEquipo.nuevoItem(item);
		
		//TODO: queda especificar lo del precio especial
	}



	public void nuevoGrupo() {
		item = null;
		item = new ItemEquipo();
		byte cat = (byte) nuevoItemEquipo.getComboCategoria().getSelectedIndex();
		String grupo = nuevoItemEquipo.getTextGrupo().getText();
		if(!grupo.equals("")){
			int i = JOptionPane.showConfirmDialog(nuevoItemEquipo, "¿Realmente quieres añadir\n el grupo "
													+grupo+" a la categoria "+nuevoItemEquipo.getComboCategoria().getSelectedItem()+"?", "Añadir nuevo Grupo",JOptionPane.YES_NO_OPTION);
			if(i == JOptionPane.YES_OPTION)
				item = new ItemEquipo(grupo,cat);
				modelEquipo.nuevogrupo(item);
				nuevoItemEquipo.getTextGrupo().setText("");
				refrescarGrupos();
		}else{
			JOptionPane.showMessageDialog(nuevoItemEquipo, "Debes especificar el nuevo grupo");
		}
		
		
	}



	public void refrescarGrupos() {
		Vector<ItemEquipo> grupo = null;
		int i = nuevoItemEquipo.getComboCategoria().getSelectedIndex();
		nuevoItemEquipo.getComboGrupo().removeAll(); 
		if(!(grupos[i]==null)){
			grupo = (Vector<ItemEquipo>) grupos[i];
			nuevoItemEquipo.getComboGrupo().setModel(new DefaultComboBoxModel<ItemEquipo>(grupo));
		  }  	
		
	}



	public void limpiar() {
		//TODO:QUedan por limpiar algunas cosas...
		nuevoItemEquipo.getTextPrecio().setText("");
		nuevoItemEquipo.getTextNombre().setText("");
		nuevoItemEquipo.getTextPrecioMax().setText("");
		nuevoItemEquipo.getTextPrecioMin().setText("");
		nuevoItemEquipo.getTextPeso().setText("");
		nuevoItemEquipo.getTextGrupo().setText("");
		nuevoItemEquipo.getTextPrecioEspecial().setText("");
		nuevoItemEquipo.getComboCategoria().setSelectedIndex(0);
		nuevoItemEquipo.getComboGrupo().setSelectedIndex(0);
		nuevoItemEquipo.getComboMoneda().setSelectedIndex(0);
		nuevoItemEquipo.getComboMin().setSelectedIndex(0);
		nuevoItemEquipo.getComboMax().setSelectedIndex(0);
		nuevoItemEquipo.getChckbxPesoDespreciable().setSelected(false);
		nuevoItemEquipo.getChckbxPesoInfimo().setSelected(false);
		
		
		
	}



	


	

}
