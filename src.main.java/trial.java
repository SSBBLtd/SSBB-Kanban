
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class trial {

	private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 

	public String findByID() {
	
		
		String sql = "select * from roles";
		Connection conn = null;
		ResultSet rs = null;
				try {
					conn = dataSource.getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					String sql2 = "Select * from roles";
					rs = ps.executeQuery();
					ps.executeUpdate();
					
					
					ps.close();
		 
				} catch (SQLException e) {
					throw new RuntimeException(e);
		 
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {}
					}
				}
		
		return rs.toString();
	}
}
