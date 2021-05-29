class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, res, 1, new ArrayList<>());
        return res;
    }
    
    private void helper(int n , int k, List<List<Integer>> res, int start, List<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
                temp.add(i);
                helper(n, k, res, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
