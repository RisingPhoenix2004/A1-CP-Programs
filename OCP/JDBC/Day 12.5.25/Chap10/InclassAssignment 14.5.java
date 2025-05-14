import java.sql.*;

class CallableStatementExample {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    static final String USER = "root";
    static final String PASS = "none";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        CallableStatement stmt = null;

        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Preparing the stored procedure call
            stmt = conn.prepareCall("{call getAll()}");

            // First, use execute() to check if it runs successfully
            boolean hasResultSet = stmt.execute();

            if (hasResultSet) {
                System.out.println("Procedure executed successfully. Retrieving data...");

                // Use executeQuery() to fetch results
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int deptno = rs.getInt("deptno");
                    String dname = rs.getString("dname");
                    String location = rs.getString("location"); // Ensure column names match DB schema

                    System.out.println("Dept No: " + deptno + ", Name: " + dname + ", Location: " + location);
                }
            } else {
                System.out.println("Procedure executed but no result set returned.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
    }
}
/*
 * DELIMITER $$
 * 
 * CREATE PROCEDURE getAllDepartments()
 * BEGIN
 * SELECT * FROM departments;
 * END $$
 * 
 * DELIMITER ;
 * 
 */