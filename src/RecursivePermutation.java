
/**
 * Recursive string permutation printer.
 * @author michaelwong
 *
 */
public class RecursivePermutation {
	
	public static void permutation(String str) {
		permutation(str, "");
	}
	
	public static void permutation(String str, String prefix) {
		int n = str.length();
		if (n == 0) {
			System.out.println(prefix);
		} else {
			for(int i = 0; i < n; i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				permutation(rem, prefix + str.charAt(i));
			}
		}
	}
}
