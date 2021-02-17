public class Solution {
    // DFS 
    public int count = 0;
    public int countArrangement(int n) {
        int[] res  = new int[n];
        helper(res, n);
        return count;
    }
    
    private void helper(int[] res, int n) {
        if (n == 0) {
            count++;
            return;
        }
        
        for (int i = 0; i < res.length; ++i) {
            if (res[i] == 0 && (n % (i+1) == 0 || (i+1) % n == 0)) {
                res[i] = n;
                helper(res, n - 1);
                res[i] = 0;
            }
        }
    }
}