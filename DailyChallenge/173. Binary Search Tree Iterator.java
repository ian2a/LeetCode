class BSTIterator {
    
    Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode cur = stack.pollLast();
        pushAll(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.offerLast(node);
            node = node.left;
        }
    }
}
