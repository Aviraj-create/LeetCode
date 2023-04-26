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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start=new ListNode(0);
        ListNode n_prev=start;
        ListNode end=start;
        start.next=head;
        
        for(int i=0;i<=n;i++)
        {
            end=end.next;
        }
        
        while(end!=null)
        {
            end=end.next;
            n_prev=n_prev.next;
        }
        
        n_prev.next=n_prev.next.next;
        return start.next;
    }
}