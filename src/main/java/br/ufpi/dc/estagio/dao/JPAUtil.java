package br.ufpi.dc.estagio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManager entityManager;
    private static EntityManagerFactory factory=null;

    public static EntityManager getEntityManager() {
        try {
            if (factory == null) {
                factory = Persistence.createEntityManagerFactory("UsuarioCRUDPU");
                entityManager = factory.createEntityManager();
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        
        return entityManager;
    }

}
