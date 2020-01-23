package algorithms;


/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC875 {

    /**
     * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.
     * The guards have gone and will come back in H hours.
     *
     * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K
     * bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any
     * more bananas during this hour.
     *
     * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
     *
     * Return the minimum integer K such that she can eat all the bananas within H hours.
     *
     * @param int[] piles - the pile of bananas Koko is eating from
     * @param int H - the number of hours before the guards come back
     * @return int - the slowest possible eating rate
     */
    public int minEatingSpeed(int[] piles, int H) {
        // We want to find the minimum number of bananas Coco has to eat per hour such that she finishes the bananas in H hours
        // Get the length of the array
        int length = piles.length, lastIndex = piles.length-1;
        int max = piles[0];
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        // Upper and lower bounds of how many bananas Koko eats in an hour
        int upper = max, lower = 1;
        int slowest = upper;
        while(lower <= upper) {
            int middle = (upper-lower)/2 + lower;
            if(canEat(piles, middle, H)) {
                slowest = middle;
                upper = middle-1;
            } else {
                lower = middle+1;
            }
        }
        return slowest;
    }
    private boolean canEat(int[] piles, int rate, int H) {
        for(int i = 0; i < piles.length; i++) {
            H -= Math.ceil((double)piles[i]/rate);
            if(H < 0) {
                return false;
            }
        }
        return true;
    }
}
