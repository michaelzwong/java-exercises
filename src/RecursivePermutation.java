
/**
 * Practice Algorithm.
 * 
 * @author michaelwong
 *
 */
public class RecursivePermutation {

	/**
	 * Recursive string permutation printer.
	 * 
	 * @param str - Word to permute
	 */
	public static void permutation(String str) {
		permutation(str, "");
	}

	/**
	 * Recursive string permutation printer.
	 * 
	 * @param str    - Permute
	 * @param prefix - Prefix to add on to
	 */
	public static void permutation(String str, String prefix) {
		int n = str.length();
		if (n == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				permutation(rem, prefix + str.charAt(i));
			}
		}
	}
}
