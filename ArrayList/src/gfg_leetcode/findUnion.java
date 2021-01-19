package gfg_leetcode;

import java.util.HashMap;

public class findUnion {
	
	public static int unionFind(int[] a, int[] b) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i:a) {
			if(map.containsKey(a[i])) {
				continue;
			}
			map.put(a[i], true);
		}
		for(int j:b) {
			if(map.containsKey(b[j])) {
				continue;
			}
			map.put(b[j], true);
		}
		return map.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,5,4,4,5,6,1,2,3};
		int[] arr2 = {1,5,6,4,8,9,10};
		
		System.out.println(unionFind(arr1, arr2));
	}

}
