/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> nodes = getAllNodes(node);
        
        Map<Node, Node> map = new HashMap<>();
        for (Node n : nodes) {
            map.put(n, new Node(n.val));
        }
        
        for (Node n : nodes) {
            Node newNode = map.get(n);
            for (Node nei : n.neighbors) {
                Node newNei = map.get(nei);
                newNode.neighbors.add(newNei);
            }
        }
        return map.get(node);
    }
    
    private List<Node> getAllNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node nei : n.neighbors) {
                if (!set.contains(nei)) {
                    set.add(nei);
                    queue.add(nei);
                }
            }
        }
        return new ArrayList<Node>(set);
    }
}
