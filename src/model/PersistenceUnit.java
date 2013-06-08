package model;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class PersistenceUnit {
  private static final String PERSISTENCE_UNIT_NAME = "GDPA";
  private EntityManagerFactory factory;
  

  public PersistenceUnit () {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

   
  }

public EntityManagerFactory getFactory() {
	return factory;
}


  
  
} 



