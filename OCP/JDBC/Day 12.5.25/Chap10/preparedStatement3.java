// java -cp "mysql-connector-j-8.0.32.jar;." preparedStatement3

import java.sql.*;

class preparedStatement3 {
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

	  pstmt = conn.prepareStatement("select empno, ename from emp where deptno = (select deptno from dept where dname=?)");
      pstmt.setString(1,"Sales");
      ResultSet rs = pstmt.executeQuery();
      while(rs.next())
        System.out.println(rs.getString("empno")+" "+rs.getString("ename")); 
      
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
