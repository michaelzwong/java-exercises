package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC074 {

    /**
     * Write an efficient algorithm that searches for a value in an m x n
     * matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the
     * previous row.
     *
     * @param matrix - 2D array to search
     * @param target - number to find
     * @return boolean - whether or not the number is found
     */
    public boolean searchMatrix(int[][] matrix, int target) {
       if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return false;
       }
       int topRow = 0, bottomRow = matrix.length-1;
       int leftMost = 0, rightMost = matrix[0].length-1;
       
       // Binary search to find which row the target is contained in
       while(topRow <= bottomRow) {
           int middleRow = (bottomRow - topRow)/2 + topRow;
           if(target < matrix[middleRow][leftMost]) {
               bottomRow = middleRow-1;
           } else if(target > matrix[middleRow][rightMost]) {
               topRow = middleRow+1;
           } else {
               return findTarget(matrix[middleRow], target);
           }
       }
       return false;
    }
    // Find the target number in an array
    private boolean findTarget(int[] arr, int target) {
       int left = 0;
       int right = arr.length-1;
       while(left <= right) {
           int middle = (right-left)/2 + left;
           if(target > arr[middle]) {
               left = middle + 1;
           } else if(target < arr[middle]) {
               right = middle - 1;
           } else {
               return true;
           }
       }
       return false;
    }
}
