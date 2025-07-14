INSERT INTO Categories (categoryID, description, maxPrice)
VALUES 
    (1, 'Clothing', 100.00),
    (2, 'Electronics', 500.00),
    (3, 'Books', 60.00),
    (4, 'Furniture', 800.00),
    (5, 'Toys', 75.00);

-- Required so DonorIntrests is functional

INSERT INTO Donors (
    donorID, firstName, lastName, middleInitial, dateOfBirth,
    civicNumber, streetName, city, postalCode, province, gender,
    SSN, phone, email
) VALUES
    (101, 'Alice', 'Smith', 'B', '1990-04-15', 123, 'Maple Street', 'Montreal', 'H1A1A1', 'QC', 'Female', '123-45-6789', '514-555-1212', 'alice@example.com'),
    (102, 'Bob', 'Jones', 'C', '1985-09-20', 456, 'Elm Avenue', 'Brossard', 'J4W2A1', 'QC', 'Male', '987-65-4321', '438-123-4567', 'bob@example.com'),
    (103, 'Carla', 'Nguyen', 'A', '1992-12-10', 789, 'Oak Road', 'Sherbrooke', 'J1K2B3', 'QC', 'Female', '654-32-1987', '514-888-9999', 'carla@example.com');

INSERT INTO DonorInterests (donorID, categoryID)
VALUES 
    (101, 2),  -- Alice likes Electronics
    (101, 3),  -- Alice also likes Books
    (102, 1),  -- Bob likes Clothing
    (102, 5),  -- Bob also likes Toys
    (103, 4);  -- Carla likes Furniture
