select * from emp where ename like 'a%';

select * from emp where ename like '%n';

select * from emp where ename like '%in';

select * from emp where ename like '%l_%';

select * from emp where ename like 'A___n';

select * from emp where ename like 'k%n';

select * from emp where ename not like 'k%n';

/* does not work in MYSQL */
select * from emp where ename like '[km]%n'; 

select * from emp where ename like 'k%n' or ename like 'm%n';

SELECT * FROM emp WHERE ename REGEXP '[km]';

SELECT * FROM emp WHERE ename rlike '[km]';

SELECT * FROM emp WHERE ename REGEXP '^[km]';

SELECT * FROM emp WHERE ename REGEXP '^[AF]';

SELECT * FROM emp WHERE ename rlike '[AF]'

/* Starting with A and all characters upto starting with K */
SELECT * FROM emp WHERE ename REGEXP '^[A-K]';

SELECT * FROM emp WHERE ename REGEXP '[AK]';

select * from emp where empno like '7%8';

select ename from emp where ename regexp '[0-9][a-z]';

select ename from emp where ename regexp '[a-z][0-9]';