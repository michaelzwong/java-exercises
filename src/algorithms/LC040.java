package algorithms;

import java.util.List;
import java.util.ArrayList;

/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC039 {

	/**
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
     * find all unique combinations in candidates where the candidate numbers sums to target.
     * Each number in candidates may only be used once in the combination.
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
	 * 
	 * @param candidates - Array of numbers
	 * @return List<List<Integer>> - different combinations possible.
	 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        
        findCombinationSum(candidates, target, new ArrayList<Integer>(), result, 0);
        
        return result;
    }
    
    private void findCombinationSum(int[] candidates, int target, List<Integer> cur, List<List<Integer>> result, int index) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            cur.add(candidates[i]);
            findCombinationSum(candidates, target - candidates[i], cur, result, i+1);
            cur.remove(cur.size() - 1);
        }
    }
}