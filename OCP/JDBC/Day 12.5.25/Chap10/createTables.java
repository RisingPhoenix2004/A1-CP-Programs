// javac createTables.java
// java -cp "mysql-connector-j-8.0.32.jar;." createTables

import java.sql.*;

class createTables {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/test";
    
  static final String USER = "root";
  static final String PASS = "root";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    Statement stmt = null;
    
    try{
      System.out.println("Connecting to database...");

      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Creating statement...");

      stmt = conn.createStatement();

      stmt.executeUpdate("CREATE TABLE emp ("
        + "empno int(4) primary key, "
        + "ename varchar(50) not null, "
        + "job varchar(50) not null, "
        + "mgr int(4), "
        + "hiredate date, "
        + "sal decimal(10,2), "
        + "comm decimal(10,2), "
        + "deptno int(2))");

		/*
		String createEmp = "CREATE TABLE IF NOT EXISTS emp(empno int(4) primary key,ename varchar(50) not null,job varchar(50) not null,  mgr int(4), hiredate date,  sal decimal(10,2), comm decimal(10,2),  deptno int(2)))";

		stmt.executeUpdate(createEmp);
		*/

      stmt.executeUpdate(
        "CREATE TABLE dept ("
        + "deptno int(2) primary key, "
        + "dname varchar(50) not null, "
        + "location varchar(50) not null)");

		/*
		String createDept= "CREATE TABLE dept(deptno int(2) primary key,dname varchar(50) not null,location varchar(50) not null)";
		statement.executeUpdate(createDept); 
		*/

      stmt.executeUpdate(
        "ALTER TABLE emp ADD CONSTRAINT fk_dept FOREIGN KEY (deptno) REFERENCES dept (deptno)");

      stmt.executeUpdate("insert into dept values (10,'Accounting','New York')");
      stmt.executeUpdate("insert into dept values (20,'Research','Dallas')");
      stmt.executeUpdate("insert into dept values (30,'Sales','Chicago')");
      stmt.executeUpdate("insert into dept values (40,'Operations','Boston')");
      stmt.executeUpdate("insert into dept values (50,'Finance','Tempe')");

      stmt.executeUpdate("insert into emp values (7369,'SMITH','CLERK',7902,'93/6/13',800,0.00,20)");
      stmt.executeUpdate("insert into emp values (7521,'ALLEN','SALESMAN',7698,'96/3/26',1250,500,30)");
      stmt.executeUpdate("insert into emp values (7566,'JONES','MANAGER',7839,'95/10/31',2975,null,20)");
      stmt.executeUpdate("insert into emp values (7698,'BLAKE','MANAGER',7839,'92/6/11',2850,null,30)");
      stmt.executeUpdate("insert into emp values (7782,'CLARK','MANAGER',7839,'93/5/14',2450,null,10)");
    }   
    catch(SQLException e){
      e.printStackTrace();
    }
    finally
    {
      stmt.close();
      conn.close();
    }
  }
}     
