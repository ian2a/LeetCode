class Solution {
    public boolean canJump(int[] nums) {
        int dis = 0;
        for (int i = 0; i <= dis; i++) {
            dis = Math.max(dis, i + nums[i]);
            if (dis >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
