class WordDictionary {
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    /** Initialize your data structure here. */
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            // Don't forget to move cur!!
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return find(word, root, 0);
    }
    
    private boolean find(String word, TrieNode node, int index) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isWord;
        }
        if (word.charAt(index) == '.') {
            for(TrieNode temp: node.children) {
                if (find(word, temp, index + 1)) {
                    return true;
                }
            }
        } else {
            int tempIndex = word.charAt(index) - 'a';
            TrieNode temp = node.children[tempIndex];
            
            return find(word, temp, index + 1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
