class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, res, "");
        return res;
    }
    
    private void helper(int left, int right, List<String> res, String temp) {
        if (left == 0 && right == 0) {
            res.add(temp);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            helper(left - 1, right, res, temp + "(");
        }
        if (right > 0) {
            helper(left, right - 1, res, temp + ")");
        }
    }
}
