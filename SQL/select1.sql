/* To write sql output to a file do the following before you run the script */
/* tee e:\tanla\mysql\output.txt */

/* Once done you can disable output by using */
/* notee */

use test;

desc emp;
desc dept;
desc salgrade;

select * from emp;

select * from dept;

select * from salgrade;

select * from emp where deptno = 10;

select * from emp where hiredate = '98/8/15';

select * from emp where deptno = 
  (select deptno from dept where dname = "Sales");

/* Aliases can be useful when:

There are more than one table involved in a query
Functions are used in the query
Column names are big or not very readable
Two or more columns are combined together */

select empno, ename as EmployeeName, deptno as 'Department Number' from emp;

select empno, concat(ename,', ',job,', ',mgr,', ',hiredate) 
  as 'Employee details' from emp;

select job from Emp;

select distinct job from Emp;

select * from salgrade 
  where grade between 2 and 4;

select * from salgrade 
  where grade >= 1;   // Test with >= & <=

select * from emp 
  where deptno between 10 and 30;

select ename, deptno from emp
  where deptno not between 10 and 30;
  
select * from emp 
  where deptno in (20, 30);

select * from emp 
  where deptno = 20 or deptno = 30;

select * from emp 
  where ename between 'K' and 'A';

update emp set ename = 'K' 
  where empno = 7876;

select * from emp 
  where ename between 'A' and 'F';

update emp set ename = 'Kevin' 
  where empno = 7876;

select * from emp 
  where ename  between 'A' and 'K';

select * from salgrade 
  where grade < 3;

select * from salgrade 
  where grade < 4 and hisal > 4000;
