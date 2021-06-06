class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    private class TrieNode {
        private TrieNode[] children;
        private String word;
        
        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, TrieNode node, int i, int j, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char ch = board[i][j];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }
        
        node = node.children[ch - 'a'];
        
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        for (int dir = 0; dir < 4; dir++) {
            dfs(board, node, i + dx[dir], j + dy[dir], res);
        }
        board[i][j] = ch;
    }
}
