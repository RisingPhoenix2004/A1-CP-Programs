select ename, deptno from emp where deptno in(10, 30, 50);

select ename, deptno from emp 
  where deptno <> 20 and deptno <> 30;

select ename, deptno from emp 
  where deptno <> 20 or deptno <> 30;

select ename, deptno, job from emp 
  where (deptno BETWEEN 10 AND 30)
  and not job in ('manager','clerk');

select ename, hiredate from emp 
  where (hiredate BETWEEN '95/10/31' AND '97/12/5');

select * from emp
  where hiredate between cast('93-05-14' as date) and cast('97-12-5' as date);

select count(*) from emp;
Select COUNT(sal) from emp;
Select COUNT(mgr) from emp;	       
Select COUNT(comm) from emp;

select sum(sal) as "Total Salary", sum(comm) as "Total commision" from emp;

select sum(sal)/count(sal) as "Average salary", 
  sum(comm)/count(comm) as "Average commision" from emp;

select AVG(sal) from emp; 
select MAX(sal) from emp;
select MIN(sal) from emp;

select SUM(hiredate) from emp; 

SELECT * FROM salgrade WHERE grade = 3 or 1=1;

SELECT * FROM salgrade WHERE ""="";

SELECT * FROM emp limit 5;

/* Gets 3 rows after the first 5 */
SELECT * FROM emp limit 5, 3;

/* gets 10 rows after the first 5 or lesser if there are fewer rows */
SELECT * FROM emp order by ename limit 5, 10;
