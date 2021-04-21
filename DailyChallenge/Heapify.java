public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }

    private void siftDown(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int child = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[child] > A[k * 2 + 2]) {
                child = k * 2 + 2;
            }
            if (A[child] >= A[k]) {
                break;
            }
            int temp = A[child];
            A[child] = A[k];
            A[k] = temp;

            k = child;
        }
    }
}
