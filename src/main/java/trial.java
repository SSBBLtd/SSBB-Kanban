import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class trial {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String findByID() throws SQLException {

		String sql = "USE sql348458";
		String sql2 = "Select * from roles";
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String result = "";
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			rs2 = ps2.executeQuery();
			while (rs2.next()) {

				result += "\n" + rs2.getString("role");

			}

			// ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}
}
