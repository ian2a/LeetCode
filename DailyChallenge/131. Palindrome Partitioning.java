class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] chars = s.toCharArray();
        dfs(chars, 0, res, new ArrayList<>());
        return res;
    }
    
    private void dfs(char[] chars, int index, List<List<String>> res, List<String> path) {
        if (index == chars.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            if (isPalindrome(chars, index, i)) {
                path.add(new String(chars, index, i - index + 1));
                dfs(chars, i + 1, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
