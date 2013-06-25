package model.equipo;




import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import utilities.Coin;
import model.PersistenceUnit;

public class Equipo_Model {
	private PersistenceUnit persistence;
	private EntityManager em;
	private ItemEquipo item;

	public Equipo_Model(PersistenceUnit persistence) {
		this.persistence = persistence;
		em = persistence.getFactory().createEntityManager();
	}

	public void nuevogrupo(ItemEquipo item) {
		this.item = item;
		em.getTransaction().begin();
		 em.persist(item);
		 em.getTransaction().commit();
		// em.close();
		 item = null;
		
	}
	
	
	public void nuevoItem(ItemEquipo item){
		this.item = item;
		em.getTransaction().begin();
		 em.persist(item);
		 em.getTransaction().commit();
		// em.close();
		 item = null;
	}

	

	public void cargarGrupos(Object[] grupos) {
	
		for(int i = 0; i <= Coin.values().length;i++){
			Query q= em.createQuery("Select I FROM ItemEquipo I Where I.categoria =?1 AND I.precioMax =?2 and I.especial = false");
			q.setParameter(1, i);
			q.setParameter(2,0);
			List<ItemEquipo> v = q.getResultList();
			v.add(0, null);
			grupos[i] = v;
		}
	
	}

	public List<ItemEquipo> cargarDatosModelo(int i) {
		List<ItemEquipo>lista = new ArrayList<ItemEquipo>();
			Query q= em.createQuery("Select I FROM ItemEquipo I WHERE I.categoria=?1");
			q.setParameter(1, i);
			lista = q.getResultList();
		return lista;
	}

	public void precioEspecial(String nombre, String text) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery("Insert into GENERIC.PUBLIC.PRECIOESPECIAL(NOMBRE,PRECIO) VALUES(?1,?2)");
		q.setParameter(1, nombre);
		q.setParameter(2, text);
		q.executeUpdate();
		em.getTransaction().commit();
		
	}

	public Object getSpecialPrice(String nombre) {
		Query q= em.createNativeQuery("SELECT PRECIO FROM GENERIC.PUBLIC.PRECIOESPECIAL p WHERE p.NOMBRE=?1");
		q.setParameter(1, nombre);
		return q.getSingleResult();
	}



}
