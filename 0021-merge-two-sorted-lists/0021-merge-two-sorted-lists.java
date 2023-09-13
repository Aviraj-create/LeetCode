class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ans.next = l1;
                l1 = l1.next;
            } else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }

        // If either of the lists is not fully merged, append the remaining part
        if (l1 != null) {
            ans.next = l1;
        } else {
            ans.next = l2;
        }

        return dummy.next; // Skip the dummy node
    }
}
