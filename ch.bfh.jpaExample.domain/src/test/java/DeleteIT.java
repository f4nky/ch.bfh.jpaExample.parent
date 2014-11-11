/**
 * 
 */

import ch.bfh.jpaExample.model.Project;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Fanky
 * 
 */
public class DeleteIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.jpaExample.domain").createEntityManager();

		Query q = em.createQuery("select p from Project p");

		List<Project> foundProjects = q.getResultList();
		Project firstProject = foundProjects.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		em.remove(firstProject);
		em.getTransaction().commit();
	}

}
