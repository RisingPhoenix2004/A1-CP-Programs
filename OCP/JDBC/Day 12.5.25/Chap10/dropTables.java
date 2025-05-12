// java -cp "mysql-connector-j-8.0.32.jar;." dropTables

import java.sql.*;

class dropTables {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    Statement stmt = null;
    
    try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");

      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Creating statement...");

      stmt = conn.createStatement();

      stmt.executeUpdate("DROP TABLE IF EXISTS EMP");
      stmt.executeUpdate("DROP TABLE IF EXISTS DEPT");
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
