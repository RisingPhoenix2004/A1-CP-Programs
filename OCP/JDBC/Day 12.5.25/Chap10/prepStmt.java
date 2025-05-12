// java -cp "mysql-connector-j-8.0.32.jar;." prepStmt

import java.sql.*;

class prepStmt {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try{

      conn = DriverManager.getConnection(DB_URL,USER,PASS);     
  
      pstmt = conn.prepareStatement("delete from emp where ename= ?"); 
      pstmt.setString(1, "any or 1 = 1");  
      int i=pstmt.executeUpdate();  
      System.out.println(i + " record(s) deleted");   
    }   
    catch(Exception e){
      e.printStackTrace();
    }
    finally
    {
      pstmt.close();
      conn.close();
    }
  }
}     
