// javac callableStatement3.java
// java -cp "mysql-connector-j-8.0.32.jar;." callableStatement3

/*
DROP PROCEDURE IF EXISTS deleteEmployees;

# delete department
CREATE PROCEDURE deleteEmployees(IN dno int)
delete from emp where deptno = dno;

# calling/invoking the procedure
CALL deleteEmployees(10);
*/

import java.sql.*;

class callableStatement3 {
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

		stmt=conn.prepareCall("{call deleteEmployees(?)}");  
		stmt.setInt(1, 30); 
	
	/*
		int count = stmt.executeUpdate();  
		System.out.println("Rows deleted " + count);
	*/

		boolean isRS = stmt.execute();  
		if(!isRS)
		{
			int count = stmt.getUpdateCount();  
			System.out.println("Rows deleted " + count);
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
