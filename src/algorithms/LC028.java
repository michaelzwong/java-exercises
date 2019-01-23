package algorithms;
/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC028 {
	/**
	 * Return the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 * 
	 * @param haystack - String to search in
	 * @param needle   - String of interest
	 * @return int - index of first occurrence
	 */
	public int strStr(String haystack, String needle) {
		int needleLen = needle.length();

		if (needleLen == 0)
			return 0;

		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0) && i + needleLen <= haystack.length()) {
				if (haystack.substring(i, i + needleLen).equals(needle)) {
					return i;
				}
			}
		}
		return -1;
	}
}
