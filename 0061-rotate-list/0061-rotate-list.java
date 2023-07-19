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
    public ListNode rotateRight(ListNode head, int k) {
       if(head==null || head.next==null || k==0)return head;
        
        int l=1;
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
            l++;
        }
        curr.next=head;
        
        int eff=l-(k%l);
        
        
        for(int i=0;i<eff;i++)
        {
            curr=curr.next;
        }
        
        ListNode newHead=curr.next;
        curr.next=null;
        return newHead;
        
    }
}