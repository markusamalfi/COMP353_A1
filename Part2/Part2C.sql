SELECT 
    YEAR(date) AS saleYear,
    SUM(amount) AS totalAmount
FROM Sales
WHERE 
    MONTH(date) = 2 AND 
    DAY(date) = 14 AND 
    YEAR(date) BETWEEN 2020 AND 2025
GROUP BY saleYear
ORDER BY totalAmount DESC;
