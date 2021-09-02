import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import javax.swing.tree.TreeNode;
import jdk.nashorn.api.tree.Tree;

public class Trees {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public class Node {
    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
      this.left = this.right = 0;
    }
  }

  // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
  private TreeNode constructTree(
    int[] pre,
    int[] in,
    int preSt,
    int preEnd,
    int inSt,
    int inEnd
  ) {
    if (preSt > preEnd) return null;
    TreeNode root = new TreeNode(pre[preSt]);

    int idx = inSt;
    while (in[idx] != pre[preSt]) {
      idx++;
    }
    int elementCount = idx - inSt;
    root.left =
      constructTree(pre, in, preSt + 1, preSt + elementCount, inSt, inEnd);
    root.right =
      constructTree(pre, in, preSt + elementCount + 1, preEnd, idx + 1, inEnd);

    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return constructTree(
      preorder,
      inorder,
      0,
      preorder.length - 1,
      0,
      inorder.length - 1
    );
  }

  // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
  private TreeNode constructPostIn(
    int[] post,
    int[] in,
    int postSt,
    int postEnd,
    int inSt,
    int inEnd
  ) {
    if (postSt > postEnd) return null;
    TreeNode root = new TreeNode(post[postEnd]);

    int idx = inSt;
    while (in[idx] != root.val) {
      idx++;
    }

    int eleCount = idx - inSt;
    root.left =
      constructPostIn(post, in, postSt, postSt + eleCount - 1, inSt, idx - 1);
    root.right =
      constructPostIn(post, in, postSt + eleCount, postEnd - 1, idx + 1, inEnd);
    return root;
  }

  public TreeNode buildTreePI(int[] inorder, int[] postorder) {
    return constructPostIn(
      postorder,
      inorder,
      0,
      postorder.length - 1,
      0,
      inorder.length - 1
    );
  }

  // https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1#
  public Node constructTreeLevel(
    int[] in,
    ArrayList<Integer> level,
    int inSt,
    int inEnd
  ) {
    if (level.size() == 0) return null;
    Node root = new Node(level.get(0));

    int idx = inSt;
    HashSet<Integer> set = new HashSet<>();
    while (in[idx] != level.get(0)) {
      set.add(in[idx]);
      idx++;
    }

    ArrayList<Integer> llvl = new ArrayList<>();
    ArrayList<Integer> rlvl = new ArrayList<>();

    for (int i = 1; i < level.size(); i++) {
      int val = level.get(i);
      if (set.contains(val)) {
        llvl.add(val);
      } else {
        rlvl.add(val);
      }
    }
    root.left = constructTreeLevel(in, llvl, inSt, idx - 1);
    root.right = constructTreeLevel(in, rlvl, idx + 1, inEnd);

    return root;
  }

  Node buildTree_2(int inord[], int level[]) {
    ArrayList<Integer> al = new ArrayList<>();
    for (int e : level) al.add(e);
    return constructTreeLevel(inord, al, 0, inord.length - 1);
  }

  // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
  private TreeNode constructBST(int[] nums, int lo, int hi) {
    if (lo > hi) return null;
    int mid = lo + (hi - lo) / 2;
    TreeNode root = new TreeNode(nums[mid]);

    root.left = constructBST(nums, lo, mid - 1);
    root.right = constructBST(nums, mid + 1, hi);

    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return constructBST(nums, 0, nums.length - 1);
  }

  // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
  static int idx = 0;

  private TreeNode bstFromPreorder(int[] pre, int leftRange, int rightRange) {
    if (idx >= pre.length || pre[idx] < leftRange || pre[idx] > rightRange) {
      return null;
    }
    int val = pre[idx++];
    TreeNode root = new TreeNode(val);
    root.left = bstFromPreorder(pre, leftRange, val);
    root.right = bstFromPreorder(pre, val, rightRange);
    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    idx = 0;
    return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  //

  static int idx = 0;

  private static TreeNode bstFromPostorder(
    int[] post,
    int leftRange,
    int rightRange
  ) {
    if (idx < 0 || post[idx] < leftRange || post[idx] > rightRange) {
      return null;
    }
    int val = post[idx--];
    TreeNode root = new TreeNode(val);

    root.right = bstFromPostorder(post, val, rightRange);
    root.left = bstFromPostorder(post, leftRange, val);

    return root;
  }

  public static TreeNode bstFromPostorder(int[] post) {
    idx = post.length - 1;
    return bstFromPostorder(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  //leetcode 968. Binary Tree Cameras: https://leetcode.com/problems/binary-tree-cameras/
  static int camera = 0;

  private int minCamera(TreeNode root) {
    if (root == null) return 1;
    int lstate = minCamera(root.left);
    int rstate = minCamera(root.right);

    if (lstate == 1 && rstate == 1) {
      return 2;
    } else if (lstate == 2 || rstate == 2) {
      camera++;
      return 0;
    } else {
      return 1;
    }
  }

  public int minCameraCover(TreeNode root) {
    camera = 0;
    int state = minCamera(root);
    if (state == 2) camera++;

    return camera;
  }

  // 337. House Robber III: https://leetcode.com/problems/house-robber-iii/
  public class RPair {
    int robWith;
    int robWithout;

    public RPair(int robWith, int robWithout) {
      this.robWith = robWith;
      this.robWithout = robWithout;
    }
  }

  private RPair maxRob(TreeNode root) {
    if (root == null) return new RPair(0, 0);

    RPair left = maxRob(root.left);
    RPair right = maxRob(root.right);

    int a = left.robWith;
    int a_ = right.robWith;
    int b = left.robWith;
    int b_ = right.robWithout;

    int c = root.val;

    int withRob = b + b_ + c;
    int withoutRob = Math.max(a, b) + Math.max(a_, b_);

    return new RPair(withRob, withoutRob);
  }

  public int rob(TreeNode root) {
    RPair res = maxRob(root);
    return Math.max(res.robWith, res.robWithout);
  }

  // 1372. Longest ZigZag Path in a Binary Tree: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

  public static class Pair {
    int backwardSlop = -1;
    int forwardSlop = -1;
    int maxLength = 0;
  }

  public static Pair longestZigZag_(TreeNode root) {
    if (root == null) return new Pair();

    Pair left = longestZigZag_(root.left);
    Pair right = longestZigZag_(root.right);

    Pair myAns = new Pair();

    myAns.maxLength =
      Math.max(
        Math.max(left.maxLength, right.maxLength),
        Math.max(left.backwardSlop, right.forwardSlop) + 1
      );

    myAns.forwardSlop = left.backwardSlop + 1;
    myAns.backwardSlop = right.forwardSlop + 1;

    return myAns;
  }

  public static int longestZigZag(TreeNode root) {
    Pair ans = longestZigZag_(root);
    return ans.maxLength;
  }

  // 98. Validate Binary Search Tree: https://leetcode.com/problems/validate-binary-search-tree/
  public static void isValidBST_(
    TreeNode root,
    TreeNode curr,
    TreeNode prev,
    boolean ans
  ) {
    if (root == null) return;
    isValidBST_(root.left, curr, prev, ans);

    curr = root;
    if (prev == null) {
      prev = root;
    } else {
      if (curr == null) {
        curr = root;
      }
      if (prev.val > curr.val) {
        ans = false;
      }
      prev = root;
      // curr = root;
    }

    isValidBST_(root.right, curr, prev, ans);
  }

  public static boolean isValidBST2(TreeNode root) {
    TreeNode curr = new TreeNode();
    TreeNode prev = new TreeNode();
    boolean ans = true;
    isValidBST_(root, prev, curr, ans);
    return ans;
  }

  public static TreeNode prev = null;

  public static boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    if (!isValidBST(root.left)) return false;
    if (prev == null) {
      prev = root;
    } else {
      if (prev.val > root.val) return false;
      prev = root;
    }
    if (!isValidBST(root.right)) return false;
    return true;
  }

  // 99. Recover Binary Search Tree: https://leetcode.com/problems/recover-binary-search-tree/

  // pointers[0] -> prev
  // pointers[1] -> curr
  // pointers[2] -> a
  // pointers[3] -> b
  public static void recoverTree_(TreeNode root, TreeNode[] pointers) {
    if (root == null) return;

    recoverTree_(root.left, pointers);
    if (pointers[0] == null) {
      //prev == null, first time occurance
      pointers[0] = root;
    } else {
      // set current as root
      pointers[1] = root;
      if (pointers[0].val > pointers[1].val) {
        // prev > curr,
        if (pointers[3] == null) {
          // b is null
          pointers[2] = pointers[0]; // a = prev
          pointers[3] = pointers[1]; // b = curr
        } else {
          // second encounter
          pointers[3] = root;
        }
      }
      // move prev and curr
      pointers[0] = root;
    }
    recoverTree_(root.right, pointers);
  }

  public static void recoverTree(TreeNode root) {
    TreeNode[] pointers = new TreeNode[4];
    recoverTree_(root, pointers);

    // swap a and b values to recover tree
    int tmp = pointers[2].val;
    pointers[2].val = pointers[3].val;
    pointers[3].val = tmp;
  }

  //Convert Level Order Traversal to BST : https://practice.geeksforgeeks.org/problems/convert-level-order-traversal-to-bst/1
  public class LHelper {
    Node parent;
    int leftRange;
    int rightRange;

    public LHelper(Node parent, int leftRange, int rightRange) {
      this.parent = parent;
      this.leftRange = leftRange;
      this.rightRange = rightRange;
    }
  }

  public Node constructBST(int[] arr) {
    Queue<LHelper> qu = new LinkedList<>();
    qu.add(new LHelper(null, Integer.MIN_VALUE, Integer.MAX_VALUE));
    Node root = null;
    for (int i = 0; i < arr.length; i++) {
      Node nn = new Node(arr[i]);
      while (
        qu.peek().leftRange >= nn.data || qu.peek().rightRange <= nn.data
      ) {
        qu.remove();
      }
      LHelper rem = qu.remove();
      qu.add(new LHelper(nn, rem.leftRange, nn.data));
      qu.add(new LHelper(nn, nn.data, rem.rightRange));

      if (rem.parent == null) {
        root = nn;
      } else if (rem.parent.data > nn.data) {
        rem.parent.left = nn;
      } else {
        rem.parent.right = nn;
      }
    }
    return root;
  }

  // 297. Serialize and Deserialize Binary Tree: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
  // Encodes a tree to a single string.
  // public static StringBuilder sb = new StringBuilder();

  public void serialize_(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("null#");
      return;
    }
    sb.append(root.val + "#");
    serialize_(root.left, sb);
    serialize_(root.right, sb);
  }

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize_(root, sb);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public static class BPair {
    TreeNode node;
    int state;

    public BPair(TreeNode node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static TreeNode deserialize(String str) {
    if (str.equals("null#")) return null;
    String[] data = str.split("#");
    Stack<BPair> st = new Stack<>();
    TreeNode root = new TreeNode(Integer.parseInt(data[0]));
    st.push(new BPair(root, 0));
    int idx = 0;
    while (idx < data.length) {
      BPair top = st.peek();
      if (st.peek().state == 0) {
        if (data[idx].equals("null")) {
          st.peek().state++;
          idx++;
        } else {
          TreeNode nn = new TreeNode(Integer.parseInt(data[indx]));
          idx++;
          st.peek().state++;
          st.peek().node.left = nn;
          st.push(new BPair(nn, 0));
        }
      } else if (st.peek().state == 1) {
        if (data[idx].equals("null") == true) {
          st.peek().state++;
          idx++;
        } else {
          TreeNode nn = new TreeNode(Integer.parseInt(data[indx]));
          idx++;
          st.peek().state++;
          st.peek().node.right = nn;
          st.push(new BPair(nn, 0));
        }
      } else {
        st.pop();
      }
      return root;
    }
  }

  // Left View of Binary Tree : https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
  public class VPair {
    TreeNode node;
    int idx;

    public VPair(TreeNode node, int idx) {
      this.node = node;
      this.idx = idx;
    }
  }

  public static ArrayList<Integer> leftView(TreeNode root) {
    if (root == null) return new ArrayList<>();
    ArrayList<Integer> res = new ArrayList<>();
    Queue<VPair> qu = new LinkedList<>();
    qu.add(new VPair(root, 0));
    qu.add(new VPair(null, -1));

    int count = 0;
    while (qu.size() > 0) {
      // 1. Get and Remove
      VPair rem = qu.remove();
      if (rem.node == null) {
        count = 0;
        if (qu.size() > 0) {
          qu.add(new VPair(null, -1));
        }
      } else {
        // 2. Work
        // Add in list if index is 0
        if (rem.idx == 0) {
          res.add(rem.node.val);
        }
        // 3. add children
        if (rem.node.left != null) {
          qu.add(new VPair(rem.node.left, count++));
        }
        if (rem.node.right != null) {
          qu.add(new VPair(rem.node.right, count++));
        }
      }
    }
    return res;
  }

  // right view: https://leetcode.com/problems/binary-tree-right-side-view/
  public static ArrayList<Integer> rightSideView(TreeNode root) {
    if (root == null) return new ArrayList<>();
    ArrayList<Integer> res = new ArrayList<>();
    Queue<VPair> qu = new LinkedList<>();
    qu.add(new VPair(root, 0));
    qu.add(new VPair(null, -1));

    int count = 0;
    while (qu.size() > 0) {
      // 1. Get and Remove
      VPair rem = qu.remove();
      if (rem.node == null) {
        count = 0;
        if (qu.size() > 0) {
          qu.add(new VPair(null, -1));
        }
      } else {
        // 2. Work
        // Add in list if index is 0
        if (rem.idx == 0) {
          res.add(rem.node.val);
        }
        // 3. add children
        if (rem.node.right != null) {
          qu.add(new VPair(rem.node.right, count++));
        }
        if (rem.node.left != null) {
          qu.add(new VPair(rem.node.left, count++));
        }
      }
    }
    return res;
  }

  // Width Of Shadow Of Binary Tree
  public static int lh = 0;
  public static int rh = 0;

  public static void width(TreeNode root, int count) {
    if (root == null) return;
    if (count < lh) {
      lh = count;
    } else if (count > rh) {
      rh = count;
    }
    width(root.left, count - 1);
    width(root.right, count + 1);
  }

  public static int width(TreeNode root) {
    lh = 0;
    rh = 0;
    width(root, 0);
    return rh - lh + 1;
  }

  // Vertical Traversal of Binary Tree : https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
  public static int count = 0;

  public static class TPair implements Comparable<TPair> {
    TreeNode node;
    int count;

    public TPair(TreeNode node, int count) {
      this.node = node;
      this.count = count;
    }

    public int compareTo(TPair o) {
      return this.node.val - o.node.val;
    }
  }

  public static ArrayList<Integer> verticalOrder(Node root) {
    Queue<TPair> qu = new LinkedList<>();
    qu.add(new TPair(root, 0));
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int lh = 0; // left horizontal
    int rh = 0; // right horizontal
    while (qu.size() > 0) {
      // 1. Get and Remove
      TPair rem = qu.remove();

      // 2. Work
      if (map.containsKey(rem.count)) {
        map.get(rem.count).add(rem.node.data);
      } else {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(rem.node.data);
        map.put(rem.count, al);
      }
      if (rem.count < lh) {
        lh = rem.count;
      } else if (rem.count > rh) {
        rh = rem.count;
      }
      // 3. add children
      if (rem.node.left != null) {
        qu.add(new TPair(rem.node.left, rem.count - 1));
      }
      if (rem.node.right != null) {
        qu.add(new TPair(rem.node.right, rem.count + 1));
      }
    }
    ArrayList<Integer> lst = new ArrayList<>();
    for (int i = lh; i <= rh; i++) {
      for (int v : map.get(i)) {
        lst.add(v);
      }
    }
    return lst;
  }

  // PORTAL
  public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(
    TreeNode root
  ) {
    Queue<TPair> qu = new LinkedList<>();
    qu.add(new TPair(root, 0));
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int lh = 0; // left horizontal
    int rh = 0; // right horizontal
    while (qu.size() > 0) {
      // 1. Get and Remove
      TPair rem = qu.remove();

      // 2. Work
      if (map.containsKey(rem.count)) {
        map.get(rem.count).add(rem.node.val);
      } else {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(rem.node.val);
        map.put(rem.count, al);
      }
      if (rem.count < lh) {
        lh = rem.count;
      } else if (rem.count > rh) {
        rh = rem.count;
      }
      // 3. add children
      if (rem.node.left != null) {
        qu.add(new TPair(rem.node.left, rem.count - 1));
      }
      if (rem.node.right != null) {
        qu.add(new TPair(rem.node.right, rem.count + 1));
      }
    }
    ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
    for (int i = lh; i <= rh; i++) {
      lst.add(map.get(i));
    }
    return lst;
  }

  // 987. Vertical Order Traversal of a Binary Tree:  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    lh = 0;
    rh = 0;
    int wd = width(root);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < wd; i++) {
      ans.add(new ArrayList<>());
    }

    PriorityQueue<TPair> mainQ = new PriorityQueue<>();
    PriorityQueue<TPair> childQ = new PriorityQueue<>();

    mainQ.add(new TPair(root, Math.abs(lh)));

    while (mainQ.size() > 0) {
      while (mainQ.size() > 0) {
        TPair rem = mainQ.remove();
        ans.get(rem.count).add(rem.node.val);

        if (rem.node.left != null) {
          childQ.add(new TPair(rem.node.left, rem.count - 1));
        }

        if (rem.node.right != null) {
          childQ.add(new TPair(rem.node.right, rem.count + 1));
        }
      }
      // Swap pqs
      PriorityQueue<TPair> tmp = mainQ;
      mainQ = childQ;
      childQ = tmp;
    }
    return ans;
  }

  // Diagonal Order Of A Binarytree
  public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> qu = new LinkedList<>();
    qu.add(root);
    int factSize;
    while (qu.size() > 0) {
      factSize = qu.size();
      ArrayList<Integer> al = new ArrayList<>();
      while (factSize-- > 0) {
        TreeNode factor = qu.remove();
        while (factor != null) {
          al.add(factor.val);
          if (factor.left != null) {
            qu.add(factor.left);
          }
          factor = factor.right;
        }
      }
      ans.add(al);
    }
    return ans;
  }

  // vertical order sum
  public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
    int lh = 0;
    int rh = 0;
    Queue<TPair> qu = new LinkedList<>();
    qu.add(new TPair(root, 0));
    HashMap<Integer, Integer> map = new HashMap<>();
    while (qu.size() > 0) {
      TPair rem = qu.remove();

      if (map.containsKey(rem.count)) {
        int val = map.get(rem.count) + rem.node.val;
        map.put(rem.count, val);
      } else {
        map.put(rem.count, rem.node.val);
      }

      if (lh > rem.count) {
        lh = rem.count;
      }
      if (rh < rem.count) {
        rh = rem.count;
      }

      if (rem.node.left != null) {
        qu.add(new TPair(rem.node.left, rem.count - 1));
      }
      if (rem.node.right != null) {
        qu.add(new TPair(rem.node.right, rem.count + 1));
      }
    }
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = lh; i <= rh; i++) {
      al.add(map.get(i));
    }
    return al;
  }

  // Diagonal Order (anti-clock Wise) Of A Binarytree --portal
  public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {}

  // In Order Morris Traversal In Binarytree
  private static TreeNode getRightMostNode(TreeNode tmp, TreeNode curr) {
    while (tmp.right != null && tmp.right != curr) {
      tmp = tmp.right;
    }
    return tmp;
  }

  public static ArrayList<Integer> morrisInTraversal(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null) {
      TreeNode leftNode = curr.left;
      if (leftNode != null) {
        TreeNode rightMostNode = getRightMostNode(leftNode, curr);
        if (rightMostNode.right != curr) {
          // create thread and move towards left tree
          rightMostNode.right = curr;
          curr = curr.left;
        } else {
          // if rightmostnode.right == null thatmeans left subtree is completely processed

          // 1. print the value
          ans.add(curr.val);
          // 2. break thread
          rightMostNode.right = null;
          // 3. move towards right
          curr = curr.right;
        }
      } else {
        // 1 print value
        ans.add(curr.val);
        // 2 move towards right
        curr = curr.right;
      }
    }

    return ans;
  }

  // 113. Path Sum II: https://leetcode.com/problems/path-sum-ii/
  private void pathSum(
    TreeNode root,
    int targetSum,
    ArrayList<Integer> list,
    int psum,
    ArrayList<ArrayList<Integer>> ans
  ) {
    if (root.left == null && root.right == null) {
      if (psum + root.val == targetSum) {
        // create a duplicate
        ArrayList<Integer> dup = new ArrayList<>();
        for (int v : list) {
          dup.add(v);
        }
        dup.add(root.val);
        list.add(root.val);
        ans.add(dup);
      }
      return;
    }
    list.add(root.val);
    pathSum(root.left, targetSum, list, psum + root.val, ans);
    pathSum(root.right, targetSum, list, psum + root.val, ans);
    list.remove(list.size() - 1);
  }

  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    pathSum(root, targetSum, new ArrayList<>(), 0, ans);
    return ans;
  }

  // 543. Diameter of Binary Tree: https://leetcode.com/problems/diameter-of-binary-tree/
  // method 1 -> with height call
  private int height(TreeNode root) {
    if (root == null) {
      return -1;
    }

    int lh = height(root.left);
    int rh = height(root.right);

    return Math.max(lh, rh) + 1;
  }

  public int diameter1(TreeNode root) {
    if (root == null) return 0;
    // diameter from root
    int lh = height(root.left);
    int rh = height(root.right);
    int rootDia = lh + rh + 2;

    // diameter from left and right
    int dl = diameter1(root.left);
    int dr = diameter1(root.right);

    return Math.max(rootDia, Math.max(dl, dr));
  }

  // method 2 -> with return height and static diameter variable, travel and change stretagy
  public static int diameter = 0;

  private static int diameter2(TreeNode root) {
    if (root == null) return -1;

    int lh = diameter2(root.left);
    int rh = diameter2(root.right);

    diameter = Math.max(diameter, lh + rh + 2);

    return Math.max(lh, rh) + 1;
  }

  // method 3 -> with wrapper class having diameter and height
  private static class DiaPair {
    int height;
    int diameter;

    DiaPair(int height, int diameter) {
      this.height = height;
      this.diameter = diameter;
    }

    DiaPair() {
      this.height = -1;
      this.diameter = 0;
    }
  }

  private static DiaPair diameter3(TreeNode root) {
    if (root == null) return new DiaPair();
    DiaPair lPair = diameter3(root.left);
    DiaPair rPair = diameter3(root.right);

    DiaPair mPair = new DiaPair();
    mPair.height = Math.max(lPair.height, rPair.height) + 1;
    mPair.diameter =
      Math.max(
        lPair.height + rPair.height + 2,
        Math.max(lPair.diameter, rPair.diameter)
      );

    return mPair;
  }

  public static int diameterOfBinaryTree(TreeNode root) {
    int res = 0;
    // res = diameter1(root);

    // diameter = 0;
    // diameter2(root);
    // res = diameter;
    // return res;

    res = diameter3(root).diameter;
  }

  // 863. All Nodes Distance K in Binary Tree: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

  private static ArrayList<TreeNode> node2RootPath(
    TreeNode node,
    TreeNode target
  ) {
    ArrayList<TreeNode> list = new ArrayList<>();
    if (node == null) return list;
    if (node.val == target.val) {
      list.add(node);
      return list;
    }

    ArrayList<TreeNode> lres = node2RootPath(node.left, target);
    if (lres.size() > 0) {
      lres.add(node);
      return lres;
    }

    ArrayList<TreeNode> rres = node2RootPath(node.right, target);
    if (rres.size() > 0) {
      rres.add(node);
      return rres;
    }

    return list;
  }

  public static void distanceK_(
    TreeNode root,
    TreeNode blockage,
    int k,
    ArrayList<Integer> res
  ) {
    if (root == null || root == blockage) return;
    if (k == 0) {
      res.add(root.val);
      return;
    }
    distanceK_(root.left, blockage, k - 1, res);
    distanceK_(root.right, blockage, k - 1, res);
  }

  public static ArrayList<Integer> distanceK(
    TreeNode root,
    TreeNode target,
    int k
  ) {
    ArrayList<TreeNode> nodeToRoot = node2RootPath(root, target);

    ArrayList<Integer> res = new ArrayList<>();
    TreeNode blockage = null;

    for (int i = 0; i < nodeToRoot.size() && k - i >= 0; i++) {
      TreeNode node = nodeToRoot.get(i);
      distanceK_(node, blockage, k - i, res);
      blockage = node;
    }
    return res;
  }

  private boolean hasPath(TreeNode root, int target, int ssf) {
    if (root == null) return false;
    if (root.left == null && root.right == null) {
      return ssf + root.val == target;
    }

    return (
      hasPath(root.left, target, ssf + root.val) ||
      hasPath(root.right, target, ssf + root.val)
    );
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    // if (root == null) return false;
    return hasPath(root, targetSum, 0);
  }
}
