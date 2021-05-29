class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
    
    private void helper(int[] candidates, int remain, int index, List<List<Integer>> res, List<Integer> temp) {
        if (remain == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = index; i < candidates.length && candidates[i] <= remain; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.add(candidates[i]);
                helper(candidates, remain - candidates[i], i + 1, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
