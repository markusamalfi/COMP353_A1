
public class Question_2_Driver {

	
	public static void main(String[] args) {
		
		//Constants for datatype codes
	    int STRING = 0;
	    int CHAR = 1;
	    int INTEGER = 2;
	    int DOUBLE = 3;
		
	    //PART a)
	    
	    //1. Donors
	    
		Table Donors = new Table();
		Donors.addToSchema("donorID", INTEGER, null);
		Donors.addToSchema("firstName", STRING, null);
		Donors.addToSchema("lastName", STRING, null);
		Donors.addToSchema("middleInitial", CHAR, null);
		Donors.addToSchema("dateOfBirth", STRING, null);
		Donors.addToSchema("civic number", INTEGER, null);
		Donors.addToSchema("street name", STRING, null);
        Donors.addToSchema("city", STRING, null);
        Donors.addToSchema("postalCode", STRING, null);
        Donors.addToSchema("province", STRING, null);
        Donors.addToSchema("gender", STRING, null);
        Donors.addToSchema("SSN", INTEGER, null);
        Donors.addToSchema("phone", STRING, null);
        Donors.addToSchema("email", STRING, null);
        System.out.println(Donors);

                
        //2. Donations
        Table Donations = new Table();
        Donations.addToSchema("dID", INTEGER, null);
        Donations.addToSchema("donorID", INTEGER, null);
        Donations.addToSchema("date", STRING, null);
        Donations.addToSchema("type", STRING, null);
        Donations.addToSchema("amount", DOUBLE, null);
        System.out.println(Donations);

        
        //3. Products
        Table Products = new Table();
        Products.addToSchema("pID", INTEGER, null);
        Products.addToSchema("categoryID", INTEGER, null);
        Products.addToSchema("description", STRING, null);
        Products.addToSchema("date", STRING, null);
        Products.addToSchema("price", DOUBLE, null);
        Products.addToSchema("weight", DOUBLE, null);
        Products.addToSchema("location", STRING, null);
        Products.addToSchema("color", STRING, null);
        System.out.println(Products);


        //4. Sales
        Table Sales = new Table();
        Sales.addToSchema("sID", INTEGER, null);
        Sales.addToSchema("date", STRING, null);
        Sales.addToSchema("amount", DOUBLE, null);
        Sales.addToSchema("deliveryFee", DOUBLE, null);
        System.out.println(Sales);

        
        //5. SalesItems
        Table SalesItems = new Table();
        SalesItems.addToSchema("sID", INTEGER, null);
        SalesItems.addToSchema("pID", INTEGER, null);
        System.out.println(SalesItems);
        
        //6. Categories
        Table Categories = new Table();
        Categories.addToSchema("categoryID", INTEGER, null);
        Categories.addToSchema("description", STRING, null);
        Categories.addToSchema("minPrice", DOUBLE, null);
        Categories.addToSchema("maxPrice", DOUBLE, null);
        System.out.println(Categories);
        
        //7. DonorInterests
        Table DonorInterests = new Table();
        DonorInterests.addToSchema("donorID", INTEGER, 0);
        DonorInterests.addToSchema("categoryID", INTEGER, 0);
        System.out.println(DonorInterests);

        //Part B
        Categories.removeFromSchema("minPrice");
        System.out.println(Categories);
        
        //Part C
		Donors.addToSchema("hobby", STRING, "Unknown");
        System.out.println(Donors);

        //Part D
        
        //Categories
        Categories.addRow(new Object[]{1, "Food & Nutrition", 50d});
        Categories.addRow(new Object[]{2, "Education", 65d});
        Categories.addRow(new Object[]{3, "Healthcare", 900.5d});
        System.out.println(Categories);

        
        //Donor Intrests
        DonorInterests.addRow(new Object[]{101, 1});
        DonorInterests.addRow(new Object[]{102, 2});
        DonorInterests.addRow(new Object[]{103, 3});
        System.out.println(DonorInterests);

        //QUESTION 2 MAIN QUESTION:
        Donors.addRow(new Object[]{1, "Alice", "Smith", 'M', "1985-03-12", 123, "King St", "Sherbrooke", "J1H4H1", "QC", "Female", 123456789, "514-123-4567", "alice@example.com", "Gardening"});
        Donors.addRow(new Object[]{2, "Bob", "Johnson", 'T', "1990-07-19", 456, "Queen St", "Sherbrooke", "J1H4H2", "QC", "Male", 987654321, "514-987-6543", "bob@example.com", "Fishing"});
        Donors.addRow(new Object[]{3, "Carla", "Brown", 'A', "1978-11-23", 789, "Duke St", "Sherbrooke", "J1H4H3", "QC", "Female", 456123789, "438-123-9999", "carla@example.com", "Reading"});
        Donors.addRow(new Object[]{4, "Dan", "Lee", 'B', "1982-05-14", 321, "Bay St", "Montreal", "H3Z2Y7", "QC", "Male", 321654987, "514-456-7890", "dan@example.com", "Cycling"});
        Donors.addRow(new Object[]{5, "Eva", "Martinez", 'C', "1995-12-01", 654, "Park Ave", "Toronto", "M5V2N8", "ON", "Female", 789123456, "647-555-6789", "eva@example.com", "Photography"});
        System.out.println(Donors + "\nFiltered for Sherbrooke: \n");
        Donors.findAndPrintColumnsByValue("Sherbrooke", "city", new String[] {"donorID","firstName", "lastName", "dateOfBirth", "phone", "email", "gender", "SSN"});
        
        //Part E
        Donors.deleteAllData();
        System.out.println(Donors);
        
        Categories.deleteAllData();
        System.out.println(Categories);
        
        DonorInterests.deleteAllData();
        System.out.println(DonorInterests);

        
        //Part F
        Donors.dropTable();
        System.out.println(Donors);
        
        Donations.dropTable();
        System.out.println(Donations);

        Products.dropTable();
        System.out.println(Products);
        
        Sales.dropTable();
        System.out.println(Sales);
        
        SalesItems.dropTable(); 
        System.out.println(SalesItems);

        Categories.dropTable();
        System.out.println(Categories);
        
        DonorInterests.dropTable();
        System.out.println(DonorInterests);
        
	}
}
