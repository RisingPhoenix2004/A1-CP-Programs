/* Write a SQL query to find the customer with the highest average order cost, 
excluding cancelled orders.

Expected Output Columns:
------------------------
+--------------+-------------+
| Name         | AvgCost     |
+--------------+-------------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products

*/
use customer_orders;
select c.Name , Avg(o.TotalCost) as AvgCost
from Orders o
join Customers c on c.CustomerID=o.CustomerID
where o.Status not in ("Cancelled")
group by c.Name
Order by AvgCost DESC 
limit 1;