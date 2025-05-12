// java -cp "mysql-connector-j-8.0.32.jar;." descTable

import java.sql.*;

class descTable {
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
      System.out.println("Creating statement...");

      stmt = conn.createStatement();

	  String sql = "desc emp";
       rs = stmt.executeQuery(sql);

      while(rs.next()){
        System.out.println(rs.getString("Field")+"\t"+rs.getString("Type") +"\t"+ rs.getString("Null")+"\t"+rs.getString("Key")+"\t"+rs.getString("Default"));

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
