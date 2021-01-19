package gfg_leetcode;

public class sort012 {
	public static void sortColors(int[] a) {
        int low = 0;
        int mid =0;
        int high = a.length -1;
        while(mid<=high){
            if(a[mid] == 0){
                int temp = a[mid];
                a[mid] = a[low];
                a[low]= temp;
                mid++;
                low++;
            }
            else if(a[mid]==1){
                mid++;
            }
            else {
                int t = a[high];
                a[high]= a[mid];
                a[mid]= t;
                high--;
            }
        }
        for (int element: a) {
            System.out.print(element+" ");
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,2,2,0,0,1,0,2,1,0,0,2,1};
		sortColors(arr);
		
	}

}
