class Solution {
   public ListNode reverseList(ListNode head) {
        ListNode left = null, right = null;
        while (head != null) {
            right = head.next;
            head.next = left;
            left = head;
            head = right;
        }
        return left;
    }
}