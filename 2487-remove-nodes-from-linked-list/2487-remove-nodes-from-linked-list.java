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

    public ListNode removeNodes(ListNode head) {
        return temp(head, 0);
    }

    private ListNode temp(ListNode node, int max) {
        if (node == null) return null;

        node.next =temp(node.next, Math.max(max, node.val));

        if (node.next != null && node.val < node.next.val)
            return node.next;

        return node;
    }
}