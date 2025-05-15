// java -cp "mysql-connector-j-8.0.32.jar;." prepStmtJoin

import java.sql.*;

class prepStmtJoin {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try{

      conn = DriverManager.getConnection(DB_URL,USER,PASS);     
  
      pstmt = conn.prepareStatement("select e.empno,e.ename, d.deptno, d.dname, d.location from emp e join dept d on e.deptno = d.deptno where d.deptno = ?"); 

      pstmt.setInt(1, 20);   
	  ResultSet rs = pstmt.executeQuery();
      while(rs.next())
        System.out.println(rs.getString("empno")+" "+rs.getString("ename")+" "+rs.getInt("deptno")+" "+rs.getString("dname")+" "+rs.getString("location"));     
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
