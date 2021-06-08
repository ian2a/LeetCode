class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        
        ListNode start = pre.next;
        ListNode then = start.next;
        
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}
