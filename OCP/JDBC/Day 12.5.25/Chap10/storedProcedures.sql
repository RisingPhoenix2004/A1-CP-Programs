use test;

// https://www.geeksforgeeks.org/how-to-call-stored-functions-and-stored-procedures-using-jdbc/

# ------------------------------------------
DROP PROCEDURE IF EXISTS getJob;

# Given empno, get the job
CREATE PROCEDURE getJob (IN param1 INT, OUT param2 VARCHAR(20))
SELECT job into param2 from emp where empno = param1; 

CALL getJob(7369, @job);
select @job;



create procedure countbydept(in deptname varchar(50), out empcount int)
begin
    select count(*)
    into empcount
    from emp
    where deptno = (select deptno from dept where dname = deptname);
end$$
