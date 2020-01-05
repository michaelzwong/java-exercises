package algorithms;

/**
 * LeetCode Hard.
 *
 * @author michaelwong
 */
public class LC057 {

    /**
     * Given a set of non-overlapping intervals, insert a new interval into the
     * intervals (merge if necessary).
     *
     * You may assume that the intervals were initially sorted according to
     * their start times.
     *
     * @param intervals - array of intervals
     * @param newInterval - the new interval to add
     * @return int[][] - merged array of overlapping intervals
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
       if(intervals.length == 0) {
           return new int[][] {newInterval};
       }
       if(newInterval.length == 0) {
           return intervals;
       }
       Stack<int[]> stack = new Stack<int[]>();
       // 1. We need to find the index to insert the new interval
       // 2. Insert the new interval and merge if possible
       // 2. For all subsequent intervals, check if there can be a merge with the previous interval
       int i = 0;
       while(i < intervals.length && newInterval[0] > intervals[i][0]) {
           stack.push(intervals[i]);
           i++;
       }

       if(i > 0 && newInterval[0] <= stack.peek()[1]) {
           int[] popped = stack.pop();
           int[] merged = new int[]{popped[0], Math.max(popped[1], newInterval[1])};
           stack.push(merged);
       } else {
           stack.push(newInterval);
       }

       while(i < intervals.length) {
           // Merge possible
           if(intervals[i][0] <= stack.peek()[1]) {
               int[] popped = stack.pop();
               int[] merged = new int[]{popped[0], Math.max(popped[1], intervals[i][1])};
               stack.push(merged);
           } else {
               stack.push(intervals[i]);
           }
           i++;
       }

       return stack.toArray(new int[stack.size()][]);
    }
}
