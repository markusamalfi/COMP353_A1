import java.util.ArrayList;

public class Table {

	private TableDataTypes schema;
	private ArrayList<TableDataStorage> rows;
	
	public Table() {
		
	    this.schema = new TableDataTypes();
	    this.rows = new ArrayList<>();
	    
	}
	
	public TableDataTypes getSchema() {
		
	    return schema;
	    
	}

	public ArrayList<TableDataStorage> getRows() {
		
	    return rows;
	    
	}
	
	public void addToSchema(String name, int type, Object datum) {
		
	    schema.addDatatype(name, type);
		
		int numOfRows = rows.size();
		
		for(int i = 0; i < numOfRows; i++) {
			
			rows.get(i).addDataValue(datum);
			
		}
		
	}
	
	public void removeFromSchema(String dataTypeName) {
		
		int indexOfRemovedData = schema.removeDatatype(dataTypeName);
		
		if (indexOfRemovedData == -1) {
			
            System.out.println("Schema column '" + dataTypeName + "' not found.");
            return;
            
        }
		
		int numOfRows = rows.size();
		
		for(int i = 0; i < numOfRows; i++) {
			
			rows.get(i).removeDataAt(indexOfRemovedData);
			
		}
		
	}
	
	private boolean isValidType(int dataType, Object datum) {
	
	    if (datum == null) return true; // Allow nulls

	    switch (dataType) {
	    
	        case 0:
	        	return datum instanceof String;
	        case 1: 
	        	return datum instanceof Character;
	        case 2: 
	        	return datum instanceof Integer;
	        case 3: 
	        	return datum instanceof Double;
	        default: 
	        	return false;
	        
	    }
	    
	}

	
	public void addRow(Object[] data) {
		
		int[] dataTypes = schema.getAllDatatypeValues();
		
		if(data.length != dataTypes.length) {
			
			System.out.print("Invalid Entry! Inputted data length does not match schema");
			return;
			
		}
		
		TableDataStorage newRow = new TableDataStorage();
		
		for(int i = 0; i < data.length; i++) {
			
			if(isValidType(dataTypes[i],data[i])) {
				
				newRow.addDataValue(data[i]);
				
			} else {
				
				System.out.println("Invalid Entry! Type mismatch for value '" +
	                    data[i] + "' at index " + i + ". Expected: " + schema.getDatatype(dataTypes[i]));
				return;
				
			}
			
		}
		
		rows.add(newRow);
	    System.out.println("Row added successfully.");
		
	}
	
	public void findAndPrintColumnsByValue(Object datum, String dataType, String[] filteredDataTypes) {
		
	    int schemaIndex = schema.getDatatypeIndex(dataType);

	    if (schemaIndex == -1) {
	    	
	        System.out.println("Search column '" + dataType + "' not found in schema.");
	        return;
	        
	    }

	    int[] printIndexes = new int[filteredDataTypes.length];

	    for (int i = 0; i < filteredDataTypes.length; i++) {
	    	
	        int index = schema.getDatatypeIndex(filteredDataTypes[i]);
	        
	        if (index == -1) {
	        	
	            System.out.println("Data type '" + filteredDataTypes[i] + "' not found in schema.");
	            return;
	            
	        }
	        
	        printIndexes[i] = index;
	    }

	    boolean found = false;

	    for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
	    	
	        TableDataStorage row = rows.get(rowIndex);
	        Object value = row.getDataAt(schemaIndex);

	        if ((datum == null && value == null) || (datum != null && datum.equals(value))) {
	        	
	            found = true;
	            System.out.print("Row " + rowIndex + ": [");

	            for (int i = 0; i < printIndexes.length; i++) {
	            	
	                int printIndex = printIndexes[i];
	                String colName = filteredDataTypes[i];
	                Object val = row.getDataAt(printIndex);

	                System.out.print(colName + "=" + val);

	                if (i < printIndexes.length - 1) {
	                	
	                    System.out.print(", ");
	                    
	                }
	                
	            }

	            System.out.println("]\n");
	        }
	    }

	    if (!found) {
	    	
	        System.out.println("No matching rows found for value '" + datum + "' in column '" + dataType + "'");
	    
	    }
	    
	}

	public void deleteAllData() {
		
	    rows.clear();
	    System.out.println("All rows have been deleted.");
	    
	}
	
	public void dropTable() {
		
	    this.schema = new TableDataTypes();  
	    this.rows.clear();
	    System.out.println("Table dropped.");
	    
	}
	
	@Override
	public String toString() {
		
		StringBuilder retStr = new StringBuilder();
		retStr.append("Schema: ").append(schema).append("\n");
		
		for (int i = 0; i < rows.size(); i++) {
			
		    retStr.append("Data Entry ").append(i).append(": ").append(rows.get(i)).append("\n");
		    
		}
		
		return retStr.toString();
        
    }
	
}
