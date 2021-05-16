public class Solution {

    private boolean foundA = false;
    private boolean foundB = false;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode res = find(root, A, B);
        if (foundA && foundB) {
            return res;
        } else {
            return null;
        }
    }
    private TreeNode find(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        TreeNode left = find(root.left, A, B);
        TreeNode right = find(root.right, A, B);

        if (root == A || root == B) {
            foundA = foundA || (root == A);
            foundB = foundB || (root == B);
            return root;
        }
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }

        return null;
    }
}
