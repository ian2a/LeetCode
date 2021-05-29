class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
    private void helper(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> temp) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
                temp.add(candidates[i]);
                helper(candidates, target - candidates[i], i, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
