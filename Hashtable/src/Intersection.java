import java.util.ArrayList;
import java.util.HashMap;

public class Intersection {

	public static void main(String[] args) {
		
		int[] a1 = {5,5,7,7,2,5};
		int[] a2 = {6,7,9,5,5,5,5};
		System.out.println(intersect(a1, a2));
	}
	
	private static ArrayList<Integer> intersect(int[] a1, int[] a2){
		
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<a1.length; i++) {
			
			if(map.containsKey(a1[i])) {
				map.put(a1[i], map.get(a1[i]) + 1);
			}else {
				map.put(a1[i], 1);
				
			}
		}
//		System.out.println(map.toString());
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<a2.length;i++) {
			if(map.containsKey(a2[i])) {
				int freq = map.get(a2[i]);	
				freq--;
				map.put(a2[i], freq);
//				System.out.println(freq);
				
				if(freq>=0) {
					result.add(a2[i]);
					
				}
				
			}
		}
		
		return result;
//		for(int i=0; i<a2.length; i++) {
//			if(map.containsKey(a2[i])) {
//				int freq = map.get(a2[i]);
//				freq--;
//				if(freq == 0) {
//					map.remove(a2[i]);
//				}else {
//					map.put(a2[i], freq);
//				}	
//				System.out.print(a2[i]+" ");
//			}
//			
//		}
		
	}

}
