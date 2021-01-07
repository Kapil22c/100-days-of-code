
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student("Kapil", "bavisiya", 123);
		Student s2 = new Student("Jimmy", "Neesham", 443);
		Student s3 = new Student("Kane", "Williamson", 23);
		Student s4 = new Student("Jesse", "Rydor", 453);
		Student s5 = new Student("Danial", "vettory", 785);
		
		ChainedHashtable ht = new ChainedHashtable();
		ht.put("kapil", s1);
		ht.put("jimmy", s2);
		ht.put("kane", s3);
		ht.put("jesse", s4);
		ht.put("danial", s5);
		
		ht.printHashtable();
		
//		System.out.println("retrieve key kapil: "+ ht.get("kapil"));
//
//		ht.remove("jimmy");
//		ht.remove("kane");
//		ht.printHashtable();
	}

}
