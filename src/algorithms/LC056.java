package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC056 {

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * @param intervals - array of intervals
     * @return int[][] - merged array of overlapping intervals
     */
    public int[][] merge(int[][] intervals) {
       if(intervals.length <= 1) {
           return intervals;
       }
       // Ascending priority of first number in each array of intervals
       PriorityQueue<int[]> pq = new PriorityQueue<int[]>((arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
       for(int[] interval : intervals) {
           pq.offer(interval);
       }
       Stack<int[]> stack = new Stack<int[]>();
       stack.push(pq.poll());
       while(!pq.isEmpty()) {
           int[] polled = pq.poll();
           int[] peeked = stack.peek();
           if(polled[0] <= peeked[1]) {
               int[] popped = stack.pop();
               stack.push(new int[]{popped[0], Math.max(popped[1], polled[1])});
           } else {
               stack.push(polled);
           }
       }
       return stack.toArray(new int[stack.size()][]);
    }
}
