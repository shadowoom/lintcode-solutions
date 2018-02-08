package com.algorithm.otherdatastructure;

//Hashtable chaining with linkedlist

public class HashTableImplementation {
	
	//Table size
	private static int INITIAL_SIZE = 127;
	private HashEntry[] entries = new HashEntry[INITIAL_SIZE];
	
	//compute hashcode
	public int getHashCode(String key) {
		int hashCode = key.hashCode();
		return hashCode % INITIAL_SIZE;
	}
	
	//add new entry Stringo HashTable
	public void importValue(String key, String value) {
		int hashCode = getHashCode(key);
		HashEntry newEntry = new HashEntry(key, value);
		if(entries[hashCode] == null) {
			entries[hashCode] = newEntry;
		}
		else {
			HashEntry temp = entries[hashCode];
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newEntry;
		}
	}
	
	//retrieve entry from HashTable
	public String retriveValue(String key) {
		int hashCode = getHashCode(key);
		HashEntry temp = entries[hashCode];
		if(temp != null) {
			if(temp.key == key) {
				return temp.value;
			}
			else {
				while(temp.next != null && temp.key != key) {
					temp = temp.next;
				}
				return temp.value;
			}
		}
		else {
			return null;
		}
	}
	
	//implement linked list
	public static class HashEntry {
		String key;
		String value;
		HashEntry next;
		
		public HashEntry(String key, String value) {
			this.key = key;
			this.value = value;
			this.next =null;
		}
		
		@Override
        public String toString() {
            return "[" + this.key + ", " + this.value + "]";
        }
	}
	
	@Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : entries) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
	
	private static void log(String msg) {
        System.out.println(msg);
    }
	

	public static void main(String[] args) {
		HashTableImplementation hashTable = new HashTableImplementation();
        // Put some key values.
        for(int i=0; i<127; i++) {
            final String key = String.valueOf(i);
            hashTable.importValue(key, key);
        }

        // Print the HashTable structure
        log("****   HashTable  ***");
        log(hashTable.toString());
        log("\nValue for key(17) : " + hashTable.retriveValue("17") );
	}

}
