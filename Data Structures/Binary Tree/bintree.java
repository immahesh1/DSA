import java.util.*;
public class bintree{
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node node;
        int state;
        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,0));
        int idx = 0;
        while(st.size()>0){
            Pair p = st.peek();
            if(p.state == 0){
                idx++;
                if(arr[idx] != null){
                    Node nn = new Node(arr[idx]);
                    p.node.left = nn;
                    st.push(new Pair(nn,0));
                }
                p.state++;
            }else if(p.state == 1){
                idx++;
                if(arr[idx] != null){
                    Node nn = new Node(arr[idx]);
                    p.node.right = nn;
                    st.push(new Pair(nn,0));
                }
                p.state++;
            }else{
                st.pop();
            }
        }
        return root;
    }
    public static void display(Node root) {
        if (root == null)
            return;

        String str = root.left == null ? " ." : "" + root.left.data;
        str += " <- [" + root.data + "] -> ";
        str += root.right == null ? ". " : root.right.data;
        System.out.println(str);

        display(root.left);
        display(root.right);
    }
    public static int size(Node node) {
        if(node == null) return 0;
        int ln = size(node.left);
        int rn = size(node.right);
        return ln + rn + 1;    
    }
    public static int sum(Node node) {
    // write your code here
        if(node == null) return 0;
        int ln = sum(node.left);
        int rn = sum(node.right);
        return ln + rn + node.data;
    }
    public static int max(Node node) {
    // write your code here
        if(node == null) return 0;
        int ln = max(node.left);
        int rn = max(node.right);
        return Math.max(node.data, Math.max(ln, rn));
    }
    public static int height(Node node) {
        if(node == null)    return -1;
        int ln = height(node.left);
        int rn = height(node.right);
        return Math.max(ln, rn) + 1;
    }
    public static void func(){
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = construct(arr);
        
        display(root);
        System.out.println("Size: "+size(root));
        System.out.println("Sum: "+sum(root));
        System.out.println("Max: "+ max(root));
        System.out.println("Height: "+ height(root));
    }
    public static void main(String[] args){
        func();
    }
}