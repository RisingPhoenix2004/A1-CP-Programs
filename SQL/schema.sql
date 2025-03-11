/* source filename to run from command line */
/* source E:\Tapadia\Juno\RDBMS\schema.sql */

USE Test;

/* current database */
SELECT DATABASE();

DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

SHOW TABLES;

DROP TABLE IF EXISTS dept;
DROP TABLE IF EXISTS salgrade;
DROP TABLE IF EXISTS emp;

CREATE TABLE salgrade(
  grade int(4) primary key,
  losal decimal(10,2),
  hisal decimal(10,2)
);

CREATE TABLE dept(
  deptno int(2) primary key,
  dname varchar(50) not null,
  location varchar(50) not null
);

CREATE TABLE emp(
  empno int(4) primary key,
  ename varchar(50) not null,
  job varchar(50) not null,
  mgr int(4),
  hiredate date,
  sal decimal(10,2),
  comm decimal(10,2),
  deptno int(2)
);

ALTER TABLE emp ADD CONSTRAINT fk_dept FOREIGN KEY (deptno) 
  REFERENCES dept (deptno);

insert into dept values (10,'Accounting','New York');
insert into dept values (20,'Research','Dallas');
insert into dept values (30,'Sales','Chicago');
insert into dept values (40,'Operations','Boston');
insert into dept values (50,'Finance','Tempe');

insert into emp values (7369,'SMITH','CLERK',7902,'93/6/13',800,0.00,20);
insert into emp values (7499,'ALLEN','SALESMAN',7698,'98/8/15',1600,300,10);
insert into emp values (7521,'ALLEN','SALESMAN',7698,'96/3/26',1250,500,30);
insert into emp values (7566,'JONES','MANAGER',7839,'95/10/31',2975,null,20);
insert into emp values (7698,'BLAKE','MANAGER',7839,'92/6/11',2850,null,30);
insert into emp values (7782,'CLARK','MANAGER',7839,'93/5/14',2450,null,10);
insert into emp values (7788,'SCOTT','ANALYST',7566,'96/3/5',3000,null,20);
insert into emp values (7839,'KEVIN','PRESIDENT',null,'90/6/9',5000,0,40);
insert into emp values (7844,'KEVIN','SALESMAN',7698,'95/6/4',1500,0,30);
insert into emp values (7876,'KEVIN','CLERK',7788,'99/6/4',1100,null,20);
insert into emp values (7900,'JAMES','CLERK',7698,'00/6/23',950,null,20);
insert into emp values (7934,'FORD','CLERK',7782,'00/1/21',1300,null,10);
insert into emp values (7902,'FORD','ANALYST',7566,'97/12/5',3000,null,20);
insert into emp values (7654,'MARTIN','SALESMAN',7698,'98/12/5',1250,1400,40);

insert into salgrade values (1,700,2222);
insert into salgrade values (2,1201,3333);
insert into salgrade values (3,1401,4444);
insert into salgrade values (4,2001,5555);
insert into salgrade values (5,3001,6666);
insert into salgrade (losal,hisal,grade) values (4001,8888, 6);