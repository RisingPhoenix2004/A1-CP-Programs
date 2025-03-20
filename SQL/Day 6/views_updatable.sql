In MySQL, views are not only query-able but also updatable. It means that you
can use the INSERT or UPDATE statement to insert or update rows of the base 
table through the updatable view. In addition, you can use DELETE statement 
to remove rows of the underlying table through the view.

However, to create an updatable view, the SELECT statement that defines the 
view must not contain any of the following elements:

Aggregate functions such as MIN, MAX, SUM, AVG, and COUNT.

DISTINCT

GROUP BY clause.

HAVING clause.

UNION or UNION ALL clause.

Left join or outer join.

Subquery in the SELECT clause or in the WHERE clause that refers to
the table appeared in the FROM clause.

Reference to non-updatable view in the FROM clause.

Reference only to literal values.

Multiple references to any column of the base table.

--------------------------------------------------------------------------------

You can check if a view in a database in updatable by querying the 
is_updatable column from the views table in the information_schema database.

The following query gets all views from the test database and shows which 
views are updatable.

SELECT 
    table_name, 
    is_updatable
FROM
    information_schema.views
WHERE
    table_schema = 'test';

--------------------------------------------------------------------------------

select * from empdetails2;

update empdetails2 set job="manager" where empno="7369";

select * from empdetails2;

--------------------------------------------------------------------------------

delete from empdetails2 where empno="7369";

select * from empdetails2;
