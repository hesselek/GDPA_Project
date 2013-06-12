package controller;

import java.beans.PropertyVetoException;

import javax.persistence.EntityManager;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.PersistenceUnit;
import model.equipo.Equipo_Model;
import model.equipo.ItemEquipo;
import view.Equipo;
import view.MainGUI;
import view.NuevoItemEquipo;


public class MainGUIController {
	
	private MainGUI frame;
	private Equipo equipo;
	private NuevoItemEquipo nuevoItemEquipo;
	private PersistenceUnit persistence;
	private Equipo_Model modelEquipo;

	public MainGUIController(PersistenceUnit persistence) {
		this.persistence = persistence;
		modelEquipo = new Equipo_Model(persistence);
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
		}else{		
				nuevoItemEquipo.setVisible(true);
		}
		
	}



	public void addItem(ItemEquipo item) {
		
		// TODO Auto-generated method stub
		EntityManager em = persistence.getFactory().createEntityManager();
		 em.getTransaction().begin();
		 em.persist(item);
		
		 em.getTransaction().commit();
	
		 em.close();
		 System.out.println("Aqui");
	}



	public void nuevoGrupo() {
		
		byte cat = (byte) nuevoItemEquipo.getComboCategoria().getSelectedIndex();
		String grupo = nuevoItemEquipo.getTextGrupo().getText();
		if(!grupo.equals("")){
			int i = JOptionPane.showConfirmDialog(nuevoItemEquipo, "¿Realmente quieres añadir\n el grupo "
													+grupo+" a la categoria "+nuevoItemEquipo.getComboCategoria().getSelectedItem()+"?", "Añadir nuevo Grupo",JOptionPane.YES_NO_OPTION);
			if(i == JOptionPane.YES_OPTION)
				modelEquipo.nuevogrupo(grupo,cat);
		}else{
			JOptionPane.showMessageDialog(nuevoItemEquipo, "Debes especificar el nuevo grupo");
		}
		
		
	}



	public void refrescarGrupos() {
		// TODO Auto-generated method stub
		
	}



	


	

}
