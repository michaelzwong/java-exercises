package algorithms;

import java.util.*;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC752 {
    /**
     * You have a lock in front of you with 4 circular wheels.
     * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
     * The wheels can rotate freely and wrap around: for example we can turn '9'
     * to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
     * The lock initially starts at '0000', a string representing the state of the 4 wheels.
     * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
     * the wheels of the lock will stop turning and you will be unable to open it.
     * Given a target representing the value of the wheels that will unlock the lock,
     * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
     *
     * @param deadends - Invalid lock positions
     * @param target   - Combination to reach
     * @return int - number of moves required to reach the target combination
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet(Arrays.asList(deadends));
        boolean[] visited = new boolean[10000];
        visited[0000] = true;
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        // Levels of the BFS
        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String lockPosition = queue.poll();
                if (deadendsSet.contains(lockPosition)) {
                    size--;
                    continue;
                }
                if (lockPosition.equals(target)) {
                    return levels;
                }
                StringBuilder sb = new StringBuilder(lockPosition);
                for (int i = 0; i < 4; i++) {
                    char curr = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (curr == '9' ? 0 : curr - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (curr == '0' ? 9 : curr - '0' - 1) + sb.substring(i + 1);
                    if (!deadendsSet.contains(s1) && !visited[Integer.valueOf(s1)]) {
                        queue.offer(s1);
                        visited[Integer.valueOf(s1)] = true;
                    }

                    if (!deadendsSet.contains(s2) && !visited[Integer.valueOf(s2)]) {
                        queue.offer(s2);
                        visited[Integer.valueOf(s2)] = true;
                    }
                }
                size--;
            }
            levels++;
        }
        return -1;
    }
}
