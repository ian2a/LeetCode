class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        
        int count = 0;
        
        while (cur != null) {
            count++;
            if (count % k == 0) {
                prev = reverseOneGroup(prev, cur.next);
                cur = prev.next;
            } else {
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverseOneGroup(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode cur = begin.next;
        ListNode first = begin.next;
        
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        begin.next = prev;
        first.next = cur;
        return first;
    }
}
