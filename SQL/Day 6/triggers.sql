# -----------------------------------------

use test;

DROP TABLE IF EXISTS emp_audit;

CREATE TABLE emp_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    empno INT NOT NULL,
    
    ename VARCHAR(50) NOT NULL,
	deptno int NOT NULL,
    changedat DATETIME DEFAULT NULL,
    action VARCHAR(50) DEFAULT NULL
);

DROP TRIGGER IF EXISTS before_emp_update;

DELIMITER $$
CREATE TRIGGER before_emp_update 
    BEFORE UPDATE ON emp
    FOR EACH ROW 
BEGIN
    INSERT INTO emp_audit
    SET action = 'Before update',
      empno = OLD.empno,
      ename = OLD.ename,
	  deptno = OLD.deptno,
      changedat = NOW(); 
END $$
DELIMITER ;

update emp set sal = '5000' where empno = 7876;
update emp set job = 'analyst', deptno = 30 where empno = 7934;
update emp set deptno = 20 where empno = 7499;
update emp set deptno = 20 where empno = 7521;


select * from emp_audit;

# -----------------------------------------

DROP TRIGGER IF EXISTS after_insert_emp;

DELIMITER $$
CREATE TRIGGER after_insert_emp 
    AFTER INSERT ON emp
    FOR EACH ROW 
BEGIN
    INSERT INTO emp_audit
    SET action = 'After insert',
      empno = NEW.empno,
      ename = NEW.ename,
	  deptno = NEW.deptno,
      changedat = NOW(); 
END$$
DELIMITER ;

insert into emp values (9999,'David','Manager',7902,'93/6/13',800,0.00,20);
insert into emp values (8888,'David','Manager',7902,'93/6/13',800,0.00,20);

select * from emp_audit;

# -----------------------------------------

DROP TRIGGER IF EXISTS after_delete_emp;

DELIMITER $$
CREATE TRIGGER after_delete_emp 
    AFTER DELETE ON emp
    FOR EACH ROW 
BEGIN
    INSERT INTO emp_audit
    SET action = 'After delete',
      empno = OLD.empno,
      ename = OLD.ename,
	  deptno = OLD.deptno,
      changedat = NOW(); 
END$$
DELIMITER ;

delete from emp where empno = 7369;
delete from emp where empno = 7934;

select * from emp_audit;


# -----------------------------------------

DROP TABLE IF EXISTS empsal;

CREATE TABLE empsal(
  totalSal int(4)
);

DELIMITER $$

DROP TRIGGER IF EXISTS beforeEmpInsert;

CREATE TRIGGER beforeEmpInsert
BEFORE INSERT
ON emp FOR EACH ROW
BEGIN
    DECLARE rowcount INT;
    
    SELECT COUNT(*) 
    INTO rowcount
    FROM empsal;
    
    IF rowcount > 0 THEN
        UPDATE empsal set totalSal = totalSal + new.sal;
    ELSE
        INSERT INTO empsal values (new.sal);
    END IF; 
END $$

DELIMITER ;

insert into emp values (5000,'Satyam','ANALYST',7566,'97/12/5',3000,null,20);
insert into emp values (6000,'Ravi','SALESMAN',7698,'98/12/5',1250,1400,40);
insert into emp values (7000,'Ravi','SALESMAN',7698,'98/12/5',5250,1400,40);

select * from empsal;

# -----------------------------------------

DROP TABLE IF EXISTS CUSTOMERS;

CREATE TABLE CUSTOMERS(
 ID INT NOT NULL,
 NAME VARCHAR (20) NOT NULL,
 AGE INT NOT NULL,
 PRIMARY KEY (ID)
);



CREATE TRIGGER beforeCustomersInsert
BEFORE INSERT
ON CUSTOMERS FOR EACH ROW
BEGIN
	if(new.age < 20)
	THEN
		SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: Age cannot be lesser than 20';
	END IF;
END $$

DELIMITER ;

insert into customers values(10, "Ravi", 25);
insert into customers values(20, "Subbu", 15);



DROP TRIGGER IF EXISTS beforeCustomersUpdate;
DELIMITER $$
CREATE TRIGGER beforeCustomersUpdate
BEFORE Update
ON CUSTOMERS FOR EACH ROW
BEGIN
	if(new.age < 20)
	THEN
		SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: Age cannot be lesser than 20';
	END IF;
    if(old.age < 20)
    THEN
    SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = "Warning: Old age less than 20";
    END IF;
    END $$

Delimiter ;
update customers set age = 10 where id = 10;
update customers set age = 30 where id = 20;