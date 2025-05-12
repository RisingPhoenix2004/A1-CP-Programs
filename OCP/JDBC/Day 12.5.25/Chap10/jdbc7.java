// javac jdbc7.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc7

import java.sql.*;
import java.time.*;

// How many resources are closed in this code?

class jdbc7 {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select count(*) from emp")) {

      if(rs.next()) 
        System.out.println(rs.getInt(1));

      ResultSet rs2 = stmt.executeQuery("select count(*) from emp");
      int num = stmt.executeUpdate(
        "update emp set ename = 'kmit' where ename = 'jones'");
    }   
  }
}     
