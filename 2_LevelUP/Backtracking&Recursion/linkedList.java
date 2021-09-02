import java.util.HashMap;
import java.util.PriorityQueue;

class linkedList {

  public class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  public static ListNode middle1(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  //   https://leetcode.com/problems/middle-of-the-linked-list/submissions/
  public static ListNode middle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // https://leetcode.com/problems/palindrome-linked-list/
  public boolean isPalindrome(ListNode head) {
    //   step 1: find middle
    ListNode mid = middle1(head);
    // step 2: reverse 2nd half
    ListNode head2 = mid.next;
    mid.next = null;
    head2 = reverseList(head2);
    // step 3 traverse on each node
    ListNode tmp1 = head;
    ListNode tmp2 = head2;
    while (tmp1 != null && tmp2 != null) {
      if (tmp1.val == tmp2.val) {
        tmp1 = tmp1.next;
        tmp2 = tmp2.next;
      } else {
        return false;
      }
    }
    return true;
  }

  public static void fold(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) return;
    // 1. segregate first and second half
    ListNode mid = middle1(head);
    ListNode head2 = mid.next;
    mid.next = null;
    // 2. Reverse second half
    head2 = reverseList(head2);
    // 3. rearrange
    ListNode tmp1 = head;
    ListNode tmp2 = head2;
    while (tmp1 != null && tmp2 != null) {
      ListNode next1 = tmp1.next;
      ListNode next2 = tmp2.next;
      tmp1.next = tmp2;
      tmp2.next = next1;
      tmp1 = next1;
      tmp2 = next2;
    }
  }

  //   unfold -- > portal
  public static void unfold(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode eh = new ListNode(-1);
    ListNode oh = new ListNode(-1);
    ListNode t1 = eh;
    ListNode t2 = oh;
    int idx = 0;
    for (ListNode i = head; i != null; idx++, i = i.next) {
      if (idx % 2 == 0) {
        t1.next = i;
        t1 = i;
      } else {
        t2.next = i;
        t2 = i;
      }
    }
    t1.next = null;
    t2.next = null;
    oh = reverseList(oh.next);
    t2.next = oh;
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode tmp1 = l1;
    ListNode tmp2 = l2;
    ListNode res = new ListNode(-1);
    ListNode tmp = res;
    while (tmp1 != null && tmp2 != null) {
      if (tmp1.val > tmp2.val) {
        tmp.next = tmp2;
        tmp2 = tmp2.next;
        tmp = tmp.next;
      } else {
        tmp.next = tmp1;
        tmp1 = tmp1.next;
        tmp = tmp.next;
      }
    }
    if (tmp1 != null) {
      tmp.next = tmp1;
    }
    if (tmp2 != null) {
      tmp.next = tmp2;
    }
    return res.next;
  }

  public class Pair implements Comparable<Pair> {
    ListNode node;

    public Pair(ListNode node) {
      this.node = node;
    }

    public int compareTo(Pair o) {
      return this.node.val - o.node.val;
    }
  }

  public static ListNode mergeSort(ListNode head1) {
    ListNode mid = middle1(head1);
    ListNode head2 = mid.next;
    mid.next = null;

    head1 = mergeSort(head1);
    head2 = mergeSort(head2);

    ListNode res = mergeTwoLists(head1, head2);
    return res;
  }

