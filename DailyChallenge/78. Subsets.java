class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, res, subset);
        return res;
    }
    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            
            // next level
            dfs(nums, i + 1, res, subset);
            // backtrack
            subset.remove(subset.size() - 1);
        }
    }
}
