DROP TABLE IF EXISTS OrderItems;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Products;


CREATE TABLE Customers (
  CustomerID INT PRIMARY KEY,
  Name VARCHAR(255),
  Email VARCHAR(255),
  Address VARCHAR(255),
  PhoneNumber VARCHAR(20)
);

CREATE TABLE Products (
  ProductID INT PRIMARY KEY,
  Name VARCHAR(255),
  Description VARCHAR(255),
  Price DECIMAL(10, 2)
);

CREATE TABLE Orders (
  OrderID INT PRIMARY KEY,
  CustomerID INT,
  OrderDate DATE,
  TotalCost DECIMAL(10, 2),
  Status VARCHAR(20),
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE OrderItems (
  OrderItemID INT PRIMARY KEY,
  OrderID INT,
  ProductID INT,
  Quantity INT,
  UnitPrice DECIMAL(10, 2),
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

INSERT INTO Customers (CustomerID, Name, Email, Address, PhoneNumber) VALUES
(1, 'Alice Johnson', 'alice.johnson@example.com', '123 Apple St, New York, NY', '123-456-7890'),
(2, 'Bob Smith', 'bob.smith@example.com', '456 Elm St, Los Angeles, CA', '987-654-3210'),
(3, 'Charlie Davis', 'charlie.davis@example.com', '789 Maple St, Chicago, IL', '555-123-4567'),
(4, 'Diana Williams', 'diana.williams@example.com', '321 Oak St, Dallas, TX', '123-987-6543'),
(5, 'Ethan Brown', 'ethan.brown@example.com', '654 Pine St, Seattle, WA', '222-333-4444'),
(6, 'Fiona Adams', 'fiona.adams@example.com', '987 Cedar St, Miami, FL', '444-555-6666'),
(7, 'George Clark', 'george.clark@example.com', '213 Birch St, San Francisco, CA', '555-666-7777'),
(8, 'Henry Taylor', 'henry.taylor@example.com', '456 Spruce St, Denver, CO', '111-222-3333'),
(9, 'Irene Green', 'irene.green@example.com', '789 Willow St, Austin, TX', '444-555-6666');

INSERT INTO Products (ProductID, Name, Description, Price) VALUES
(101, 'Laptop', '15-inch gaming laptop', 1200.00),
(102, 'Smartphone', 'Latest model smartphone', 800.00),
(103, 'Headphones', 'Noise-canceling headphones', 150.00),
(104, 'Keyboard', 'Mechanical keyboard', 75.00),
(105, 'Mouse', 'Wireless mouse', 40.00),
(106, 'Monitor', '27-inch 4K Monitor', 300.00),
(107, 'Printer', 'Color Laser Printer', 200.00),
(108, 'Tablet', '10-inch Tablet', 500.00),
(109, 'External SSD', '1TB External SSD', 150.00),
(110, 'Smartwatch', 'Fitness Smartwatch', 250.00);

INSERT INTO Orders (OrderID, CustomerID, OrderDate, TotalCost, Status) VALUES
(1001, 1, '2024-10-10', 1250.00, 'Shipped'),
(1002, 2, '2024-10-12', 850.00, 'Processing'),
(1003, 1, '2024-10-15', 75.00, 'Delivered'),
(1004, 3, '2024-10-14', 40.00, 'Cancelled'),
(1005, 4, '2024-10-13', 450.00, 'Shipped'),
(1006, 5, '2024-10-12', 550.00, 'Processing'),
(1007, 6, '2024-10-14', 250.00, 'Cancelled'),
(1008, 7, '2024-10-15', 1200.00, 'Delivered'),
(1009, 4, '2024-10-14', 300.00, 'Processing'),
(1010, 3, '2024-10-15', 950.00, 'Shipped'),
(1011, 1, '2024-10-16', 200.00, 'Processing'),  -- Alice's 3rd order
(1012, 1, '2024-10-17', 100.00, 'Delivered'),   -- Alice's 4th order
(1013, 2, '2024-10-16', 150.00, 'Shipped'),     -- Bob's 2nd order
(1014, 2, '2024-10-17', 50.00, 'Processing'),   -- Bob's 3rd order
(1015, 3, '2024-10-17', 60.00, 'Cancelled');    -- Charlie's 2nd order


INSERT INTO OrderItems (OrderItemID, OrderID, ProductID, Quantity, UnitPrice) VALUES
(1, 1001, 101, 1, 1200.00),  -- Alice ordered 1 Laptop
(2, 1001, 104, 1, 75.00),    -- Alice also ordered 1 Keyboard
(3, 1002, 102, 1, 800.00),   -- Bob ordered 1 Smartphone
(4, 1003, 104, 1, 75.00),    -- Alice ordered another Keyboard
(5, 1004, 105, 1, 40.00),    -- Charlie ordered 1 Mouse
(6, 1005, 107, 1, 200.00),  -- Diana ordered 1 Printer
(7, 1005, 110, 1, 250.00),  -- Diana ordered 1 Smartwatch
(8, 1006, 108, 1, 500.00),  -- Ethan ordered 1 Tablet
(9, 1006, 105, 1, 40.00),   -- Ethan also ordered 1 Mouse
(10, 1007, 110, 1, 250.00), -- Fiona ordered 1 Smartwatch
(11, 1008, 101, 1, 1200.00),-- George ordered 1 Laptop
(12, 1009, 106, 1, 300.00), -- Diana ordered 1 Monitor
(13, 1010, 102, 1, 800.00), -- Charlie ordered 1 Smartphone
(14, 1010, 109, 1, 150.00), -- Charlie also ordered 1 External SSD
(15, 1003, 104, 2, 75.00),  -- Another 2 Keyboards ordered
(16, 1011, 104, 1, 75.00),  -- 1 more Keyboard ordered in Alice's 3rd order
(17, 1012, 105, 3, 40.00),  -- 3 Mice ordered
(18, 1008, 105, 1, 40.00),  -- 1 Mouse ordered in George's order
(19, 1013, 105, 1, 40.00),  -- 1 Mouse ordered in Bob's order
(20, 1014, 105, 1, 40.00),  -- 1 more Mouse ordered in Bob's order
(21, 1015, 106, 1, 300.00); -- 1 Monitor ordered

