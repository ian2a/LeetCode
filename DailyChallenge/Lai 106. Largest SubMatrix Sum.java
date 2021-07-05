public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < m; i++) {
      int[] preSum = new int[n];
      for (int j = i; j < m; j++) {
        addRows(preSum, matrix[j]);
        max = Math.max(max, maxSubArraySum(preSum));
      }
    }
    return max;
  }

  private void addRows(int[] preSum, int[] array) {
    for (int i = 0; i < preSum.length; i++) {
      preSum[i] += array[i];
    }
  }

  private int maxSubArraySum(int[] array) {
    int cur = array[0];
    int max = array[0];

    for (int i = 1; i < array.length; i++) {
      cur = Math.max(cur + array[i], array[i]);
      max = Math.max(cur, max);
    }
    return max;
  }
}
