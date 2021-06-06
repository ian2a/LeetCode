class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, boolean[][] visited, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int dir = 0; dir < 4; dir++) {
            if (search(board, word, visited, index + 1, i + dx[dir], j + dy[dir])) {
                return true;
            }
        }
        
        visited[i][j] = false;
        return false;
    }
}
