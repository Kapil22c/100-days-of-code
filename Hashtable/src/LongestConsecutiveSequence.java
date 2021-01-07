import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
//		int[] arr = {2,12,4,16,10,5,3,20,25,11,1,8,6};
		int[] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6,2,8,10,8,9,2,8,11};
		System.out.println(LCS(arr));
	}
	
	private static ArrayList<Integer> LCS(int[] arr){
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int i=0; i<arr.length;i++) {
			int prev = arr[i]-1;
			if(map.containsKey(prev)) {
				map.put(arr[i], false);
			}else {
				map.put(arr[i], true);
			}
			// if the current no. is a start of the a 
			//sequence then n+1 can not e a start 
			int next = arr[i]+1;
			if(map.containsKey(next)) {
				map.put(next, false);
			}
		}
		
		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		int maxLength = Integer.MIN_VALUE;
		int maxStartingNo = 0;
		for(int key: keys) {
			if(map.get(key) == true) {
				int pStartingNo = key;
				int count = 0;
				while(map.containsKey(pStartingNo + count)) {
					count++;
				}
				if(count>maxLength) {
					maxLength = count;
					maxStartingNo = pStartingNo;
				}
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<maxLength; i++) {
			result.add(maxStartingNo+i);
			
		}
		return result;
	}

}
