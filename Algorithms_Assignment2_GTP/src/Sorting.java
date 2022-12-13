import java.util.HashMap;
import java.util.Map;

public class Sorting {
	public static int size; // choose the size of the list
	int conversion = 1000000; // conversion factor for nanoTime
	public static Map<String, Map> times = new HashMap<String, Map>(); // map to store runtimes
	public static Map<Integer, Double> insertion = new HashMap<Integer, Double>();
	public static Map<Integer, Double> shell = new HashMap<Integer, Double>();
	
	public Sorting(int n) {
		// constructor
		size = n;
	}
	
	public int[] ShellSort(int[] array) {
		// Shell Sorting algorithm
		ShellSort sorted = new ShellSort();
		
		int[] sortedArray = sorted.sort(array);
		
		double start = System.nanoTime();
	    
		sortedArray = sorted.sort(array);
	    
	    double end = System.nanoTime();
	    // add runtime to map
	    shell.put(size, (end-start)/conversion);
	    System.out.println("# basic operations: "+sorted.getBasicOps());
	    AddTime("Shell", shell);
	    
		return sortedArray;
	}
	
	public int[] InsertionSort(int[] array) {
		// Insertion Sorting algorithm
		InsertionSort sorted = new InsertionSort();
		
		int[] newSorted = sorted.sort(array);
		
		double start = System.nanoTime();
		
		newSorted = sorted.sort(array);
		
		double end = System.nanoTime();
		insertion.put(size, (end-start)/conversion);
	    System.out.println("# basic operations: "+sorted.getBasicOps());
	    AddTime("Insertion", insertion);
	    
		return newSorted;
	}
	
	public void printArray(int arr[]) {
		// print out contents of array
		int n = arr.length;
		for (int i=0; i<n; ++i) {
			System.out.print(arr[i] + " ");
			System.out.print(" ");
		}
	}
	
	public void AddTime(String key, Map value) {
		// add each key value pair to the map
		times.put(key, value);
	}
 	
	public static void main(String[] args) {
		int[] sizes = { 10, 100, 1000 }; // testing with different sizes
		int j = 0;
		while(j < sizes.length) {
			// this code runs everything
			// generates a new list of size n
			// then sort using Insertion and Shell Sort
			UniqueRandom unique = new UniqueRandom(sizes[j]);
		    Sorting newSort = new Sorting(sizes[j]);
		    int n = unique.getList().size();
		    int arr[] = new int[n];
		    int i = 0;
		    for (int x : unique.getList()) // convert set into array
		    	arr[i++] = x;
		    
		    System.out.println(String.format("-------- Unsorted List (%d) --------",sizes[j]));
		    System.out.println(" ");
		    System.out.println("Size -> "+sizes[j]);
		    newSort.printArray(arr); // print original array
		    System.out.println(" ");
		    System.out.println(" ");
		    System.out.println(String.format("-------- Insertion Sort (%d) --------",sizes[j]));
		    newSort.printArray(newSort.InsertionSort(arr)); // print insertion sorted array
		    System.out.println(" ");
		    System.out.println(" ");
		    System.out.println(String.format("-------- Shell Sort (%d) --------",sizes[j]));
		    newSort.printArray(newSort.ShellSort(arr)); // print shell sorted array
		    System.out.println(" ");
		    System.out.println(" ");
		    j++;
		}
		// display map of runtimes
		System.out.println("Times: ");
		for (Map.Entry<String,Map> entry : times.entrySet())
			if(entry.getKey().equals("Insertion")) {
				System.out.println(entry.getKey());
				for (Map.Entry<Integer,Double> entry2 : insertion.entrySet())
					System.out.println("Size: "+entry2.getKey() +" |-> runtime = " + entry2.getValue());
			} else {
				System.out.println(entry.getKey());
				for (Map.Entry<Integer,Double> entry2 : shell.entrySet())
					System.out.println("Size: "+entry2.getKey() +" |-> runtime = " + entry2.getValue());
			}
	}
}
