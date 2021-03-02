class Solution {
    private class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[2];
        }
    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int q = queries.length;
        int[] result = new int[q];
        int[][] temp = new int[q][3];
        for (int i = 0; i < q; i++) {
            temp[i][0] = queries[i][0];
            temp[i][1] = queries[i][1];
            temp[i][2] = i;
        }
        
        Arrays.sort(nums);
        Arrays.sort(temp, (a, b) -> {
            return a[1] - b[1];
        });
        TrieNode root = new TrieNode();
        int index = 0;
        for (int i = 0; i < q; i++) {
            // Insert the nums less than mi
            while (index < nums.length && nums[index] <= temp[i][1]) {
                insert(root, nums[index]);
                index++;
            }
            
            int res = -1;
            if (index != 0) {
                res = search(root, temp[i][0]);
            }
            result[temp[i][2]] = res;
        }
        return result;
    }
    
    private void insert(TrieNode node, int num) {
        TrieNode cur = node;
        for (int i = 31; i >= 0; i--) {
            int curBit = (num >> i) & 1;
            if (cur.children[curBit] == null) {
                cur.children[curBit] = new TrieNode();
            }
            cur = cur.children[curBit];
        }
    }
    
    private int search(TrieNode node, int num) {
        TrieNode cur = node;
        int sum = 0;
        for (int i = 31; i >= 0; i--) {
            int curBit = (num >> i) & 1;
            if (cur.children[curBit ^ 1] != null) {
                cur = cur.children[curBit ^ 1];
                sum += 1 << i;
            } else {
                cur = cur.children[curBit];
            }
        }
        return sum;
    }
}
