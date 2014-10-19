import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssbb.kanban.dao.DAOImpl;

public class main {
	@Autowired
	static DAOImpl dao;

	public static void main(String[] args) throws SQLException {
		/*
		 * ApplicationContext context = new ClassPathXmlApplicationContext(
		 * "context.xml");
		 * 
		 * RoleDAO roleDAO = (RoleDAO) context.getBean("DAOImpl");
		 */

	}
}
