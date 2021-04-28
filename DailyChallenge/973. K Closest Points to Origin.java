class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> getDist(b) - getDist(a));
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        while(k > 0) {
            res[--k] = pq.poll();
        }
        
        return res;
    }
    
    private int getDist(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
