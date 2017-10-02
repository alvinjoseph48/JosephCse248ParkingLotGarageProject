package model;

public class HashTable {
	
	private Vehicle[] hashArray;  // array holds hash table
	private int arraySize;
	private Vehicle nonItem;  // for deleted items
	
	public HashTable(int size) {
		arraySize = size;
		hashArray = new Vehicle[arraySize];
		nonItem = new Vehicle("", ""); // deleted item key is -1
	}	
	public int hashFunc(String key) {
		return key.hashCode();  // hash function
		
	}
	
	public void insert(Vehicle item) {
		// assume table is not full
		String key = item.getLicense();	// extract the key
		int hashVal = hashFunc(key);	// hash the key until empty cell or -1
		while(hashArray[hashVal] != null ) {
			++hashVal;
			hashVal %= arraySize;  // wraparound if necessary
		}
		hashArray[hashVal] = item; 	// insert item
	}  // end insert
	
	public Vehicle delete(String key) {
		int hashVal = hashFunc(key);	//hash the key
		while (hashArray[hashVal] != null) {  // until empty cell
			if(hashArray[hashVal].getLicense() == key) { //found the key?
				Vehicle temp = hashArray[hashVal];  // save item
				hashArray[hashVal] = nonItem;		// delete item
				return temp;			// return item
			}
			++hashVal;			// go to next cell
			hashVal %= arraySize;	// wraparound if necessary
		}
		return null;
	}	// end delete
	
	public Vehicle find(String key) { // find item with key
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null)  {	// until empty cell;
			if(hashArray[hashVal].getLicense() == key)  { // found key?
				return hashArray[hashVal];
			}
			++hashVal;
			hashVal %= arraySize;  // wraparound if necessary
		}
		return null;
	}
}

