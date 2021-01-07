
public class SimpleHashtable {

	private StoredStudent[] hashtable;

	public SimpleHashtable() {
		hashtable = new StoredStudent[10];

	}

	public void put(String key, Student std) {
		int hashedKey = hashKey(key);
		if (occupied(hashedKey)) {
			int stopIndex = hashedKey;
			if (hashedKey == hashtable.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}
			while (occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
		}

		if (occupied(hashedKey)) {
			System.out.println("Sorry, there is already a student at position " + hashedKey);
		} else {
			hashtable[hashedKey] = new StoredStudent(key, std);
		}
	}

	public Student get(String key) {
		int hashedKey = findKey(key);
		if(hashedKey == -1) {
			return null;
		}
		return hashtable[hashedKey].std;
	}
	
	public Student remove(String key) {
		int hashedKey = findKey(key);
		if(hashedKey == -1) {
			return null;
		}
		Student std = hashtable[hashedKey].std;
		hashtable[hashedKey] = null;
		
		StoredStudent[] oldHashtable = hashtable;
		hashtable = new StoredStudent[oldHashtable.length];
		for(int i=0; i<oldHashtable.length; i++) {
			if(oldHashtable[i] != null) {
				put(oldHashtable[i].key, oldHashtable[i].std);
			}
		}
		return std;
	}

	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}

	private int findKey(String key) {
		int hashedKey = hashKey(key);
		if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}

		int stopIndex = hashedKey;
		if (hashedKey == hashtable.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}
		while (hashedKey != stopIndex && hashtable[hashedKey] != null &&
					!hashtable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashtable.length;
		}
		
		if(hashtable[hashedKey] !=null && hashtable[hashedKey].equals(key)) {
			return hashedKey;
		}else {
			return -1;
		}

	}

	private boolean occupied(int index) {
		return hashtable[index] != null;
	}

	public void printHashtable() {
		for (int i = 0; i < hashtable.length; i++) {
			if(hashtable[i] == null) {
				System.out.println("Empty");
			}else {
				System.out.println("Position "+i+": "+hashtable[i].std);				
			}
		
		}
	}

}
