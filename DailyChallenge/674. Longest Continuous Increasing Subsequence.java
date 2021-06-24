class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
                if (length > maxLen) {
                    maxLen = length;
                }
            } else {
                length = 1;
            }
        }
        
        return maxLen;
    }
}
