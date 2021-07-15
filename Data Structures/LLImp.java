import java.util.*;

class linkedlist {

  private class Node {
    private int data;
    private Node next;

    public Node() {
      this.data = 0;
      this.next = null;
    }

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node head;
  private Node tail;
  private int size;

  public linkedlist(Node head, Node tail, int size) {
    this.head = head;
    this.tail = tail;
    this.size = size;
  }

  public linkedlist() {
    this.head = null;
    this.size = 0;
    this.tail = null;
  }

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~linked list methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private void handleAddWhenSize0(int val) {
    Node nn = new Node(val);
    this.head = nn;
    this.tail = nn;
    this.size++;
  }
  public void addFirst(int val) {
    if (this.size == 0) {
      handleAddWhenSize0(val);
    } else {
      Node nn = new Node(val);
      nn.next = this.head;
      this.head = nn;
      this.size++;
    }
  }
  public void addLast(int val) {
    if (this.size == 0) {
      handleAddWhenSize0(val);
    } else {
      Node nn = new Node(val);
      this.tail.next = nn;
      this.tail = nn;
      this.size++;
    }
  }
  private Node getNthNode(int pos) {
    Node tmp = this.head;
    for (int i = 0; i < pos; i++) {
      tmp = tmp.next;
    }
    return tmp;
  }
  public void addAt(int idx, int val) {
    if (idx < 0 || idx > this.size) System.out.println(
      "Invalid arguments"
    ); else if (idx == 0) addFirst(val); else if (idx == this.size) addLast(
      val
    ); else {
      Node nn = new Node(val);
      Node nm1 = getNthNode(idx - 1);
      nn.next = nm1.next;
      nm1.next = nn;
      this.size++;
    }
    // Node tmp = this.head;
    // Node prev = null;
    // int count = 0;
    // while(count != idx){
    //     count++;
    //     prev = tmp;
    //     tmp = tmp.next;
    // }
    // Node nn = new Node(val);
    // prev.next = nn;
    // nn.next = tmp;
    // this.size++;
  }
  public void removeFirst() {
    if (this.size == 0) {
      System.out.println("List is empty");
    } else {
      Node tmp = this.head;
      this.head = tmp.next;
      this.size--;
    }
  }
  public int getSize() {
    return this.size;
  }
  public int getFirst() {
    if (this.size == 0) {
      System.out.println("List is empty");
      return -1;
    }
    Node tmp = this.head;
    return tmp.data;
  }
  public int getLast() {
    if (this.size == 0) {
      System.out.println("List is empty");
      return -1;
    }
    Node tmp = this.head;
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    return tmp.data;
  }
  public int getAt(int idx) {
    if (idx < 0 || idx >= this.size) {
      System.out.println("Invalid arguments");
      return -1;
    }
    return getNthNode(idx - 1).data;
  }
  public void display() {
    if (this.size == 0) {
      System.out.println("linked list is empty");
      return;
    }
    Node tmp = this.head;
    while (tmp != null) {
      System.out.print(tmp.data + " -> ");
      tmp = tmp.next;
    }
    System.out.println("null");
  }
  public void removeLast() {
    if (this.size == 0) {
      System.out.println("List is empty");
    } else if (this.size == 1) {
      this.head = null;
      this.tail = null;
      this.size--;
    } else {
      Node nm2 = getNthNode(this.size - 2);
      nm2.next = null;
      this.tail = nm2;
      this.size--;
    }
  }
  public void removeAt(int idx) {
    if (idx < 0 || idx >= this.size) {
      System.out.println("Invalid arguments");
    } else if (idx == 0) {
      removeFirst();
    } else if (idx == this.size - 1) {
      removeLast();
    } else {
      Node nm1 = getNthNode(idx - 1);
      nm1.next = nm1.next.next;
      this.size--;
    }
  }
  public void reverseDI() {
    int left = 0;
    int right = this.size - 1;
    while (left < right) {
      Node lnode = getNthNode(left);
      Node rnode = getNthNode(right);

      int tmp = lnode.data;
      lnode.data = rnode.data;
      rnode.data = tmp;
      left++;
      right--;
    }
  }
  public void reversePI() {
    Node prev = null;
    Node curr = this.head;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    Node tmp = this.head;
    this.head = this.tail;
    this.tail = tmp;
  }
  public int kthFromLast(int k) {
    Node fast = this.head;
    Node slow = this.head;
    for(int i=0; i<k; i++){
        fast = fast.next;
    }
    while(fast.next != null){
        slow = slow.next;
        fast = fast.next;
    }
    return slow.data;
  }
  public int midOfLinkedList(){
      Node fast = this.head;
      Node slow = this.head;
      while(fast.next != null && fast.next.next != null){
          slow = slow.next;
          fast = fast.next.next;
      }
      return slow.data;
  }
  public static linkedlist mergeTwoSortedLists(linkedlist l1, linkedlist l2){
    Node t1 = l1.head;
    Node t2 = l2.head;
    linkedlist res = new linkedlist();
    while(t1 != null && t2 != null){
        if(t1.data < t2.data){
            res.addLast(t1.data);
            t1 = t1.next;
        }else{
            res.addLast(t2.data);
            t2 = t2.next;
        }
    }
    while(t1 != null){
        res.addLast(t1.data);
        t1 = t1.next;
    }
    while(t2 != null){
        res.addLast(t2.data);
        t2 = t2.next;
    }
    return res;
  }
  public static Node midForMergeSort(Node head, Node tail){
      Node slow = head;
      Node fast = head;
      while(fast.next != tail && fast != tail){
          slow = slow.next;
          fast = fast.next.next;
      }
      return slow;
  }
  public static linkedlist mergeSort(Node head, Node tail){
    if(head == tail){
        linkedlist bres = new linkedlist();
        bres.addFirst(head.data);
        return bres; 
    }  
    linkedlist res = new linkedlist();
    Node mid = midForMergeSort(head,tail);
    linkedlist l1 = mergeSort(head, mid);
    linkedlist l2 = mergeSort(mid.next, tail);
    res = linkedlist.mergeTwoSortedLists(l1, l2);
    return res;
  }
  public void removeDuplicates(){
      Node tmp = this.head;
      Node itr = tmp.next;
      while(itr != null){
          if(tmp.data == itr.data){
              itr = itr.next;
          }else{
              tmp.next = itr;
              tmp = tmp.next;
              itr = itr.next;
          }
      }
      tmp.next = itr;
  }
  public void oddEven(){
    linkedlist odd = new linkedlist();
    linkedlist even = new linkedlist();
    while(this.size > 0){
        int val = this.getFirst();
        this.removeFirst();
        if(val % 2 == 0){
            even.addLast(val);
        }else{
            odd.addLast(val);
        }
    }
    if(odd.size>0 && even.size>0){
        odd.tail.next = even.head;
        this.head = odd.head;
        this.tail = even.tail;
        this.size = odd.size + even.size;
    }else if(odd.size>0){
        this.head = odd.head;
        this.tail = odd.tail;
        this.size = odd.size;
    }else if(even.size>0){
        this.head = even.head;
        this.tail = even.tail;
        this.size = even.size;
    }
  }
  public void kReverse(int k){
    linkedlist res = null;
    while(this.size > 0){
      linkedlist tmp = new linkedlist();
      if(this.size >= k){
        for(int i=0; i<k; i++){
          int val = this.getFirst();
          this.removeFirst();
          tmp.addFirst(val);
        }
      }else{
        while(this.size > 0){
          int val = this.getFirst();
          this.removeFirst();
          tmp.addLast(val);
        }
      }

      if(res == null){
        res = tmp;
      }else{
        res.tail.next = tmp.head;
        res.tail = tmp.tail;
        res.size += tmp.size;
      }
    }
    this.head = res.head;
    this.tail = res.tail;
    this.size = res.size;
  }
}

public class LLImp {

