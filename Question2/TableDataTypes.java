public class TableDataTypes {

    private class TableDataTypesNode {
    	
        String dataTypeName;
        int dataType;
        TableDataTypesNode dataTypeNextNode;

        TableDataTypesNode(String dataTypeName, int dataType) {
        	
            this.dataTypeName = dataTypeName;
            this.dataType = dataType;
            this.dataTypeNextNode = null;
            
        }
        
    }

    private TableDataTypesNode head;
    private TableDataTypesNode tail;

    public TableDataTypes() {
    	
        this.head = null;
        this.tail = null;
        
    }

    public int addDatatype(String name, int type) {
    	
        TableDataTypesNode newNode = new TableDataTypesNode(name, type);

        if (head == null) {
        	
            head = newNode;
            tail = newNode;
            
            return 0;
            
        } else {
        	
            int index = 1;
            TableDataTypesNode current = head;

            // Traverse to get the index where the new node will go (end of list)
            while (current.dataTypeNextNode != null) {
            	
                current = current.dataTypeNextNode;
                index++;
                
            }

            current.dataTypeNextNode = newNode;
            tail = newNode;

            return index;
        }
        
    }

    public int removeDatatype(String dataTypeName) {
    	
        if (head == null) return -1;

        // If the head is the node to remove
        if (head.dataTypeName.equals(dataTypeName)) {
        	
            head = head.dataTypeNextNode;
            
            if (head == null) {
            	
                tail = null;
                
            }
            
            return 0;
            
        }

        // Traverse the list to find and remove the node
        TableDataTypesNode current = head;
        int index = 1;

        while (current.dataTypeNextNode != null) {
        	
            if (current.dataTypeNextNode.dataTypeName.equals(dataTypeName)) {
            	
                current.dataTypeNextNode = current.dataTypeNextNode.dataTypeNextNode;

                // Update tail if needed
                if (current.dataTypeNextNode == null) {
                	
                    tail = current;
                    
                }
                
                return index;
                
            }
            
            current = current.dataTypeNextNode;
            index++;
            
        }

        return -1; // Not found
        
    }
    
    public int getDatatypeIndex(String dataTypeName) {
    	
        TableDataTypesNode current = head;
        int index = 0;

        while (current != null) {
        	
            if (current.dataTypeName.equals(dataTypeName)) {
            	
                return index;
                
            }
            
            current = current.dataTypeNextNode;
            index++;
            
        }

        return -1; // Not found
    }
    
    public String getDatatype(int classID) {
    	
    	switch(classID) {
    	
    		case 0:
    			return "String";
    		case 1:
    			return "Character";	
    		case 2:
    			return "Integer";
    		case 3:
    			return "Double";	
    		default:
    			return "Object";
    	
    	}
    	
    }
    
    public int getSize() {
    	
    	int count = 0;
        TableDataTypesNode current = head;

        while (current != null) {
        	
            count++;
            current = current.dataTypeNextNode;
        }

        return count;
        
    }
    
    public int[] getAllDatatypeValues() {
    	
        int size = getSize();
        int[] typeValues = new int[size];

        TableDataTypesNode current = head;
        int index = 0;

        while (current != null) {
        	
            typeValues[index] = current.dataType;
            current = current.dataTypeNextNode;
            index++;
            
        }

        return typeValues;
        
    }

    @Override
    public String toString() {
    	
        if (head == null) {
        	
            return "N/A";
            
        }

        StringBuilder retStr = new StringBuilder();
        TableDataTypesNode current = head;

        while (current != null) {
        	
            retStr.append(current.dataTypeName)
                  .append(" (")
                  .append(getDatatype(current.dataType))
                  .append(")");

            if (current.dataTypeNextNode != null) {
            	
                retStr.append(", ");
                
            }

            current = current.dataTypeNextNode;
            
        }

        return retStr.toString();
    }

}
