class Solution {
    public int findMaximumXOR(int[] nums) {
        int result = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num: nums) {
                set.add(mask & num);
            }
            
            int desiredMax = result | (1 << i);
            for (int prefix: set) {
                if (set.contains(desiredMax ^ prefix)) {
                    result = desiredMax;
                    break;
                }
            }
        }
        
        return result;
    }
}

class Solution {
    private class TrieNode {
        TrieNode[] children;
        
        TrieNode() {
            children = new TrieNode[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Init Trie
        TrieNode root = new TrieNode();
        for (int num: nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (cur.children[curBit] == null) {
                    cur.children[curBit] = new TrieNode();
                }
                cur = cur.children[curBit];
            }
        }
        
        // Search
        int result = Integer.MIN_VALUE;
        for (int num: nums) {
            int tempMax = 0;
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (cur.children[curBit ^ 1] != null) {
                    cur = cur.children[curBit ^ 1];
                    tempMax += 1 << i;
                } else {
                    cur = cur.children[curBit];
                }
            }
            result = Math.max(result, tempMax);
        }
        
        return result;
        
    }
}
