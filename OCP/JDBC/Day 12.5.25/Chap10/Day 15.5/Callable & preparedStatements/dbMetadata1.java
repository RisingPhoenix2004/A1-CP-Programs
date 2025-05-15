// javac dbMetadata1.java
// java -cp "mysql-connector-j-8.0.32.jar;." dbMetadata1

import java.sql.*;

class dbMetadata1 {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	static final String USER = "root";
	static final String PASS = "none";

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");

			// Retrieve metadata about the database
			DatabaseMetaData dbmd = conn.getMetaData();

			System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("Database Connection Information: " + dbmd.getConnection());
			System.out.println("Database User Name : " + dbmd.getUserName());
			System.out.println("Database URL Information : " + dbmd.getURL());
			System.out.println("Database Time Date Functions : " + dbmd.getTimeDateFunctions());
			rs = dbmd.getCatalogs();
			rs = dbmd.getTables("TABLE_CAT", "TABLE_SCHEM", "TABLE_NAME", new String[] { "TABLE" });
			while (rs.next()) {
				System.out.println(
						rs.getString("TABLE_CAT") + rs.getString("TABLE_SCHEM") + " " + rs.getString("TABLE_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
