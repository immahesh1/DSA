import java.util.ArrayList;

public class Bst{
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node construction(int[] arr, int lo, int hi){
        if(lo > hi) return null;
        int mid = (lo+hi)/2;
        Node root = new Node(arr[mid]);
        Node ln = construction(arr, lo, mid-1);
        Node rn = construction(arr, mid+1, hi);
        root.left = ln;
        root.right = rn;
        return root;
    }
    public static void display(Node node){
        if(node == null) return;
        String str = node.left == null ? " ." : "" + node.left.data;
        str += " <- ["+node.data+"] -> ";
        str += node.right == null ? " ." : node.right.data;
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static int size(Node node) {
        if(node == null) return 0;
        int ls = size(node.left);
        int rs = size(node.right);
        return ls + rs + 1;
    }
    public static int sum(Node node) {
        if(node == null) return 0;
        return sum(node.left) + sum(node.right) + node.data;
    }
    public static int max(Node node) {
        if(node == null){
            return Integer.MIN_VALUE;
        }
        else if(node.right != null){
            return max(node.right);
        }else{
            //node.right == null
            return node.data;
        }
    }
    public static int min(Node node) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }else if(node.left == null){
            return node.data;
        }else{
           return min(node.left);
        }
    }
    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }else if(data > node.data){
            return find(node.right,data);
        }else if(data < node.data){
            return find(node.left,data);
        }else{
            //when node.data == data
            return true;
        }
    }
    public static Node add(Node node, int data) {
        if(node == null){
            Node nn = new Node(data,null,null);
            return nn;
        }else if(data > node.data){
            node.right = add(node.right,data);
        }else if(data < node.data){
            node.left = add(node.left,data);
        }else{
            //for ignoring if same data comes
        }
        return node;
    }
    static int sum = 0;
    public static void rwsol(Node node){
        if(node == null) return;
        //1. right call (reverse inorder)
        rwsol(node.right);
        //2. 
        int data = node.data;
        node.data = sum;
        sum += data;
        rwsol(node.left);
    }
    public static int lca(Node node, int d1, int d2) {
        if(d1>node.data && d2 > node.data){
            //right call
            return lca(node.right,d1,d2);
        }else if(d1<node.data && d2<node.data){
            return lca(node.left,d1,d2);
        }else{
            return node.data;
        }
    }
    public static void pir(Node node, int d1, int d2) {
        if(node == null) return;
        if(d1>node.data && d2 > node.data){
            //right call
            pir(node.right,d1,d2);
        }else if(d1<node.data && d2<node.data){
            pir(node.left,d1,d2);
        }else{
            pir(node.left,d1,d2);
            System.out.println(node.data);
            pir(node.right,d1,d2);
        }
    }
    // Method 1: time: O(nh) space: O(h)
    public static void printTargetSumPair1(Node node, Node root, int target){
        if(node == null) return;
        int n1 = node.data;
        int n2 = target - n1;
        printTargetSumPair1(node.left, root, target);
        if(n1<n2 && find(root, n2) == true){
            System.out.println(n1 +" "+n2);
        }
        printTargetSumPair1(node.right, root, target);
    }
    // Method 2 : time: O(n) space: O(n)
    public static void inorderFiller(Node node, ArrayList<Integer> al){
        if(node == null)    return;
        inorderFiller(node.left, al);
        al.add(node.data);
        inorderFiller(node.right, al);
    }
    public static void printTargetSumPair2(Node node, int target){
        ArrayList<Integer> al = new ArrayList<>();
        inorderFiller(node, al);
        int lp = 0;
        int rp = al.size() - 1;
        while(lp<rp){
            int ld = al.get(lp);
            int rd = al.get(rp);
            if(ld + rd > target){
                rp--;
            }else if(ld + rd < target){
                lp++;
            }else{
                System.out.println(ld+" "+rd);
                lp++;   rp--;
            }
        }
    }
    public static void fun(){
        int[] arr = {10,20,30,40,50,60,70,80,90};
        Node root = construction(arr, 0, arr.length-1);
        display(root);
        System.out.println("Size: "+ size(root));
        System.out.println("Sum: "+ sum(root));
        System.out.println("Max: " + max(root));
        System.out.println("Min: " + min(root));
        System.out.println("Find: " + find(root,80));
        printTargetSumPair1(root, root, 100);
        System.out.println("Method 2");
        printTargetSumPair2(root, 100);
    }
    public static void main(String[] args){
        fun();
    }
}
