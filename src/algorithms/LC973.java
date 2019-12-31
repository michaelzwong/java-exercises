package algorithms;

import java.util.*;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC973 {

    /**
     * We have a list of points on the plane.
     * Find the K closest points to the origin (0, 0).
     * (Here, the distance between two points on a plane is the Euclidean distance.)
     * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
     * <p>
     * Return the number of good subarrays of A.
     *
     * @param points[][] - array of points
     * @param K          - number of closet points
     * @return int[][] - Array of K closest points
     */
    public int[][] kClosest(int[][] points, int K) {
        // We use a max heap to keep the K smallest points on the plane
        PriorityQueue<int[]> kClosestPoints = new PriorityQueue<int[]>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return (int) (Math.pow(point2[0], 2) + Math.pow(point2[1], 2)) - (int) (Math.pow(point1[0], 2) + Math.pow(point1[1], 2));
            }
        });

        for (int[] point : points) {
            if (kClosestPoints.size() < K) {
                kClosestPoints.offer(point);
            } else {
                int[] largestInK = kClosestPoints.peek();
                if (Math.pow(largestInK[0], 2) + Math.pow(largestInK[1], 2) > Math.pow(point[0], 2) + Math.pow(point[1], 2)) {
                    kClosestPoints.poll();
                    kClosestPoints.offer(point);
                }
            }
        }

        return kClosestPoints.toArray(new int[K][]);
    }
}
