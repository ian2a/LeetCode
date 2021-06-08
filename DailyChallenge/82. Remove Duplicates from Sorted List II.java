class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        
        while (cur != null) {
            while(cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (prev.next == cur) {
                prev = prev.next; // cur.val is distinct, move pre to next node
            } else {
                prev.next = cur.next; // skip duplicates, but pre shouldn't move now
            }
            cur = cur.next;
        }
        
        return dummy.next;
    }
}
