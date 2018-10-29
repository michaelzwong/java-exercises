
/**
 * Test classes and methods from here.
 * 
 * @author michaelwong
 *
 */
public class Main {
	/**
	 * Main Function.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        int[] nums = new int[] {1};
        
        String paren = "{[][][][]}";
        String paren2 = "[][][][[][]]][";
        
        System.out.println(Parentheses.isValidStack(paren2));
        
    }
}
