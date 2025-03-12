create table customer(
  custid int(4) NOT NULL,
  aadharno varchar(20) NOT NULL UNIQUE,
  phone varchar(10) NOT NULL
);

insert into customer values(21,'Adhar21',1234567890);
insert into customer values(31,'Adhar31',9876543210);

/* Alter statement */

/* Add column */
alter table customer add(city varchar(20));
select * from customer;
alter table customer add(state varchar(20), country varchar(20) not null);
desc customer;
select * from customer;

/* works in mysql 5.7 and 5.6 */
alter table customer add column city2 varchar(10) after city;
alter table customer add column city3 varchar(10) not null after
city;


-- // add contraint
desc customer;
alter table customer add primary key(custid);
alter table customer add constraint uk_phone UNIQUE(phone);
desc customer;

-- // modify column
alter table customer modify column city varchar(20);
update customer set city = "Hyderabad city";
desc customer;
alter table customer modify column city varchar(10);

-- // Rename a column
alter table customer change city town varchar(20);
desc customer;
alter table customer change column town city varchar(40);
desc customer;

-- // drop column
alter table customer drop column city;
alter table customer drop column state, drop column country;
select * from customer;

alter table customer drop key uk_phone;

create table emp1 as select * from emp;

create table emp2 as select * from emp where deptno = 30; 

create table emp3 as select * from emp where 10; 

create table emp4 as select empno, ename, job, deptno from emp where deptno = 20; 

create table emp5 as select * from emp where 1=1;

-- // rename table
rename table emp to employee;
