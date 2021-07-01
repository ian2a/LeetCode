class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] length = new int[m][n];
        int maxLen = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // init top row and leftmost col
                if (i == 0 || j == 0) {
										// 是'0' 就填0, 是'1'就填1
                    length[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    length[i][j] = Math.min(length[i - 1][j - 1], Math.min(length[i][j - 1], length[i - 1][j])) + 1;
                }
                maxLen = Math.max(maxLen, length[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}
