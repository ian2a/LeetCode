class Solution {
    public int lengthOfLongestSubstring(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int maxLen = 0;
        Set<Character> seen = new HashSet<>();
        while (fast < input.length()) {
            if (!seen.contains(input.charAt(fast))) {
                // If this character has not appeared before
                // 1. add it to the hash set
                // 2. move the fast pointer down by one
                // 3. update the max length
                seen.add(input.charAt(fast));
                fast++;
                maxLen = Math.max(maxLen, fast - slow);
            } else {
                // If this character has appeared before
                // 1. remove the character that slow points to from the set
                // 2. move the slow pointer down by one
                seen.remove(input.charAt(slow));
                slow++;
            }
        }
        return maxLen;
    }
}
