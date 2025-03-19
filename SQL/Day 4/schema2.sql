use test;

Create table student(Sno integer NOT NULL,
  	Sname varchar(10), Marks integer);

insert into student values(101,'Arun',50);
insert into student values(NULL,'Arun',NULL); /* Invalid */

Create table student2(Sno integer Unique, 
  collegeId integer unique,
  Sname varchar(10), Marks integer);

insert into student2 values(101,1,'Arun',50);
insert into student2 values(101,2, NULL,50); /* Invalid */
insert into student2 values(102,2, NULL,50); 
insert into student2 values(NULL,3,'Arun',50); 
insert into student2 values(NULL,NULL,'Arun',50); 
insert into student2 values(NULL,2,'Arun',50); /* Invalid */

Create table student3(Sno integer Primary key, Sname varchar(10), Marks integer);

insert into student3 values(101,'Arun',50);
Insert into student3 values(101,NULL,50);  /* Invalid */
Insert into student3 values(NULL,'Arun',50); /* Invalid */

Create table student4(firstname varchar(10),
  lastname varchar(10),
  Marks integer,
  PRIMARY KEY(firstname,lastname));

Insert into student4 values('ravi','Reddy',40);
Insert into student4 values('Ravi','Reddy',40); /* invalid */
Insert into student4 values('Subba','Rao',40);
Insert into student4 values('Kavita','Reddy',40);
Insert into student4 values(NULL,'Arun',40);  /* invalid */
Insert into student4 values('Raj',NULL,40); /* invalid */

Create table school(sno integer, Sname varchar(10), Marks integer,
  primary key(sno));

insert into school values(101,'Arun',90);
insert into school values(102,'Fs1',92);
insert into school values(103,'Amit',45);

Create table library(sno integer primary key, Book_name varchar(10),
  FOREIGN KEY (sno) REFERENCES school(sno) 
  ON UPDATE CASCADE on delete cascade);

Insert into library values(102,'java');
Insert into library values(103,'c++');
Insert into library values(103,'oracle');
Insert into library values(108,'dotnet'); 
Insert into library values(Null,'DBA'); 

delete from school where sno = 102;

Create table school1(sno integer, Sname varchar(10), Marks integer, 
primary key(sno));

insert into school1 values(101,'Arun',90);
insert into school1 values(102,'Fs1',92);
insert into school1 values(103,'Amit',45);

Create table library1(sno integer primary key, Book_name varchar(10), 
FOREIGN KEY (sno) REFERENCES school1(sno) ON UPDATE CASCADE on delete cascade);

Insert into library1 values(101,'C');
Insert into library1 values(102,'java');
Insert into library1 values(103,'c++');

delete from school1 where sno = 102;

CREATE TABLE CUSTOMERS(
  ID   INT              NOT NULL,
  NAME VARCHAR (20)     NOT NULL,
  AGE  INT              NOT NULL CHECK (AGE >= 18),
  PRIMARY KEY (ID)
);

Insert into customers values(1, 'Ravi', 25);
Insert into customers values(2, 'Ravi', 15); /* Error */ 

CREATE TABLE CUSTOMERS2(
  ID   INT              NOT NULL,
  NAME VARCHAR (20)     NOT NULL,
  AGE  INT              NOT NULL,
  Country   VARCHAR(30) DEFAULT 'india',
  orderDate TIMESTAMP   DEFAULT now(),
  PRIMARY KEY (ID)
);

insert into customers2 (id, name, age) values (1, "ravi", 25);
insert into customers2 values (2, "subbu", 30, 'usa', now());
insert into customers2 (id, name, age, country) values (3, "ravi", 25, 'USA');
insert into customers2 (id, name, age, country) values (4, CURRENT_USER() , 25, 'USA');
