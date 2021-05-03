class Solution {
    public boolean isCompleteTree(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        // Use a flag to indicate whether there is a previous node missing a child
        boolean childMissing = false;
        // Queue for BFS
        Queue <TreeNode> queue = new LinkedList <> ();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // If the node is missing either or both children, raise flag
            if (current.left == null) {
                // Left child missing
                childMissing = true;
            } else if (childMissing) {
                // current has a left child, but a previous node misses a child
                return false;
            } else {
                // current does have a left child and no previous child missing
                queue.offer(current.left);
            }
            // Apply the same logic to the right child
            if (current.right == null) {
                childMissing = true;
            } else if (childMissing) {
                return false;
            } else {
                queue.offer(current.right);
            }
        }
        return true;
    }
}
