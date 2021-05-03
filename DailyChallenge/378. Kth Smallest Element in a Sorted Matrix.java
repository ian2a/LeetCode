class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (k == 1) {
            return matrix[0][0];
        } else if (k == rows * cols) {
            return matrix[rows - 1][cols - 1];
        }
        int[][] visited = new int[rows][cols];
        
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = 1;
        for (int i = 0; i < k - 1; i++) {
            Cell cur = pq.poll();
            if (cur.row + 1 < rows && visited[cur.row + 1][cur.col] == 0) {
                pq.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = 1;
            }
            if (cur.col + 1 < cols && + visited[cur.row][cur.col + 1] == 0) {
                pq.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = 1;
            }
        }
        return pq.peek().val;
    }
}

class Cell implements Comparable<Cell> {
    int row;
    int col;
    int val;
    public Cell(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public int compareTo(Cell another) {
        if (another.val == this.val) {
            return 0;
        }
        return this.val < another.val ? -1 : 1;
    }
}
