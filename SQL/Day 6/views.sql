# -----------------------------------------

use test;

DROP VIEW IF EXISTS empDetails;

CREATE VIEW empDetails AS
SELECT 
    empno, ename, job, deptno, count(job) as total 
FROM
    emp
GROUP by job
ORDER BY ename;

select * from empDetails;

# -----------------------------------------

DROP VIEW IF EXISTS empDept;

CREATE or REPLACE VIEW empDept AS
  select emp.empno, emp.ename, emp.deptno, dept.dname, emp.job
  from emp
  inner join dept
  on emp.deptno=dept.deptno
  ORDER BY ename;

select * from empDept;

-- Show Create View empDept;

Alter view empDept
As
  select emp.empno, emp.ename, dept.dname
  from emp
  inner join dept
  on emp.deptno=dept.deptno;

select * from empDept;

# -----------------------------------------

DROP VIEW IF EXISTS empDetails2;

CREATE VIEW empDetails2 AS
SELECT 
    empno, ename, job, deptno 
FROM
    emp;

select * from empDetails2;

desc information_schema.views;

select table_catalog, table_schema, table_name, view_definition, check_option from information_schema.views where
TABLE_SCHEMA = 'test';

