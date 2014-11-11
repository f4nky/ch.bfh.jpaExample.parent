/**
 * 
 */

import ch.bfh.jpaExample.model.Project;
import ch.bfh.jpaExample.model.Task;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.List;


/**
 * @author Fanky
 * 
 */
public class ReadIT {

	@Test
	public void test() throws ParseException {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.jpaExample.domain").createEntityManager();

		Query q = em.createQuery("select p from Project p");
		@SuppressWarnings("unchecked")
        List<Project> foundProjects = q.getResultList();
		Project firstProject = foundProjects.get(0);
		Assert.assertTrue(firstProject.getTitle().equals("Project 1"));

		List<Task> foundTasks = firstProject.getTasks();
		Task firstTask = foundTasks.get(0);
		Assert.assertTrue(firstTask.getName().equals("P1 - Task 1"));
	}

}
