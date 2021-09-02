import Bst.Node;
import java.util.*;

class GenericTree implements Iterable<Integer> {

  private class Node {
    int data;
    ArrayList<Node> children;

    public Node(int data) {
      this.data = data;
      this.children = new ArrayList<>();
    }
  }

  private class Pair {
    Node node;
    int state;

    public Pair(Node node, int state) {
      thsi.node = node;
      this.state = state;
    }
  }

  private class GTPreorderIterator implements Iterator<Integer> {
    Integer itr_val;
    Stack<Pair> st;

    public GTPreorderIterator(Node root) {
      st = new Stack<>();
      st.push(new Pair(root, 0));
      next();
    }

    public boolean hasNext() {
      if (itr_val == null) return false; else return true;
    }

    public Integer next() {
      Integer val = itr_val;
      itr_val = null;
      while (st.size() > 0) {
        Pair top = st.peek();
        if (top.state == 0) {}
      }
    }
  }

  private Node root = null;
  private int size = 1;

  private Node construct(int[] arr) {
    Stack<Node> st = new Stack<>();
    root = new Node(arr[0]);
    st.push(root);
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node nn = new Node(arr[i]);
        this.size++;
        st.peek().children.add(nn);
        st.push(nn);
      }
    }
    return root;
  }

  public GenericTree(int[] arr) {
    construct(arr);
  }

  private void display(Node root) {
    System.out.print("[" + root.data + "] -> ");
    for (Node child : root.children) {
      System.out.print(child.data + ", ");
    }
    System.out.println(".");

    for (Node child : root.children) {
      display(child);
    }
  }

  public void display() {
    display(root);
  }

  public int size() {
    return this.size;
  }
}

public class GenTreeItr {

  public static void func() {
    int[] arr = {
      10,
      20,
      50,
      -1,
      60,
      -1,
      -1,
      30,
      70,
      -1,
      80,
      110,
      -1,
      120,
      -1,
      -1,
      90,
      -1,
      -1,
      40,
      100,
      -1,
      -1,
      -1,
    };
    GenericTree gt = new GenericTree(arr);
    gt.display();
    System.out.println(gt.size());
    for (int g : gt) {
      System.out.println(g);
    }
  }

  public static void main(String[] args) {
    func();
  }
}
