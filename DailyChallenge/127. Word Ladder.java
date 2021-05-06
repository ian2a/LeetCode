class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {    //将wordList中的单词加入dict
            dict.add(word);
        }
        int len = 1;
        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nei : getNextWords(word, dict)) {
                    if (set.contains(nei)) {
                        continue;
                    }
                    if (nei.equals(endWord)) {
                        return len;
                    }
                    set.add(nei);
                    queue.add(nei);
                }
            }
            
        }
        return 0;
    }
    
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = replace(word, i, c);
                if (dict.contains(newWord)) {
                    res.add(newWord);
                }
            }
        }
        return res;
    }
    
    private String replace(String word, int i, char c) {
        char[] charArray = word.toCharArray();
        charArray[i] = c;
        return new String(charArray);
    }
}
