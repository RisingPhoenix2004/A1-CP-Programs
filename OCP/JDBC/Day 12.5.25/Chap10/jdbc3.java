// javac jdbc3.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc3

import java.sql.*;

class jdbc3 {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    int result;
    
    try{
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Creating statement...");

      // replace with ResultSet.CONCUR_READ_ONLY
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
          ResultSet.CONCUR_UPDATABLE);

      stmt = conn.createStatement();

      String sql;
      sql = "SELECT empno, ename, sal from emp";
      rs = stmt.executeQuery(sql);

      //rs.absolute(2); 
      rs.updateString("ename", "Allen"); 
      rs.updateRow();       
    }   
    catch(Exception e){
      e.printStackTrace();
    }
    finally
    {
      rs.close();
      stmt.close();
      conn.close();
    }
  }
}     
