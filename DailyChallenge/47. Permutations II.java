class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, res, new ArrayList<>());
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                } else {
                    temp.add(nums[i]);
                    visited[i] = true;
                    dfs(nums, visited, res, temp);
                    temp.remove(temp.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
