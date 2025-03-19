
SQL Functions and Queries

1. Write a SQL function to calculate years of service for an employee as of March 18, 2025.

**Query:** SELECT empno, ename, hiredate, YearsOfService(empno) AS years_of_service FROM emp ORDER BY years_of_service DESC LIMIT 5;

+-------+-------+------------+------------------+
| empno | ename | hiredate   | years_of_service |
+-------+-------+------------+------------------+

2. Write a SQL function to calculate an employee’s total compensation (salary + commission).

**Query:** SELECT empno, ename, sal, comm, TotalCompensation(empno) AS total_comp FROM emp WHERE comm IS NOT NULL ORDER BY total_comp DESC;

+-------+--------+---------+---------+------------+
| empno | ename  | sal     | comm    | total_comp |
+-------+--------+---------+---------+------------+

 3. Write a SQL function to return the department name for an employee.

**Query:** SELECT empno, ename, deptno, GetDeptName(empno) AS dept_name FROM emp ORDER BY empno LIMIT 5;

+-------+--------+--------+------------+
| empno | ename  | deptno | dept_name  |
+-------+--------+--------+------------+

 4. Write a SQL function to check if an employee’s salary exceeds a threshold of 3000.

**Query:** SELECT empno, ename, sal, ExceedsThreshold(empno) AS above_3000 FROM emp ORDER BY sal DESC LIMIT 5;

+-------+-------+---------+------------+
| empno | ename | sal     | above_3000 |
+-------+-------+---------+------------+

 5. Write a SQL function to calculate the tax (10% of salary) for an employee.

**Query:** SELECT empno, ename, sal, CalculateTax(empno) AS tax FROM emp WHERE deptno = 20 ORDER BY sal DESC;

+-------+-------+---------+--------+
| empno | ename | sal     | tax    |
+-------+-------+---------+--------+

 6. Write a SQL function to return the manager’s name for an employee.

**Query:** SELECT empno, ename, mgr, GetManagerName(empno) AS manager_name FROM emp WHERE mgr IS NOT NULL ORDER BY empno LIMIT 5;
+-------+--------+------+--------------+
| empno | ename  | mgr  | manager_name |
+-------+--------+------+--------------+

 7. Write a SQL function to calculate the annual salary for an employee.

**Query:** SELECT empno, ename, sal, AnnualSalary(empno) AS annual_salary FROM emp WHERE job = 'SALESMAN';

+-------+--------+---------+---------------+
| empno | ename  | sal     | annual_salary |
+-------+--------+---------+---------------+

 8. Write a SQL function to determine if an employee has a commission.

**Query:** SELECT empno, ename, comm, HasCommission(empno) AS has_comm FROM emp ORDER BY empno LIMIT 5;

+-------+--------+---------+----------+
| empno | ename  | comm    | has_comm |
+-------+--------+---------+----------+

 9. Write a SQL function to calculate the percentage of salary relative to a threshold of 5000.

**Query:** SELECT empno, ename, sal, SalaryPercentage(empno) AS sal_percent FROM emp ORDER BY sal DESC LIMIT 5;

+-------+-------+---------+-------------+
| empno | ename | sal     | sal_percent |
+-------+-------+---------+-------------+

 10. Write a SQL function to return the hire year of an employee.

**Query:** SELECT empno, ename, hiredate, HireYear(empno) AS hire_year FROM emp WHERE deptno = 30;

+-------+-------+------------+-----------+
| empno | ename | hiredate   | hire_year |
+-------+-------+------------+-----------+
