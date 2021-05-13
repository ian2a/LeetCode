class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        helper(root, String.valueOf(root.val), paths);
        return paths;
    }
    
    private void helper(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        
        if (root.left != null) {
            helper(root.left, path + "->" + root.left.val, paths);
        }
        
        if (root.right != null) {
            helper(root.right, path + "->" + root.right.val, paths);
        }
    }
}
