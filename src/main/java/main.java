import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssbb.kanban.dao.impl.RoleDAO;
import com.ssbb.kanban.data.impl.Role;

public class main {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");

		RoleDAO roleDAO = (RoleDAO) context.getBean("RoleDAO");
		Role role = new Role();

		role.setType("Hello");
		roleDAO.update(role);

		/*
		 * trial trialBean = (trial) context.getBean("trialBean");
		 * System.out.println(trialBean.findByID());
		 */
		// projectTrial trial = (projectTrial) context.getBean("project");
		// System.out.println(trial.getRoles());
	}

}
