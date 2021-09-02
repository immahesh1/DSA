class QuickSort {

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public public static static ListNode quickSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }

    quickSort(head, tail);
  }
}
