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
        ListNode complete = new ListNode();
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return complete.next;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        complete = fetchNext(l1, l2, complete);
        return complete;

    }

    private ListNode fetchNext(ListNode l1, ListNode l2, ListNode complete) {
        if (l1.val <= l2.val) {
            complete.val = l1.val;
            complete.next = new ListNode();
            if (l1.next != null) {
                fetchNext(l1.next, l2, complete.next);
            }
           else {
               complete.next = l2;
           }
        } else {
            complete.val = l2.val;
            complete.next = new ListNode();
            if (l2.next != null) {
                fetchNext(l1, l2.next, complete.next);
            }
            else {
               complete.next = l1;
           }
        }
        return complete;
    }
}