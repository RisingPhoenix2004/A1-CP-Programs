// javac preparedStatement.java
// java -cp "mysql-connector-j-8.0.32.jar;." preparedStatement

import java.sql.*;

class preparedStatement {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    PreparedStatement pstmt = null;

    
    try{
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      pstmt = conn.prepareStatement("insert into dept values(?,?, ?)"); 
      pstmt.setInt(1, 60);  //1 specifies the first parameter in the query  
      pstmt.setString(2, "Marketing"); 
      pstmt.setString(3, "Mumbai");

      int i=pstmt.executeUpdate();  
      System.out.println(i + " record inserted");        
    }   
    catch(SQLException e){
      e.printStackTrace();
    }
    finally
    {
      pstmt.close();
      conn.close();
    }
  }
}     
