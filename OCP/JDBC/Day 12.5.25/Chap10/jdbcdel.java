// javac jdbcdel.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbcdel

import java.sql.*;

class jdbcdel {
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try{
      Class.forName(JDBC_DRIVER);
      System.out.println("Connecting to database...");

      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Creating statement...");

      stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
		  ResultSet.CONCUR_READ_ONLY);

	  String sql="delete from emp where ename = \'any\' or 1 = 1";
      int result = stmt.executeUpdate(sql);
      System.out.println("result " + result);

    }  
    catch(Exception e){
      e.printStackTrace();
    }
    finally
    {
      conn.close();
    }
  }
}     
