public class Solution {

    public int closestValue(TreeNode root, double target) {
        // write your code here
        TreeNode lower = root;
        TreeNode upper = root;
        while (root !=null) {
            if (target < root.val) {
                upper = root;
                root = root.left;
            } else if (target > root.val) {
                lower = root;
                root = root.right;
            } else {
                return root.val;
            }
        }
        if (Math.abs(upper.val - target) < Math.abs(lower.val - target)) {
            return upper.val;
        } else {
            return lower.val;
        }
    }
}
