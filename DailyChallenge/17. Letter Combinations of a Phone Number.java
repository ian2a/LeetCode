class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits, map, res, 0, new StringBuilder());
        return res;
    }
    
    private void helper(String digits, String[] map, List<String> res, int index, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
				// 看当前有哪些字母可以用，比如abc
        int num = digits.charAt(index) - '0';
        String mapString = map[num];
        
        for (int i = 0; i < mapString.length(); i++) {
            sb.append(mapString.charAt(i));
            helper(digits, map, res, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
