import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");

		trial trialBean = (trial) context.getBean("trialBean");
		System.out.println(trialBean.findByID());
	}

}
