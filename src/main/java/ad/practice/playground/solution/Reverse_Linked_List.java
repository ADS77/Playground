package ad.practice.playground.solution;

public class Reverse_Linked_List {
    class ListNode{
        ListNode next;
        int val;

        public ListNode() {
        }
        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (head != null){
            prev = curr.next;
            curr.next = prev;

            curr = head;
            head = head.next;

        }
        return curr;
    }
}
