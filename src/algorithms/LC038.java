package algorithms;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
 */
public class LC038 {

    /**
     * The count-and-say sequence is the sequence of integers with the first five
     * terms as following:
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * <p>
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * <p>
     * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
     *
     * @param n - Given integer
     * @return String - Count-and-say sequence
     */
    public String countAndSay(int n) {
        int cur = 1;
        String res = "1";
        return recurse(cur, n, res);
    }

    private String recurse(int cur, int n, String res) {
        if (cur == n) {
            return res;
        }

        String s = "";
        int i = 0;
        while (i < res.length()) {
            char c = res.charAt(i);
            int count = 0;
            while (i < res.length() && c == res.charAt(i)) {
                count++;
                i++;
            }
            s += (char) (count + '0') + "" + c;
        }
        return recurse(cur + 1, n, s);
    }

}
