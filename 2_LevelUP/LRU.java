import java.util.HashMap;

class LRUCache {

  class Node {
    private int key;
    private int value;
    private Node next;
    private Node prev;

    public Node() {
      this.key = 0;
      this.value = 0;
      this.next = this.prev = null;
    }

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = this.prev = null;
    }
  }

  private Node head = null;
  private Node tail = null;
  private int size = 0;
  private int cap = 0;

  private HashMap<Integer, Node> map = null;

  private int removeFirst() {
    Node rem = head;
    head = head.next;
    head.prev = null;

    rem.next = null;
    this.size--;
    return rem.key;
  }

  private void addLast(Node node) {
    if (this.size == 0) {
      this.head = this.tail = node;
      this.size = 1;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
      this.tail = node;
      this.size++;
    }
  }

  private void removeNode(Node node) {
    if (this.size == 1) {
      this.head = this.tail = null;
    } else if (node == head) {
      head = head.next;
      head.prev = null;
    } else if (node == tail) {
      tail = tail.prev;
      tail.next = null;
    } else {
      Node nm1 = node.prev;
      Node np1 = node.next;
      nm1.next = np1;
      np1.prev = nm1;
    }
    this.size--;
  }

  public LRUCache(int capacity) {
    this.cap = capacity;
    map = new HashMap<>();
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      int value = map.get(key).value;
      // call put to update
      this.put(key, value);
      return value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      // update and add last
      // get node
      Node node = map.get(key);
      node.value = value;
      // remove node
      removeNode(node);
      // add node
      addLast(node);
    } else {
      // add new
      Node nn = new Node(key, value);
      map.put(key, nn);
      addLast(nn);

      if (this.size > this.cap) {
        int remFirstKey = removeFirst();
        map.remove(remFirstKey);
      }
    }
  }
}

class LRU {

  public static void main(String[] args) {}
}
