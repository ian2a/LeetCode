/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            k, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode a, ListNode b) {
                    if (a.val == b.val) {
                        return 0;
                    }
                    return a.val < b.val ? -1 : 1;
                }
            }
        );
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            cur.next = min;
            if (min.next != null) {
                pq.add(min.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
