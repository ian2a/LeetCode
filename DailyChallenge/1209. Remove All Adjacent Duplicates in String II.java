class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        char[] stack = s.toCharArray();
        int[] count = new int[n];
        
        int slow = 0;
        for (int fast = 0; fast < n; fast++, slow++) {
            stack[slow] = stack[fast];
            if (slow > 0 && stack[fast] == stack[slow - 1]) {
                count[slow] = count[slow - 1] + 1;
            } else {
                count[slow] = 1;
            }
            if (count[slow] == k) {
                slow -= k;
            }
        }
        
        return new String(stack, 0, slow);
    }
}
