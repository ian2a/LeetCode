class Solution {
    public int[] findOrder(int num, int[][] pres) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[num];
        for (int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : pres) {
            graph.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        int[] res = new int[num];
        int index = 0;
        for (int i = 0; i < num; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                res[index++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int next : graph.get(course)) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.offer(next);
                    res[index++] = next;
                }
            }
        }
        
        return index == num ? res : new int[0];
    }
}
