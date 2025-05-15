// java -cp "mysql-connector-j-8.0.32.jar;." preparedStatement2

import java.sql.*;

class preparedStatement2 {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");

      conn = DriverManager.getConnection(DB_URL,USER,PASS);
     
      pstmt = conn.prepareStatement("update dept set deptno = ? where deptno= ?"); 
      pstmt.setInt(1, 80);
      pstmt.setInt(2, 60);
      int i=pstmt.executeUpdate();  
      System.out.println(i + " record(s) updated");  
      
      pstmt = conn.prepareStatement("delete from dept where deptno= ?"); 
      pstmt.setInt(1, 60);  
      i=pstmt.executeUpdate();  
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
