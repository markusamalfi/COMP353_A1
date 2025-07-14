-- 1. Donors table
CREATE TABLE Donors (
    donorID INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    middleInitial CHAR(1),
    dateOfBirth DATE,
    civicNumber INT, -- Numeric Part of Address
    streetName VARCHAR(100), -- Alphabetical Part of Address
    city VARCHAR(50),
    postalCode VARCHAR(10),
    province VARCHAR(20),
    gender VARCHAR(10),
    SSN CHAR(11),
    phone VARCHAR(20),
    email VARCHAR(100)
);

-- 2. Donations table
CREATE TABLE Donations (
    dID INT PRIMARY KEY,
    donorID INT,
    date DATE,
    type ENUM('money', 'products'),
    amount DECIMAL(10, 2),
    FOREIGN KEY (donorID) REFERENCES Donors(donorID)
);

-- 3. Categories table
CREATE TABLE Categories (
    categoryID INT PRIMARY KEY,
    description VARCHAR(100),
    minPrice DECIMAL(10, 2),
    maxPrice DECIMAL(10, 2)
);

-- 4. Products table
CREATE TABLE Products (
    pID INT PRIMARY KEY,
    categoryID INT,
    description VARCHAR(255),
    date DATE,
    price DECIMAL(10, 2),
    weight DECIMAL(6, 2), -- in kilograms
    location VARCHAR(100),
    color VARCHAR(50),
    FOREIGN KEY (categoryID) REFERENCES Categories(categoryID)
);

-- 5. Sales table
CREATE TABLE Sales (
    sID INT PRIMARY KEY,
    date DATE,
    amount DECIMAL(10, 2),
    deliveryFee DECIMAL(10, 2) DEFAULT 0.0
);

-- 6. SalesItems table
CREATE TABLE SalesItems (
    sID INT,
    pID INT,
    PRIMARY KEY (sID, pID),
    FOREIGN KEY (sID) REFERENCES Sales(sID),
    FOREIGN KEY (pID) REFERENCES Products(pID)
);

-- 7. DonorInterests table
CREATE TABLE DonorInterests (
    donorID INT,
    categoryID INT,
    PRIMARY KEY (donorID, categoryID),
    FOREIGN KEY (donorID) REFERENCES Donors(donorID),
    FOREIGN KEY (categoryID) REFERENCES Categories(categoryID)
);
