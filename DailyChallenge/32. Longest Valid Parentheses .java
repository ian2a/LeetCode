class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int leftMost = -1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.offerLast(i);
            } else {
                if (stack.isEmpty()) {
                    leftMost = i;
                } else {
                    int j = stack.pollLast();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - leftMost);
                    } else {
                        max = Math.max(max, i - stack.peekLast());
                    }
                }
            }
        }
        return max;
    }
}
