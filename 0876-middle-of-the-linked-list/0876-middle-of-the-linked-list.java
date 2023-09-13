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
    public ListNode middleNode(ListNode head) {
        int k=0;
        ListNode curr=head;
        while(curr!=null)
        {
            k++;
            curr=curr.next;
        }
        int th=0;
        if(k%2==0)
        {
            th=(k/2);
        }
        else
        {
            th=k/2;
        }
        ListNode mid=head;
        while(th-->0)
        {
            mid=mid.next;
        }
        System.out.println(k);
        System.out.println(th);
        
        return mid;
    }
}