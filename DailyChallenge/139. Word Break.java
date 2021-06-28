class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] isWord = new boolean[n + 1];
        isWord[0] = true;
        for (int i = 1; i <= n; i++) {
            if (dict.contains(s.substring(0, i))) {
                isWord[i] = true;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (isWord[j] && dict.contains(s.substring(j, i))) {
                    isWord[i] = true;
                    break;
                }
            }
        }
        return isWord[n];
    }
}
