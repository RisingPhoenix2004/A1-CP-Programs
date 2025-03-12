select * from emp where deptno = 
 (select deptno from dept where dname = "Sales"); 

select * from emp where deptno in 
 (select deptno from dept where job = "Manager"); 

select * from emp where deptno not in 
 (select deptno from dept where job = "Manager"); 

/* Test with greater than (>), less than < etc */ 
select ename, empno, sal 
 from emp 
where sal = ( 
 select max(sal) from emp 
); 

select ename, empno, sal 
 from emp 
where sal > ( 
 select avg(sal) from emp 
); 

select ename, empno, sal, avg(sal) 
 from emp 
where sal > ( 
 select avg(sal) from emp 
); 

select deptno, dname 
 from dept 
where 
 deptno not in (select distinct(deptno) from emp);

select deptno, dname 
 from dept 
where 
 deptno in (select distinct(deptno) from emp); 
