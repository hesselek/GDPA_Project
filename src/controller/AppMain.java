package controller;




import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.UIManager;



import model.PersistenceUnit;
import model.Todo;


import view.MainGUI;



public class AppMain {

	/**
	 * @param args
	 * @throws PropertyVetoException 
	 */
	public PersistenceUnit persistence;
	public MainGUIController guiController;
	//public MainGUI frame;
	
	
	
	
	public AppMain(){
		persistence = new PersistenceUnit();
		//EntityManager em = persistence.getFactory().createEntityManager();
		guiController = new MainGUIController(persistence);
		
		
	}
	public static void main(String[] args) {
			
			
			
			//MainGUI frame;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				AppMain main = new AppMain();
				main.launchVentana();
			}
		});
		 
	/*	 try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Throwable e) {
				e.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
					 frame = new MainGUI(guiController);
					 frame.setVisible(true);
					
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});*/
	/*	 
    Query q = em.createQuery("select t from Todo t");
    List<Todo> todoList = q.getResultList();
    for (Todo todo : todoList) {
      System.out.println(todo);
    }
    System.out.println("Size: " + todoList.size());

    // Create new todo
    em.getTransaction().begin();
    Todo todo = new Todo();
    todo.setSummary("This is a test");
    todo.setDescription("This is a test");
    em.persist(todo);
    em.getTransaction().commit();

    em.close();
	//	main = new MainGUI();
	//	main.setVisible(true);	
	//	carlos c = new carlos();
		
	//	c.open();
	*/

	}
	protected void launchVentana() {
		guiController.launch();
		
	}

	
	
	


}