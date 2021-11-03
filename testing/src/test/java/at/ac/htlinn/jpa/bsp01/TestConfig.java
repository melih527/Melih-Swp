
package at.ac.htlinn.jpa.bsp01;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TestConfig {
	public static void main(String[] args) {
			final String pers_unitname= "bsp01";
	        EntityManagerFactory emf = 
	        		Persistence.createEntityManagerFactory(pers_unitname);
	        EntityManager em = emf.createEntityManager();
	        
	        
	        
	        try {
	        	// JPQL - Java Persistence Query Language - nicht SQL
	            String sql = "SELECT s FROM Student1 s";
	            Query query = em.createQuery(sql);
				@SuppressWarnings("unchecked")
				List<Student1> list = query.getResultList();
	            for (Student1 item : list) {
	                System.out.printf("%d ", item.getId());
	                System.out.printf("%s ", item.getFirstName());
	                System.out.printf("%s\n ", item.getLastName());
	            }        
	        } finally {
	            em.close();
	            emf.close();
	        }
	    }
}
