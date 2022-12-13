import java.security.SecureRandom;
import java.util.Set;
import java.util.HashSet;

public class UniqueRandom {
	static int size;
	Set<Integer> generatedNumbers = new HashSet<>(); // using a Set because they don't allow duplicate values.
	
	public UniqueRandom(int n) {
		size=n;
		SecureRandom random = new SecureRandom();
		int randomRange = size+1000;
		while (generatedNumbers.size() < size) {
			int randomNumber = random.nextInt(randomRange) + 1;
			generatedNumbers.add(randomNumber);
		}
	}
	
	public Set<Integer> getList() {
		return generatedNumbers;
	}
	
	public static void main(String[] args) {
	    UniqueRandom unique = new UniqueRandom(25);
	    //System.out.println(unique.getList());
	}
}