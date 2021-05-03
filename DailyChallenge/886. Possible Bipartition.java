class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[N];
        Arrays.setAll(graph, element -> new ArrayList<>());
        for (int[] d : dislikes) {
            graph[d[0] - 1].add(d[1] - 1);
            graph[d[1] - 1].add(d[0] - 1);
        }
        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0 && !valid(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean valid(List<Integer>[] graph, int[] colors, int color, int node) {
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
