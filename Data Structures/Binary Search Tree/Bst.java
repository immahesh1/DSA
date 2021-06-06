import java.util.*;

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
    public static void fun(){
        int[] arr = {10,20,30,40,50,60,70,80,90};
        Node root = construction(arr, 0, arr.length-1);
        display(root);
        System.out.println("Size: "+ size(root));
        System.out.println("Sum: "+ sum(root));
        System.out.println("Max: " + max(root));
        System.out.println("Min: " + min(root));
        System.out.println("Find: " + find(root,80));
    }
    public static void main(String[] args){
        fun();
    }
}
