import java.sql.*;

class DeleteEmployeesByDept {
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

            stmt = conn.prepareCall("{call removeEmployeesByDept(?)}");
            int x = 20;
            stmt.setInt(1, x);

            boolean executed = stmt.execute();
            int rowsAffected = stmt.getUpdateCount();
            if (!executed) {
                System.out.println("Emp from dept " + x + " removed." + rowsAffected + " rows affected.");
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
 * CREATE PROCEDURE remEmpByDept(IN dept_no INT)
    -> BEGIN
    ->     DELETE FROM emp WHERE deptno = dept_no;
    -> END $$
 */