  public static ListNode mergesort(ListNode l1, ListNode l2) {}

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        pq.add(new Pair(lists[i]));
      }
    }

    ListNode head = new ListNode(-1);
    ListNode tmp = head;

    while (pq.size() > 0) {
      Pair rem = pq.remove();
      tmp.next = rem.node;
      tmp = tmp.next;

      if (rem.node.next != null) {
        pq.add(new Pair(rem.node.next));
      }
    }
    return head.next;
  }

  // 19. Remove Nth Node From End of List
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode forw = head;
    for (int i = 0; i < n; i++) {
      forw = forw.next;
    }
    if (forw == null) return head.next; //in that case n is equal to size -> will remove the first element
    ListNode curr = head;
    while (forw.next != null) {
      forw = forw.next;
      curr = curr.next;
    }
    curr.next = curr.next.next;
    return head;
  }

  // https://leetcode.com/problems/linked-list-cycle/
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  // https://leetcode.com/problems/linked-list-cycle-ii/
  public static ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    if (fast == null || fast.next == null) return null;
    ListNode tmp1 = head;
    ListNode tmp2 = fast;
    while (tmp1 != tmp2) {
      tmp1 = tmp1.next;
      tmp2 = tmp2.next;
    }
    return tmp1;
  }

  // https://leetcode.com/problems/intersection-of-two-linked-lists/
  // method 1: size
  private static int findSize(ListNode head) {
    int sz = 0;
    ListNode tmp = head;
    while (tmp != null) {
      tmp = tmp.next;
      sz += 1;
    }
    return sz;
  }

  public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
    int s1 = findSize(head1);
    int s2 = findSize(head2);
    ListNode t1 = head1;
    ListNode t2 = head2;
    if (s1 > s2) {
      for (int i = 0; i < s1 - s2; i++) t1 = t1.next;
    } else {
      for (int i = 0; i < s2 - s1; i++) t2 = t2.next;
    }
    while (t1 != null) {
      if (t1 == t2) return t1;
      t1 = t1.next;
      t2 = t2.next;
      if (t1 == t2) {
        return t1;
      }
    }
    return null;
  }

  // method 2: floyd cycle

  public static ListNode IntersectionNodeInTwoLL(
    ListNode head1,
    ListNode head2
  ) {
    ListNode tail = head1;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = head1;
    // ListNode tmp = head2;
    ListNode res = detectCycle(head2);
    tail.next = null;
    return res;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int c = 0;
    ListNode res = new ListNode(-1);
    ListNode tmp = res;
    while (l1 != null || l2 != null || c != 0) {
      if (l1 != null) {
        c += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        c += l2.val;
        l2 = l2.next;
      }

      tmp.next = new ListNode(c % 10);
      c /= 10;
      tmp = tmp.next;
      return res.next;
    }
  }

  // https://leetcode.com/problems/add-two-numbers-ii/
  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode t1 = reverseList(l1);
    ListNode t2 = reverseList(l2);
    ListNode res = new ListNode(-1);
    ListNode tmp = res;
    int c = 0;
    while (t1 != null || t2 != null || c != 0) {
      if (t1 != null) {
        c += t1.val;
        t1 = t1.next;
      }
      if (t2 != null) {
        c += t2.val;
        t2 = t2.next;
      }
      tmp.next = new ListNode(c % 10);
      c /= 10;
      tmp = tmp.next;
    }
    return reverseList(res.next);
  }

  // sir method
  // addFirst method
  static ListNode thead;
  static ListNode ttail;

  public static void addFirst(ListNode node) {
    if (thead == null) {
      thead = ttail = node;
    } else {
      node.next = thead;
      thead = node;
    }
  }

  // Reverse using addFirst
  public static ListNode reverseUsingAddFirst(ListNode head) {
    thead = ttail = null;
    ListNode next = head;
    while (next != null) {
      ListNode i = next;
      next = i.next;
      i.next = null;
      addFirst(i);
    }
    return thead;
  }

  // add two number (sir method)
  public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }
    ListNode n1 = reverseUsingAddFirst(l1);
    ListNode n2 = reverseUsingAddFirst(l2);

    ListNode tmp, res = new ListNode(-1);
    tmp = res;

    ListNode i = n1;
    ListNode j = n2;

    int carry = 0;
    while (i != null || j != null || carry != 0) {
      int ival = i == null ? 0 : i.val;
      int jval = j == null ? 0 : j.val;

      i = i == null ? null : i.next;
      j = j == null ? null : j.next;

      int sum = ival + jval + carry;

      tmp.next = new ListNode(sum % 10);
      carry = sum / 10;
      tmp = tmp.next;
    }
    return reverseUsingAddFirst(res.next);
  }

  public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
    l1 = reverseUsingAddFirst(l1);
    l2 = reverseUsingAddFirst(l2);
    ListNode res = null;
    int zeroCount = 0;
    for (ListNode i = l1; i != null; i = i.next) {
      ListNode num = new ListNode(-1);
      ListNode k = num;
      // add zero in it
      for (int z = 0; z < zeroCount; z++) {
        ListNode node = new ListNode(0);
        k.next = node;
        k = node;
      }

      int ival = i.val;
      ListNode j = l2;
      int carry = 0;
      while (j != null || carry != 0) {
        int jval = j == null ? 0 : j.val;
        j = j == null ? null : j.next;
        int prod = ival * jval + carry;
        ListNode val = new ListNode(prod % 10);
        carry = prod / 10;
        k.next = val;
        k = val;
      }
      res = addTwoNumbers3(res, num.next);
      zeroCount++;
    }
    res = reverseUsingAddFirst(res);
    return res;
  }

  public static ListNode removeDuplicates(ListNode head) {
    ListNode head2 = new ListNode(-1);
    ListNode i = head2;

    ListNode curr = head;
    i.next = curr;
    while (curr != null) {
      curr = curr.next;
      boolean flag = false;
      while (curr != null && i.next.val != curr.val) {
        flag = true;
        curr = curr.next;
      }
      if (flag == true) {
        i.next = curr;
      } else {
        i = i.next;
      }
    }
    return head2.next;
  }

  // Remove Duplicate From Sorted Linkedlist
  public static ListNode removeDuplicates(ListNode head) {
    ListNode curr = head;
    ListNode i, res = new ListNode(-1);
    i = res;

    while (curr != null) {
      if (i.val != curr.val) {
        i.next = curr;
        i = i.next;
      }
      curr = curr.next;
    }
    return res.next;
  }

  public static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val, Node next, Node random) {
      val = this.val;
      next = this.next;
      random = this.random;
    }
  }

  public static ListNode copyLinkedList(ListNode head) {
    ListNode h1 = new ListNode(-1);
    ListNode tmp1 = h1;
    ListNode tmp2 = head;

    while (tmp2 != null) {
      ListNode node = new ListNode(tmp2.val);
      tmp1.next = node;
      tmp1 = node;
      tmp2 = tmp2.next;
    }
    return h1.next;
  }

  public static ListNode copyRandomList1(ListNode head1) {
    // 1. make a copy linkedlist with next pointer only
    ListNode head2 = copyLinkedList(head1);
    // 2. make a zigzag pattern
    ListNode t1 = head1;
    ListNode t2 = head2;
    // 3. make connection of random pointer

    // 4. regain original list
  }

  // using hashMap
  public static ListNode copyRandomList(ListNode head1) {
    if (head1 == null) return null;
    // 1. make a copy linkedlist with next pointer only
    ListNode head2 = copyLinkedList(head1);
    // 2. Make hashMap of Node vs Node
    HashMap<ListNode, ListNode> map = new HashMap<>();
    ListNode t1 = head1, t2 = head2;
    while (t1 != null) {
      map.put(t1, t2);
      t1 = t1.next;
      t2 = t2.next;
    }
    // 3. Make connection of a random pointer
    for (ListNode onode : map.keySet()) {
      // onode -> origin node
      ListNode cnode = map.get(onode); // clonned node
      ListNode orandom = onode.random; // original random
      cnode.random = orandom == null ? null : map.get(orandom);
    }
    return head2;
  }

  public static ListNode segregateEvenOdd(ListNode head) {
    ListNode 
  }

  public static void func() {}

  public static void main(String[] args) {
    func();
  }
}
