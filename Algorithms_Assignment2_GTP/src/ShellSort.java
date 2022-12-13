
public class ShellSort {
	public static int basicOps = 0;
	
	public ShellSort() {
		basicOps = 0;
	}
	
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
	
	public int[] sort(int arr[]) {
		int n = arr.length;
		for(int gap = n/2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = arr[i];
				int j = i;
				while (j >= gap && arr[j - gap] > temp) {
					arr[j] = arr[j - gap];
	                j -= gap;
	            }
				arr[j] = temp;
				basicOps++;
			}
		}
		return arr;
	}	
}
