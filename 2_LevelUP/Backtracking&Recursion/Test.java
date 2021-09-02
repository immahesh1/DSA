import java.util.*;

class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  //   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  //     return null;
  //   }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode t1 = l1;
    ListNode t2 = l2;
    ListNode res = new ListNode(-1);
    ListNode rtmp = res;
    int c = 0;
    while (t1.next != null && t2.next != null) {
      int v1 = t1.val;
      int v2 = t2.val;
      int value = v1 + v2 + c;
      c = value % 10;
      int rv = value / 10;
      rtmp.val = rv;
      rtmp.next = rtmp.next;
      t1 = t1.next;
      t2 = t2.next;
      System.out.println(rtmp.val);
    }
    if (t1.next != null) {
      if (c > 0) {
        while (t1.next != null) {
          int v = t1.val + c;
          c = v % 10;
          rtmp.val = v;
          t1 = t1.next;
          rtmp = rtmp.next;
        }
      }
    }
    if (t2.next != null) {
      if (c > 0) {
        while (t2.next != null) {
          int v = t2.val + c;
          c = v % 10;
          rtmp.val = v;
          t2 = t2.next;
          rtmp = rtmp.next;
        }
      }
    }

    return res;
  }

  // InFput_code===================================================

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode makeList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head1 = makeList(scn.nextInt());
    ListNode head2 = makeList(scn.nextInt());

    ListNode ans = addTwoNumbers(head1, head2);
    printList(ans);
  }
}
