class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    markNeighbors(i, j, grid, visited);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void markNeighbors(int i, int j, char[][] grid, boolean[][] visited) {
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        visited[i][j] = true;
        Queue<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(i, j));
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = cell.x + dirX[k]; // 注意这里是cell.x， 不能直接用i
                int newY = cell.y + dirY[k];
                if (isValid(newX, newY, grid, visited)) {
                    queue.offer(new Cell(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
    
    private boolean isValid(int x, int y, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (x >= m || x < 0 || y < 0 || y >= n) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (grid[x][y] == '0') {
            return false;
        }
        return true;
    }
}

class Cell {
    int x;
    int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
