/* Group by, having, order by and combinations */

Select job, avg(sal), count(*) from emp Group By job;

Select job, count(*) from emp Group By job;	

Select job, count(job) from emp Group By job;

Select Deptno, sum(Sal), min(Sal), max(Sal), avg(Sal), count(*) 
  from emp Group By deptno;

Select deptno, sum(sal) from emp where deptno <> 10 
  Group By deptno;

Select deptno, sum(sal), count(*) from emp where deptno <> 10 
  Group By deptno;

Select deptno, job, sum(sal), count(sal) from emp 
  Group By deptno, job;

Select deptno, sum(sal) from emp 
  Group By deptno having sum(sal) > 6000;

Select * from emp Order By sal;

Select * from emp Order By ename;

select * from emp order by ename ASC;

Select * from emp Order By HIREDATE; 

Select * from emp Order By job, sal;

Select * from emp Order By sal DESC; 

select * from emp order by ename DESC, job ASC;

select * from emp order by ename, job;

Select deptno, sum(sal) from emp Group By deptno 
  Having sum(sal) > 1000 Order By sum(sal) DESC;

Select deptno, sum(sal) from emp where ename <> 'Kevin' 
  Group By deptno;

Select deptno, sum(sal) from emp where ename <> 'Kevin' 
  Group By deptno Having sum(sal) > 6000;