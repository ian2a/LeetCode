// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> getDist(b) - getDist(a));
//         for (int[] point : points) {
//             pq.offer(point);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }
//         int[][] res = new int[k][2];
//         while(k > 0) {
//             res[--k] = pq.poll();
//         }
        
//         return res;
//     }
    
//     private int getDist(int[] a) {
//         return a[0] * a[0] + a[1] * a[1];
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;
        while (left <= right) {
            int mid = partition(points, left, right);
            if (mid == k) {
                break;
            } else if (mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[right];
        int end = right - 1;
        while (left <= end) {
            if (getDist(points[left]) <= getDist(pivot)) {
                left++;
            } else if (getDist(points[end]) >= getDist(pivot)) {
                end--;
            } else {
                swap(points, left, end);
                left++;
                end--;
            }
        }
        swap(points, left, right);
        return left;
    }
    
    private int getDist(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
