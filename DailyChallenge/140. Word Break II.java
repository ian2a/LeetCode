class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, set, memo);
    }
    
    private List<String> dfs(String s, Set<String> set, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> results = new ArrayList<>();
        
        if (s.length() == 0) {
            return results;
        }
        if (set.contains(s)) {
            results.add(s);
        }
        
        for (int len = 1; len < s.length(); len++) {
            String word = s.substring(0, len);
            if (!set.contains(word)) {
                continue;
            }
            
            String suffix = s.substring(len);
            List<String> segements = dfs(suffix, set, memo);
            for (String segement : segements) {
                results.add(word + " " + segement);
            }
        }
        memo.put(s, results);
        
        return results;
    }
}
