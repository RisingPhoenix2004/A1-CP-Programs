// javac jdbc6.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc6

import java.sql.*;
import java.time.*;

class jdbc6 {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try{
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY);

      String sql;
      sql = "SELECT empno from emp order by empno";
      rs = stmt.executeQuery(sql);  
      System.out.println(rs.next()); 
      System.out.println(rs.getInt("empno")); 
      System.out.println(rs.absolute(2));
      System.out.println(rs.getInt("empno"));
      System.out.println(rs.relative(2)); 
      System.out.println(rs.getInt("empno"));
      System.out.println(rs.absolute(-1));  // replace with 3 and test
      System.out.println(rs.getInt("empno"));
      System.out.println(rs.relative(-1));  // replace with 3 and test
      System.out.println(rs.getInt("empno"));
    }   
    catch(SQLException e){
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
