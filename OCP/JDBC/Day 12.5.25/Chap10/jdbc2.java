// javac jdbc2.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc2

import java.sql.*;

class jdbc2 {
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

      stmt = conn.createStatement();
      String sql;
      sql = "SELECT empno, ename, sal from emp where empno > 7600";

      boolean isResultSet = stmt.execute(sql);
      if (isResultSet) {
        rs = stmt.getResultSet();
        System.out.println("ran a query");
      } else {
        result = stmt.getUpdateCount();
        System.out.println("ran an update" + " " + result);
      }

      while(rs.next()){
        int empno  = rs.getInt("EMPNO");
        String name = rs.getString("ENAME");
        int sal=rs.getInt("sal");
        System.out.print(" empno : " +empno);
        System.out.print(" name : " + name);
        System.out.println(" sal : " + sal);
      }

      String update="update emp set sal=sal+500";
      isResultSet = stmt.execute(update);
      if (!isResultSet) {
        result = stmt.getUpdateCount();
        System.out.println("result " + result);
      }      
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
