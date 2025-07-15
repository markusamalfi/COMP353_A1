SELECT 
    donorID, 
    firstName, 
    lastName, 
    middleInitial, 
    gender, 
    dateOfBirth, 
    phone, 
    email, 
    SSN
FROM Donors
WHERE city IN ('Brossard', 'Sherbrooke');