  public static void func() {
    linkedlist ll = new linkedlist();
    ll.addFirst(5);
    System.out.println("remove at");
    ll.removeAt(0);
    ll.addFirst(10);
    ll.addFirst(15);
    ll.display();
    ll.addLast(100);
    ll.addLast(200);
    ll.display();
    ll.addAt(2, 1000);
    ll.display();
    ll.addAt(4, -100);
    ll.display();
    ll.removeFirst();
    ll.display();
    // ll.removeLast();
    ll.removeAt(3);
    ll.display();
    ll.reverseDI();
    ll.display();
  }

  public static void test() {
    linkedlist ll = new linkedlist();
    for(int i=1; i<=11; i++){
        ll.addLast(i);
    }
    ll.kReverse(3);
    ll.display();
    // int res = ll.midOfLinkedList();
    // System.out.println("mid: "+res);
    // linkedlist l2 = new linkedlist();
    // l2.addLast(5);
    // l2.addLast(17);
    // l2.addLast(27);
    // l2.addLast(29);
    // l2.addLast(45);

    // int res = ll.kthFromLast(4);
    // linkedlist lr = linkedlist.mergeTwoSortedLists(ll,l2);
    // lr.display();
    // System.out.println(res);
  }

  public static void main(String[] args) {
    // func();
    test();
  }
}
