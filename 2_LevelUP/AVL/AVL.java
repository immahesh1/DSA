class AVL {

  public static class Node {
    int data;
    Node left;
    Node right;
    int height;
    int balance;

    public Node(int data) {
      this.data = data;
      this.left = this.right = null;
      this.height = 0;
      this.balance = 0;
    }
  }

  public static void updateHeightAndBalance(Node node) {
    int lh = node.left == null ? -1 : node.left.height;
    int rh = node.right == null ? -1 : node.right.height;

    node.balance = lh - rh;
    node.height = Math.max(lh, rh) + 1;
  }

  public static Node rightRotation(Node A) {
    //   make proper connection
    Node B = A.left;
    A.left = B.right;
    B.right = A;
    //  correct height and balance for A then B
    updateHeightAndBalance(A);
    updateHeightAndBalance(B);
    return B;
  }

  public static Node leftRotation(Node A) {
    //   make proper connection
    Node B = A.right;
    A.right = B.left;
    B.left = A;
    //  correct height and balance for A then B
    updateHeightAndBalance(A);
    updateHeightAndBalance(B);
    return B;
  }

  public static Node getRotation(Node node) {
    updateHeightAndBalance(node);

    if (node.balance == 2) {
      if (node.left.balance == 1) {
        // LL Structure --> call for right rotation
        return rightRotation(node);
      } else if (node.left.balance == -1) {
        // LR Structure
        // left rotation on node B
        node.left = leftRotation(node.left);
        // right rotation on node A
        return rightRotation(node);
      }
    } else if (node.balance == -2) {
      if (node.right.balance == 1) {
        // RL Structure
        node.right = rightRotation(node.right);
        return leftRotation(node);
      } else if (node.right.balance == -1) {
        // RR Structure
        return leftRotation(node);
      }
    }
    return node;
  }

  public static Node add(Node node, int data) {
    if (node == null) {
      Node nn = new Node(data);
      return nn;
    }
    if (data > node.data) {
      node.right = add(node.right, data);
    } else {
      node.left = add(node.left, data);
    }
    node = getRotation(node);
    return node;
  }

  public static Node remove(Node node, int data) {}

  public static void display(Node node) {}

  public static void fun() {
    int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

    Node node = null;
    for (int i = 0; i < arr.length; i++) {
      add(node, arr[i]);
    }

    display(node);
    System.out.println("-----------------------------------------");
    for (int val : arr) {
      remove(node, val);
      display(node);
      System.out.println("=====================================");
    }
  }

  public static void func() {}

  public static void main(String[] args) {
    func();
  }
}
