import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  static class TreeNode {
    int val;
    TreeNode left = null, right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  //   public static TreeNode buildTree(int[] inorder, int[] levelOrder)

  public static TreeNode constructTreeLevel(
    int[] in,
    ArrayList<Integer> level,
    int inSt,
    int inEnd
  ) {
    if (level.size() == 0) return null;
    TreeNode root = new TreeNode(level.get(0));

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

  public static TreeNode buildTree(int inord[], int level[]) {
    ArrayList<Integer> al = new ArrayList<>();
    for (int e : level) al.add(e);
    return constructTreeLevel(inord, al, 0, inord.length - 1);
  }

  // input_section=================================================

  public static void display(TreeNode node) {
    if (node == null) return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);
  }

  public static void solve() {
    int n = scn.nextInt();

    int[] InOrder = new int[n];
    for (int i = 0; i < n; i++) InOrder[i] = scn.nextInt();

    int[] LevelOrder = new int[n];
    for (int i = 0; i < n; i++) LevelOrder[i] = scn.nextInt();

    TreeNode root = buildTree(InOrder, LevelOrder);
    display(root);
  }

  public static void main(String[] args) {
    solve();
  }
}
