import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC022 {
	/**
	 * Given n pairs of parentheses, write a function to generate all combinations
	 * of well-formed parentheses.
	 * 
	 * @param n - The number of pairs of parentheses
	 * @return List<String> - List of all the combinations.
	 */
	public List<String> generateParenthesis(int n) {
		
		Queue<String> list = new LinkedList<String>();
		
		recurse(list, 0, n);
		
		return new ArrayList<String>(list);
	}
	
	private void recurse(Queue<String> list, int curDepth, int depth) {
		
		// Base case
		if(curDepth == 0) {
			list.offer("");
			recurse(list, ++curDepth, depth);
		}
		else if(curDepth <= depth) {
			
			int size = list.size();
						
			int i = 0;
			
			while(i < size) {
				String s = list.poll();
				
				String a = "()" + s;
				String b = "(" + ")";
				
				list.offer(a);
				list.offer(b);
				
				if(i > 0) {
					String c = s + "()";
					list.offer(c);
				}
                i++;
			}
			
			recurse(list, ++curDepth, depth);
			
		}
        				
		return;
	}
}
