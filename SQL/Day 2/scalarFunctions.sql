/* String related scalar functions */

SELECT CONCAT('Hello', 'World');

Select CONCAT('hello', space(3), 'world');

Select CONCAT(empno,', ',ename) as 'Employee' from emp;

SELECT INSTR('hello' , 'e');

SELECT LENGTH('hello');

SELECT LENGTH(ename) from emp;

SELECT RTRIM(' hello    ');

SELECT LTRIM('  hello    ');

SELECT REPLACE('hello' , 'e' , '$');

SELECT REVERSE('hello');

SELECT SUBSTR('hello' , 2,3);

SELECT LOWER('HELLO');

SELECT UPPER('hello');

/* Date related scalar functions */

SELECT DATE_ADD('2008-01-02', INTERVAL 1 DAY);

SELECT DATE_ADD('2008-01-02', INTERVAL 1 WEEK);

SELECT DATE_ADD('2008-01-02', INTERVAL 1 MONTH);

SELECT DAYOFMONTH('2015-08-30');

SELECT LAST_DAY('2015-08-02');

SELECT DATEDIFF('2010-04-01', '2010-03-01');

SELECT PERIOD_DIFF(201005, 201003);

SELECT SYSDATE();

/* Numeric related scalar functions */

SELECT FLOOR(59.9);

SELECT CEIL(59.1);

SELECT ROUND(59.9);

SELECT ROUND(59.1);

SELECT ABS(-2);
SELECT ABS(3);

/* Conversion scalar functions */

SELECT DATE_FORMAT(SYSDATE(), '%Y-%m-%d');
SELECT DATE_FORMAT(SYSDATE(), '%M-%Y-%d');
SELECT DATE_FORMAT(SYSDATE(), '%M-%Y-%D');
SELECT DATE_FORMAT(SYSDATE(), '%M-%y-%d');

SELECT FORMAT(1003423 , 3);

SELECT CONVERT('11', UNSIGNED INTEGER);
SELECT CONVERT('KMIT', UNSIGNED INTEGER);

/* Null related scalar function */

SELECT IFNULL(NULL, 'Hello');
SELECT IFNULL('hello', 'world');
SELECT IFNULL(NULL, NULL);