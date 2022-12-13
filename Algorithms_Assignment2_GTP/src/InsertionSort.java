
public class InsertionSort {
	public static int basicOps = 0;
	
	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i=0; i<n; ++i) {
			System.out.print(arr[i] + " ");
			System.out.print(" ");
		}
	}
	
	public int getBasicOps() {
		return basicOps;
	}
	
	public int[] sort(int array[]) {
		int n = array.length;
		for (int i = 1; i < n; ++i) {
			basicOps++;
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
		return array;
	}	
}
