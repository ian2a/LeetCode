/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peekLast();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.offerLast(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.offerLast(peek.right);
            } else {
                res.add(stack.pollLast().val);
                cur = peek;
            }
        }
        return res;
    }
}
