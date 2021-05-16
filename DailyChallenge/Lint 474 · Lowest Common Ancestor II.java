public class Solution {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        List<ParentTreeNode> pathA = getPath(A);
        List<ParentTreeNode> pathB = getPath(B);

        ParentTreeNode lca = null;
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        while (indexA >= 0 && indexB >= 0) {
            // Previous step found LCA
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lca = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return lca;
    }
    private List<ParentTreeNode> getPath(ParentTreeNode node) {
        List<ParentTreeNode> res = new ArrayList<>();
        while (node != null) {
            res.add(node);
            node = node.parent;
        }
        return res;
    }
}
