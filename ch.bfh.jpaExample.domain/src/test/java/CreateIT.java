/**
 * 
 */

import ch.bfh.jpaExample.model.Project;
import ch.bfh.jpaExample.model.Task;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * @author Fanky
 * 
 */
public class CreateIT {

	@Test
	public void test() throws ParseException {

        Project project = new Project();
        project.setTitle("Project 1");

        Task task1 = new Task();
        task1.setName("P1 - Task 1");
        task1.setProject(project);

        Task task2 = new Task();
        task2.setName("P1 - Task 2");
        task2.setProject(project);

		ArrayList<Task> tasks = new ArrayList<Task>();
        tasks.add(task1);
        tasks.add(task2);

        project.setTasks(tasks);

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.jpaExample.domain").createEntityManager();

		em.getTransaction().begin();
		em.persist(project);
		em.getTransaction().commit();
	}
}
