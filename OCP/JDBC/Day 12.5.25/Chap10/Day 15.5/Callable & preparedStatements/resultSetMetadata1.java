// javac resultSetMetadata1.java
// java -cp "mysql-connector-j-8.0.32.jar;." resultSetMetadata1

import java.sql.*;

class resultSetMetadata1 {
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    
  static final String USER = "root";
  static final String PASS = "none";
     
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
      String sql;
      sql = "SELECT * from emp";
      rs = stmt.executeQuery(sql);

      ResultSetMetaData rsmd = rs.getMetaData();
	  int numberOfColumns = rsmd.getColumnCount();
	  System.out.println("Number of columns " + numberOfColumns);
	  for(int i = 1; i <= numberOfColumns; i++)
		  System.out.println("Column Name: " + rsmd.getColumnName(i) + 
		  " Column Type: " + rsmd.getColumnTypeName(i));	
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
