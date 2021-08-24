import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> answer = new ArrayList<>();
        for (ListNode l : lists) {
            ListNode cur = l;
            while (cur != null) {
                answer.add(cur.val);
                cur = cur.next;
            }
        }
        Collections.sort(answer);
        ListNode head = new ListNode(), tmp = head;
        for (int i : answer) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        return head.next;
    }
}