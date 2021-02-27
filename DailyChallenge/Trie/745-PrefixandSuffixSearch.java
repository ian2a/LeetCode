class WordFilter {
    Map<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                for (int k = 0; k <= word.length(); k++) {
                    String preSuf = word.substring(0, j) + '_' + word.substring(word.length() - k);
                    map.put(preSuf, i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String preSuf = prefix + '_' + suffix;
        
        return map.containsKey(preSuf) ? map.get(preSuf) : -1;
    }
}


class WordFilter {
    private TrieNode root;
    
    private class TrieNode {
        TrieNode[] children;
        int index;
        
        TrieNode() {
            children = new TrieNode[27];
            index = 0;
        }
        
        private void insert(String word, int index) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (cur.children[charIndex] == null) {
                    cur.children[charIndex] = new TrieNode();
                }
                cur = cur.children[charIndex];
                cur.index = index;
            }
        }
        private int startWith(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (cur.children[charIndex] == null) {
                    return -1;
                }
                cur = cur.children[charIndex];
            }
            return cur.index;
        }
    }
    
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String s = word.substring(word.length() - j) + '{' + word;
                root.insert(s, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String sufPre = suffix + "{" + prefix;
        
        return root.startWith(sufPre);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
