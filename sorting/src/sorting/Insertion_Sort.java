package sorting;

public class Insertion_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12,15,3,22,5};
		
		sort(arr, arr.length);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	private static void sort(int[] arr, int n) {
		for(int i=1; i<n;i++) {
			int key = arr[i];
			System.out.println("key: "+ key);
			int j = i-1;
			System.out.println("position: "+j);
			System.out.println("array of j: "+arr[j]);
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				System.out.println("In while j: "+j);
				System.out.println("In while j+1: "+j+1);
				j = j-1;
				System.out.println("In while key: "+key);
				
			}
			arr[j+1]=key;
			System.out.println("next element: "+ arr[j+1]);
		}
	}

}
