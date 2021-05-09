public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] des) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Pos> queue = new PriorityQueue<>((p1, p2) -> p1.step - p2.step);
        queue.offer(new Pos(start[0], start[1], 0));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();
            if (cur.x == des[0] && cur.y == des[1]) {
                return cur.step;
            }
            if (visited[cur.x][cur.y]) {
                continue;
            }
            visited[cur.x][cur.y] = true;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x;
                int ny = cur.y;
                int step = cur.step;
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dx[dir];
                    ny += dy[dir];
                    step++;
                }
                nx -= dx[dir];
                ny -= dy[dir];
                step--;
                if (!visited[nx][ny]) {
                    queue.offer(new Pos(nx, ny, step));
                }
            }
        }
        return -1;
    }
}

class Pos {
    int x;
    int y;
    int step;
    public Pos(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
