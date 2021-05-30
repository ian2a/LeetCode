class Solution {
    
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        res = new ArrayList<>();
        dfs(n, 0, new ArrayList<>());
        return res;
    }
    
    private boolean validate(int x, int y, int n) {
        return !col[y] && !diag1[x + y] && !diag2[x - y + n - 1];
    }
    
    private void update(int x, int y, int n, boolean value) {
        col[y] = value;
        diag1[x + y] = value;
        diag2[x - y + n - 1] = value;
    }
    
    private void dfs(int n, int x, List<Integer> path) {
        if (x == n) {
            res.add(convert2board(path, n));
            return;
        }
        for (int y = 0; y < n; y++) {
            if (validate(x, y, n)) {
                update(x, y, n, true);
                path.add(y);
                dfs(n, x + 1, path);
                update(x, y, n, false);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private List<String> convert2board(List<Integer> path, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[path.get(i)] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
