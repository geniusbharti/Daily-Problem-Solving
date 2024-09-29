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
    public ListNode oddEvenList(ListNode head) {
        boolean counter = false;
        ListNode odd= new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode o = odd;
        ListNode e = even;
        ListNode tmp=head;
        while(tmp != null){
            if(!counter){
                o.next = tmp;
                o = o.next;
            }else{
                e.next = tmp;
                e = e.next;
            }
            counter = !counter;
            tmp = tmp.next;
        }
        o.next = even.next;
        if(e != null) e.next = null;
        return odd.next;
    }
}
