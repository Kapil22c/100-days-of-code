import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {
	
	private LinkedList<StoredStudent>[] hashtable;
	
	public ChainedHashtable() {
		hashtable = new LinkedList[10];
		for(int i=0; i<hashtable.length ;i++) {
			hashtable[i] = new LinkedList<StoredStudent>();
		}
	}
	
	public void put(String key, Student std) {
		int hashedKey = hashKey(key);
		hashtable[hashedKey].add(new StoredStudent(key, std));
	}
	
	public Student get(String key) {
		int hashedKey = hashKey(key);
		ListIterator<StoredStudent> iterator = hashtable[hashedKey].listIterator();
		StoredStudent storedstd = null;
		while(iterator.hasNext()) {
			storedstd= iterator.next();
			if(storedstd.key.equals(key)) {
				return storedstd.std;
			}
		}
		
		return null;
	}
	
	public Student remove(String key) {
		int hashedKey = hashKey(key);
		ListIterator<StoredStudent> iterator = hashtable[hashedKey].listIterator();
		StoredStudent storedstd = null;
		int index = -1;
		while(iterator.hasNext()) {
			storedstd= iterator.next();
			index++;
			if(storedstd.key.equals(key)) {
//				return storedstd.std;
				break;
			}
		}
		if(storedstd == null) {
			return null;
		}else {
			hashtable[hashedKey].remove(index);
			return storedstd.std;
		}
	}
	
	private int hashKey(String key) {
//		return key.length() % hashtable.length;
		return Math.abs(key.hashCode() % hashtable.length);
	}
	
	public void printHashtable() {
		 for(int i=0; i<hashtable.length; i++) {
			 if(hashtable[i].isEmpty()) {
				 System.out.println("Position "+i+": Empty");
			 }
			 else {
				 System.out.print("Position "+i+": ");
				 ListIterator<StoredStudent> iterator = hashtable[i].listIterator();
				 while(iterator.hasNext()) {
					 System.out.print(iterator.next().std);
					 System.out.print("->");
				 }
				 System.out.println("null");
			 }
		 }
	}

}
