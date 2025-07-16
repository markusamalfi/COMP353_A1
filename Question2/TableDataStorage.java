public class TableDataStorage {

    private class TableDataStorageNode {
    	
        Object data;
        TableDataStorageNode dataStorageNextNode;

        TableDataStorageNode(Object data) {
        	
            this.data = data;
            this.dataStorageNextNode = null;
            
        }
        
    }

    private TableDataStorageNode head;
    private TableDataStorageNode tail;

    public TableDataStorage() {
    	
        this.head = null;
        this.tail = null;
        
    }
    
    // Add data value to the end of the list (with value inputted)
    public void addDataValue(Object value) {
    	
        TableDataStorageNode newNode = new TableDataStorageNode(value);

        if (head == null) {
        	
            head = newNode;
            tail = newNode;
            
        } else {
        	
            tail.dataStorageNextNode = newNode;
            tail = newNode;
            
        }
        
    }
    
    public boolean removeDataAt(int index) {
    	
        if (head == null || index < 0) {
        	
        	return false;
        
        }

        if (index == 0) {
        	
            head = head.dataStorageNextNode;
            
            if (head == null) { //For case where there's one data entry
            	
                tail = null;
                
            }
            
            return true;
            
        }

        TableDataStorageNode current = head;
        TableDataStorageNode nodeToRemove = null;
        int i = 0;

        while (current != null && current.dataStorageNextNode != null) {
        	
            if (i == index - 1) {
            	
                nodeToRemove = current.dataStorageNextNode;
                current.dataStorageNextNode = nodeToRemove.dataStorageNextNode;

                if (nodeToRemove == tail) {
                	
                    tail = current;
                    
                }

                return true;
            }

            current = current.dataStorageNextNode;
            i++;
            
        }

        return false; // Index out of bounds
    }

    // Get data at a specific index
    public Object getDataAt(int index) {
    	
        TableDataStorageNode current = head;
        int i = 0;

        while (current != null) {
        	
            if (i == index) {
            	
                return current.data;
                
            }
            
            current = current.dataStorageNextNode;
            i++;
            
        }

        return null; // Index out of bounds
        
    }
    
    public boolean updateDataAt(int index, Object newValue) {
    	
        if (index < 0) return false;

        TableDataStorageNode current = head;
        int i = 0;

        while (current != null) {
        	
            if (i == index) {
            	
                current.data = newValue;
                return true;
                
            }
            
            current = current.dataStorageNextNode;
            i++;
            
        }

        return false; // Index out of bounds
    }
    
    

    @Override
    public String toString() {
    	
        StringBuilder result = new StringBuilder("[");
        TableDataStorageNode current = head;

        while (current != null) {
        	
            result.append(current.data);

            if (current.dataStorageNextNode != null) {
            	
                result.append(", ");
                
            }

            current = current.dataStorageNextNode;
        }

        result.append("]");
        return result.toString();
        
    }
    
}

