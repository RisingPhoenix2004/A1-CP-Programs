// javac callableStatement.java
// java -cp "mysql-connector-j-8.0.32.jar;." callableStatement

import java.sql.*;

class callableStatement {
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    CallableStatement stmt = null;
    
    try{
      System.out.println("Connecting to database...");

      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt=conn.prepareCall("{call getJob(?, ?)}");  
      stmt.setInt(1,7566); 
      stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
      stmt.execute();  
      String job = stmt.getString(2); 
      System.out.println("job: " + job);
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
