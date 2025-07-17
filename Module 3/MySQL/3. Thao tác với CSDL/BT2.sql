USE SupermarketDB;
INSERT INTO Customer 
Values (1, "Minh Quan", 10),
(2, "Ngoc Oanh", 20),
(3, "Hong Ha", 50);

INSERT INTO `Order`
Values (1,1, "2006-3-21", Null),
(2,2, "2006-3-23", Null),
(3,1, "2006-3-16", Null);

INSERT INTO Product
Values (1, "May Giat", 3),
(2, "Tu Lanh", 5),
(3, "Dieu Hoa", 7),
(4, "Quat", 1),
(5, "Bep Dien", 2);

INSERT INTO `OrderDetail`
VALUES 
('1', '1', 3),
('1', '3', 7),
('1', '4', 2),
('2', '1', 1),
('3', '1', 8),
('2', '3', 3);
------------
Select oID, oDate, oTotalPrice from `Order`;
---
SELECT 
    c.cID,
    c.cName,
    p.pID,
    p.pName,
    od.odQTY
FROM 
    Customer c
JOIN 
    `Order` o ON c.cID = o.cID
JOIN 
    OrderDetail od ON o.oID = od.oID
JOIN 
    Product p ON od.pID = p.pID;
----
SELECT c.cID, c.cName
FROM Customer c
LEFT JOIN `Order` o ON c.cID = o.cID
WHERE o.oID IS NULL;
----
SELECT 
    o.oID,
    o.oDate,
    SUM(od.odQTY * p.pPrice) AS TotalPrice
FROM `Order` o
JOIN OrderDetail od ON o.oID = od.oID
JOIN Product p ON od.pID = p.pID
GROUP BY o.oID, o.oDate;


