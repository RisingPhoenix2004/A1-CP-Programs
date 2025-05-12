// javac jdbc4.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc4

import java.sql.*;
import java.time.*;

class jdbc4 {
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

      // replace with ResultSet.CONCUR_READ_ONLY
      stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
          ResultSet.CONCUR_READ_ONLY);

      String sql;
      sql = "SELECT count(*) from emp";
      rs = stmt.executeQuery(sql);
      if(rs.next())
        System.out.println(rs.getInt(1));    

      rs = stmt.executeQuery("select empno, ename, hiredate from emp");
      while(rs.next()) {
        int empno  = rs.getInt("EMPNO");
        String name = rs.getString("ENAME");
        java.sql.Timestamp sqlTimeStamp = rs.getTimestamp("hiredate");
        LocalDateTime localDateTime = sqlTimeStamp.toLocalDateTime();
        System.out.print(" empno : " +empno);
        System.out.print(" name : " + name);
        System.out.println(" hireDate " + localDateTime); 
      }

      System.out.println();
      rs = stmt.executeQuery("select empno, ename from emp");
      while(rs.next()) {
        Object empno = rs.getObject("EMPNO");
        Object name = rs.getObject("ENAME");
        if (empno instanceof Integer) {
          int eno = (Integer) empno;
          System.out.print(eno + " ");
        }
        if (name instanceof String) {
          String ename = (String) name;
          System.out.println(ename);
        }
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
