SELECT 
    d.firstName,
    d.lastName,
    d.gender,
    c.description
FROM Donors d
JOIN DonorInterests di ON d.donorID = di.donorID
JOIN Categories c ON di.categoryID = c.categoryID
WHERE d.city = 'Chicoutimi'
ORDER BY d.gender ASC, d.lastName ASC, d.firstName ASC, c.description ASC;
