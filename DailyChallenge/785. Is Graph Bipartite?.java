class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !valid(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean valid(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int nei : graph[node]) {
            if (!valid(graph, colors, -color, nei)) {
                return false;
            }
        }
        return true;
    }
}
