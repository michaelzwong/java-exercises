package algorithms;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
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
        // Error cases
        if (needle.length() == 0) {
            return 0;
        }
        int[] aux = getAuxArray(needle);
        // Counter for Haystack
        int i = 0;
        // Counter for Needle
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            // The letters from haystack and needle don't match
            if (haystack.charAt(i) != needle.charAt(j)) {
                if (j == 0) {
                    // Move to next letter in haystack
                    i++;
                } else {
                    // Use aux array to determine where to match next
                    j = aux[j - 1];
                }
            } else {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            }
        }

        return -1;
    }

    // KMP algorithm
    private int[] getAuxArray(String pattern) {
        int[] aux = new int[pattern.length()];
        int i = 0;
        int j = 1;
        while (j < pattern.length()) {
            // Prefix is equal to suffix
            if (pattern.charAt(i) == pattern.charAt(j)) {
                aux[j] = ++i;
                j++;
                // Prefix is not equal to suffix, check if there exists a prefix before i that is equal
                // to suffix
            } else if (pattern.charAt(i) != pattern.charAt(j) && i != 0) {
                i = aux[i - 1];
                // No prefix equal to suffix possible
            } else {
                aux[j] = 0;
                j++;
            }
        }
        return aux;
    }
}
