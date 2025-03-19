use test;

# ----------------------------------------
DROP PROCEDURE IF EXISTS empCount;

# Get count of employees
CREATE PROCEDURE empCount (OUT param1 INT)
SELECT COUNT(*) INTO param1 FROM emp;

# calling/invoking the procedure
CALL empCount(@num);
select @num;

# ------------------------------------------
DROP PROCEDURE IF EXISTS empAverageSal;

# Get average salary of employees

DELIMITER $$
CREATE PROCEDURE empAverageSal(OUT avgSal decimal(10,2))
 BEGIN
 SELECT AVG(sal) INTO avgSal FROM emp;
 END $$

DELIMITER ;

call empAverageSal(@sal);
select @sal;

# ------------------------------------------
DROP PROCEDURE IF EXISTS getJob;

# Given empno, get the job
CREATE PROCEDURE getJob (IN param1 INT, OUT param2 varchar(50))
SELECT job into param2 from emp where empno = param1; 

CALL getJob(7788, @job);
select @job;

# ------------------------------------------
DROP PROCEDURE IF EXISTS setCounter;

DELIMITER $$
CREATE PROCEDURE setCounter(INOUT count INT(3),IN inc INT(3))
BEGIN
 SET count = count + inc;
END$$
DELIMITER ;

SET @counter = 1;
CALL setCounter(@counter,1); 
CALL setCounter(@counter,2); 
CALL setCounter(@counter,3); 
SELECT @counter; 

# ------------------------------------------
DROP PROCEDURE IF EXISTS getEmpSalGrade;
DELIMITER $$
 
CREATE PROCEDURE getEmpSalGrade(
    in  p_empNo int, 
    out p_empSalGrade  varchar(10))
BEGIN
    DECLARE empSal double;
 
    SELECT sal INTO empSal
    FROM emp
    WHERE empno = p_empNo;
 
    IF empSal > 3000 THEN
      SET p_empSalGrade = 'HIGH';
    ELSEIF (empSal > 1000 && empSal <= 3000 ) THEN
      SET p_empSalGrade = 'MEDIUM';
    ELSEIF (empSal <= 1000) THEN
      SET p_empSalGrade = 'LOW';
    END IF;
 
END$$

DELIMITER ;

call getEmpSalGrade(7839, @empSalGrade);
select @empSalGrade;

call getEmpSalGrade(7369, @empSalGrade);
select @empSalGrade;

call getEmpSalGrade(7698, @empSalGrade);
select @empSalGrade;

# ------------------------------------------
DROP PROCEDURE IF EXISTS getEmpSalGrade2;
DELIMITER $$
 
CREATE PROCEDURE getEmpSalGrade2(
    in  p_empNo int, 
    out p_empSalGrade  varchar(10))
BEGIN
    DECLARE empSal double;
 
    SELECT sal INTO empSal
    FROM emp
    WHERE empno = p_empNo;
 
    CASE
    WHEN empSal > 3000 THEN
      SET p_empSalGrade = 'HIGH';
    WHEN (empSal > 1000 && empSal <= 3000 ) THEN
      SET p_empSalGrade = 'MEDIUM';
    WHEN (empSal <= 1000) THEN
      SET p_empSalGrade = 'LOW';
    END CASE;
 
END$$

DELIMITER ;

call getEmpSalGrade2(7839, @empSalGrade);
select @empSalGrade;

call getEmpSalGrade2(7369, @empSalGrade);
select @empSalGrade;

call getEmpSalGrade2(7698, @empSalGrade);
select @empSalGrade;

# ------------------------------------------
DROP PROCEDURE IF EXISTS setShippingDays;
DELIMITER $$
 
CREATE PROCEDURE setShippingDays(
    in  p_deptNo int, 
    out p_shippingDays  varchar(50))
BEGIN
    DECLARE cLocation varchar(50);
 
    SELECT location INTO cLocation
    FROM dept
    WHERE deptno = p_deptNo;
    
    CASE cLocation
    when  'Dallas' THEN
      SET p_shippingDays = '1 day shipping';
    when  'Tempe' THEN
      SET p_shippingDays = '2 days shipping';
    when  'Chicago' THEN
      SET p_shippingDays = '3 days shipping';
    ELSE 
      SET p_shippingDays = '7 days shipping';
    END CASE;
 
END$$

DELIMITER ;

call setShippingDays(20, @custShippingDays);
select @custShippingDays;

call setShippingDays(50, @custShippingDays);
select @custShippingDays;

call setShippingDays(30, @custShippingDays);
select @custShippingDays;

# ------------------------------------------

DROP PROCEDURE IF EXISTS initDB;
DELIMITER $$
 
CREATE PROCEDURE initDB()
BEGIN
    delete from emp;
	delete from dept;
	delete from salgrade;
 
END$$

DELIMITER ;

call initDB();

SHOW PROCEDURE STATUS WHERE Db = 'test';

# ------------------------------------------

