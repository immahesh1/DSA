class DoublyLinkedList {

  private class Node {
    int data;
    Node next;
    Node prev;

    public Node() {
      this.data = 0;
      this.next = this.prev = null;
    }

    public Node(int data) {
      this.data = data;
      this.next = this.prev = null;
    }
  }

  private Node head = null;
  private Node tail = null;
  private int size = 0;

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
      this.head.prev = nn;
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
      nn.prev = this.tail;
      this.tail = nn;
      this.size++;
    }
  }

  private Node getNodeAt(int pos) {
    Node tmp = this.head;
    for (int i = 0; i < pos; i++) {
      tmp = tmp.next;
    }
    return tmp;
  }

  public void addAt(int pos, int val) {
    if (pos < 0 || pos > this.size) {
      System.out.println("IndexIsInValid: -1");
      return;
    } else if (pos == 0) {
      addFirst(val);
    } else if (pos == this.size) {
      addLast(val);
    } else {
      Node nn = new Node(val);
      Node nm1 = getNodeAt(pos - 1);
      nn.next = nm1.next;
      nm1.next.prev = nn;
      nm1.next = nn;
      nn.prev = nm1;
      this.size++;
    }
  }

  public void addBefore(Node refNode, int data) {
    if (refNode == this.head) {
      addFirst(data);
      return;
    }
    Node nn = new Node(data);
    Node nm1 = refNode.prev;
    nm1.next = nn;
    nn.prev = nm1;

    nn.next = refNode;
    refNode.prev = nn;
    this.size++;
  }

  public void addAfter(Node refNode, int data) {
    if (refNode == this.tail) {
      addLast(data);
      return;
    }
    Node nn = new Node(data);
    Node np1 = refNode.next;

    refNode.next = nn;
    nn.prev = refNode;

    nn.next = np1;
    np1.prev = nn;
    this.size++;
  }

  public int handleRemoveWhenSize1() {
    int val = this.head.data;
    this.head = this.tail = null;
    this.size = 0;
    return val;
  }

  public int removeFirst() {
    if (this.size == 0) {
      System.out.println("ListIsEmpty: ");
      return -1;
    } else if (this.size == 1) {
      return handleRemoveWhenSize1();
    }
    int val = this.head.data;
    this.head = this.head.next;
    this.head.prev = null;
    this.size--;
    return val;
  }

  public int removeLast() {
    if (this.size == 0) {
      System.out.println("ListIsEmpty: ");
      return -1;
    } else if (this.size == 1) {
      return handleRemoveWhenSize1();
    }
    int val = this.tail.data;
    this.tail = this.tail.prev;
    this.tail.next = null;
    this.size--;
    return val;
  }

  public int removeAt(int index) {
    if (index < 0 || index >= this.size) {
      System.out.print("IndexIsInValid: ");
      return -1;
    } else if (index == 0) {
      return removeFirst();
    } else if (index == this.size - 1) {
      return removeLast();
    }
    Node node = getNodeAt(index);
    return removeNode(node);
  }

  public int removeNode(Node node) {
    if (this.size == 0) {
      System.out.print("ListIsEmpty: ");
      return -1;
    }
    int val = node.data;
    Node nm1 = node.prev;
    Node np1 = node.next;
    nm1.next = np1;
    np1.prev = nm1;
    return val;
  }

  public void displayForward() {
    if (this.size == 0) {
      System.out.println("[]");
      return;
    }
    Node tmp = this.head;
    System.out.print("[");
    while (tmp != this.tail) {
      System.out.print(tmp.data + ",");
      tmp = tmp.next;
    }
    System.out.println(tmp.data + "]");
  }

  public void displayBackward() {
    if (this.size == 0) {
      System.out.println("[]");
      return;
    }
    Node tmp = this.tail;
    System.out.print("[");
    while (tmp.prev != null) {
      System.out.print(tmp.data + ",");
      tmp = tmp.prev;
    }
    System.out.println(tmp.data + "]");
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    if (this.size == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int getFirst() {
    if (this.size == 0) {
      System.out.print("ListIsEmpty: ");
      return -1;
    } else {
      return this.head.data;
    }
  }

  public int getLast() {
    if (this.size == 0) {
      System.out.print("ListIsEmpty: ");
      return -1;
    } else if (this.size == 1) {
      return this.head.data;
    } else {
      return this.tail.data;
    }
  }

  public int getAt(int index) {
    if (index < 0 || index > this.size) {
      System.out.print("IndexIsInValid: ");
      return -1;
    } else if (this.size == 0) {
      System.out.println("ListIsEmpty: ");
      return -1;
    } else if (index == 0) {
      return getFirst();
    } else if (index == this.size - 1) {
      return getLast();
    } else {
      Node tmp = this.head;
      for (int i = 0; i < index; i++) {
        tmp = tmp.next;
      }
      return tmp.data;
    }
  }

  public int removeAfter(Node node) {
    Node rem = node.next;
    if (rem == null) {
      System.out.print("LocationIsInvalid: ");
      return -1;
    } else if (rem.next == null) { // rem is the last node
      node.next = null;
      rem.prev = null;
      this.tail = rem;
    } else {
      node.next = rem.next;
      rem.next.prev = node;

      rem.next = null;
      rem.prev = null;
    }
    this.size--;
    return rem.data;
  }
}

public class DLL {

  public static void fun() {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.displayForward();
    dll.addFirst(10);
    dll.addFirst(20);
    dll.addFirst(100);
    dll.displayForward();
    dll.displayBackward();
  }

  public static void main(String[] args) {
    fun();
  }
}
