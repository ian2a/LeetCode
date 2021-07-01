class Solution {
    public int minDistance(String one, String two) {
        int m = one.length();
        int n = two.length();
        int[][] distance = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    int replace = distance[i - 1][j - 1];
                    int delete = distance[i - 1][j];
                    int insert = distance[i][j - 1];
                    distance[i][j] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
        
        return distance[m][n];
    }
}
