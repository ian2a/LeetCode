class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return recursionPathSum(root, targetSum, prefixSumCount, 0);
    }
    
    private int recursionPathSum(TreeNode root, int targetSum, Map<Integer, Integer> prefixSumCount, int curSum) {
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        curSum += root.val;
        
        res += prefixSumCount.getOrDefault(curSum - targetSum, 0);
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);
        
        res += recursionPathSum(root.left, targetSum, prefixSumCount, curSum);
        res += recursionPathSum(root.right, targetSum, prefixSumCount, curSum);
        
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);
        
        return res;
    }
}
