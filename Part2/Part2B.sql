SELECT 
    s.sID AS saleID,
    p.pID AS productID,
    c.description AS categoryDescription,
    p.price,
    c.maxPrice,
    p.weight
FROM Sales s
JOIN SalesItems si ON s.sID = si.sID
JOIN Products p ON si.pID = p.pID
JOIN Categories c ON p.categoryID = c.categoryID
WHERE 
    p.color = 'red' AND
    s.date = '2025-02-14';
