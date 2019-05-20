package solution;

import solution.common.ListNode;

public class _2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;

        ListNode l3 = new ListNode(0);
        ListNode l3Curr = l3;
        int carry = 0;
        while (l1Curr != null && l2Curr != null) {
            int val = l1Curr.val + l2Curr.val + carry;
            int sum = val % 10;
            carry = val/10;
            
            l3Curr.next = new ListNode(sum);
            l3Curr = l3Curr.next;

            l1Curr = l1Curr.next;
            l2Curr = l2Curr.next;
        }
        
        while (l1Curr != null) {
            int val = l1Curr.val + carry;
            int sum = val % 10;
            carry = val/10;

            l3Curr.next = new ListNode(sum);
            l3Curr = l3Curr.next;
            l1Curr = l1Curr.next;
        }
        
        while (l2Curr != null) {
            int val = l2Curr.val + carry;
            int sum = val % 10;
            carry = val/10;

            l3Curr.next = new ListNode(sum);
            l3Curr = l3Curr.next;
            l2Curr = l2Curr.next;
        }
        
        if (carry != 0) {
            l3Curr.next = new ListNode(carry);
            carry = 0;
        }
        
        l3 = l3.next;
        
        return l3;
    }
}
