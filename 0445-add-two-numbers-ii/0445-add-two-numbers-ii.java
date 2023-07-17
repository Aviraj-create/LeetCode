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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack();
        Stack<Integer> s2=new Stack();
        
        while(l1!=null)
        {
            s1.add(l1.val);
            l1=l1.next;
        }
        
        while(l2!=null)
        {
            s2.add(l2.val);
            l2=l2.next;
        }
        ListNode sum=null;
        int carry=0;
        
        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0 )
        
        {
            int d1=(!s1.isEmpty())?s1.pop():0;
            int d2=(!s2.isEmpty())?s2.pop():0;
            
            int temp=d1+d2+carry;
            carry=temp/10;
             int digitSum = temp % 10;

            // Create a new node for the sum
            ListNode newNode = new ListNode(digitSum);
            newNode.next = sum;
            sum = newNode;
            
        }
        return sum;
}
}