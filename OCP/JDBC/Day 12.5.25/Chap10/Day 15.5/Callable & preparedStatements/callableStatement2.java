// javac callableStatement2.java
// java -cp "mysql-connector-j-8.0.32.jar;." callableStatement2

/*
DROP PROCEDURE IF EXISTS getDepartments;

# Get count of employees
CREATE PROCEDURE getDepartments()
SELECT * from dept;

# calling/invoking the procedure
CALL getDepartments();
*/

import java.sql.*;

class callableStatement2 {
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    CallableStatement stmt = null;
	ResultSet rs = null;
    
    try{
		System.out.println("Connecting to database...");

		conn = DriverManager.getConnection(DB_URL,USER,PASS);

		stmt=conn.prepareCall("{call getDepartments()}");  
		rs = stmt.executeQuery();  
		while(rs.next())
		{
			System.out.println(rs.getInt("deptno") + " " + rs.getString("dname") + " " + rs.getString("location"));
		}
    }   
    catch(Exception e){
      e.printStackTrace();
    }
    finally
    {
      stmt.close();
      conn.close();
    }
  }
}     
