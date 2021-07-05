class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] up = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                    up[i][j] = i == 0 ? 1 : up[i - 1][j] + 1;
                }
            }
        }
        
        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Math.min(left[i][j], up[i][j]);
                while (min > max) {
                    if (left[i - min + 1][j] >= min && up[i][j - min + 1] >= min) {
                        max = min;
                    }
                    min--;
                }
            }
        }
        return max * max;
    }
}
