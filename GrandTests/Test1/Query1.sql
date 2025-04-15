/* Write a SQL query to calculate the total revenue per customer, excluding cancelled orders, 
for those with at least two orders between October 10 and October 15, 2024.

Expected Output Columns:
------------------------
+----------------+--------------+
| Name           | TotalRevenue |
+----------------+--------------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products

*/
use customer_orders;
select c.Name, Sum(o.TotalCost) as TotalRevenue
from Orders o
join Customers c on c.CustomerID=o.CustomerID
where o.Status not in ("Cancelled") and o.OrderDate between '2024-10-10' and '2024-10-15'
group by c.Name
having Count(o.OrderID) >=2;