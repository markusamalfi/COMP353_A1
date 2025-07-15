SELECT
    MONTH(s.date) AS saleMonth,
    p.categoryID,
    COUNT(*) AS totalSales
FROM Sales s
JOIN SalesItems si ON s.sID = si.sID
JOIN Products p ON si.pID = p.pID
WHERE YEAR(s.date) = 2024
GROUP BY saleMonth, p.categoryID
ORDER BY totalSales DESC;
