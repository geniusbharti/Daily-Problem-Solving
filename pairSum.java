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
    public int pairSum(ListNode head) {
        if(head == null) return 0;
        // 6 7 8 3 5 2 => 6, 2     7, 5    8, 3
            // 2 5 3
        //find mid pointer
        //reverse second half and traverse to get the max twin sum
        //finally dont forget to make the original list
        ListNode mid = getMiddle(head);
        ListNode head1 = head;
        ListNode head2 = doReverse(mid);

        int max = 0;
        int curr = 0;
        while(head2 != null) {
            curr = head1.val + head2.val;
            if(curr > max) max = curr;
            head1 = head1.next;
            head2 = head2.next;
        }

        doReverse(mid);
        return max;
    }

    ListNode getMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode doReverse(ListNode node){
        ListNode next = null, curr = node, prev = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
