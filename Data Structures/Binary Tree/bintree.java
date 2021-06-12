import java.util.*;
import java.util.Queue;
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
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.left = this.right = null;
            this.data = data;
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
        if(node == null) return Integer.MIN_VALUE;
        int ln = max(node.left);
        int rn = max(node.right);
        return Math.max(node.data, Math.max(ln, rn));
    }
    public static int min(Node node){
        if(node == null)    return Integer.MAX_VALUE;
        int ln = min(node.left);
        int rn = min(node.right);
        return Math.min(node.data, Math.min(ln, rn));
    }
    public static int height(Node node) {
        if(node == null)    return -1;
        int ln = height(node.left);
        int rn = height(node.right);
        return Math.max(ln, rn) + 1;
    }
    public static boolean find(Node node, int data){
        if(node == null) return false;
        if(node.data == data) return true;
        boolean lres = find(node.left,data);
        if(lres == true)    return true;

        boolean rres = find(node.right,data);
        if(rres == true)    return true;

        return false;
    }
    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    // write your code here
        if(node == null)    return new ArrayList<>();

        if(node.data == data){
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }
        ArrayList<Integer> lres = nodeToRootPath(node.left, data);
        if(lres.size()>0){
            lres.add(node.data);
            return lres;
        }

        ArrayList<Integer> rres = nodeToRootPath(node.right, data);
        if(rres.size()>0){
            rres.add(node.data);
            return rres;
        }
        return new ArrayList<>();
    }
    public static void printKLevelsDown(Node node, int k){
        // write your code here
        if(node == null) return;
        if(k == 0){
            System.out.println(node.data);
        }
        printKLevelsDown(node.left, k-1);
        printKLevelsDown(node.right, k-1);
    }
    public static ArrayList<Node> nodeToRoot_NodeVersion(Node node, int data){
        if(node == null) return new ArrayList<>();
        if(node.data == data){
            ArrayList<Node> bres = new ArrayList<>();
            bres.add(node);
            return bres;
        }
        ArrayList<Node> lres = nodeToRoot_NodeVersion(node.left, data);
        if(lres.size()>0){
            lres.add(node);
            return lres;
        }
        ArrayList<Node> rres = nodeToRoot_NodeVersion(node.right, data);
        if(rres.size()>0){
            rres.add(node);
            return rres;
        }
        return new ArrayList<>();
    }
    public static void printKDown(Node node, Node blockage, int k){
        if(node == null || node == blockage || k<0) return;
        if(k == 0){
            System.out.println(node.data);
            return;
        }
        printKDown(node.left, blockage, k-1);
        printKDown(node.right, blockage, k-1);
    }
    public static void printKNodesFar(Node root, int data, int k) {
        ArrayList<Node> n2rp = nodeToRoot_NodeVersion(root, data);
        Node blockage = null;
        for(int i=0; i<n2rp.size() && k>=0; i++){
            Node node = n2rp.get(i);
            printKDown(node,blockage,k);
            blockage = node;
            k--;
        }
    }
    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
        if(node == null) return;
        if(node.left != null && node.right != null){
            pathToLeafFromRoot(node.left, path +node.data + " ", sum+node.data, lo, hi);
            pathToLeafFromRoot(node.right, path + node.data + " ", sum+node.data, lo, hi);
        }else if(node.left != null){
            pathToLeafFromRoot(node.left, path + node.data + " ", sum+node.data, lo, hi);
        }else if(node.right != null){
            pathToLeafFromRoot(node.right, path + node.data + " ", sum+node.data, lo, hi);
        }else{
            //leaf node
            sum += node.data;
            path += node.data;
            if(lo<=sum && sum<=hi){
                System.out.println(path+" ");
            }
        }
    }
    public static void levelOrder(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while(qu.size() > 0){
            int sz = qu.size();
            while(sz-- > 0){
                // 1. Get + remove
                Node curr = qu.remove();
                // 2. Print
                System.out.print(curr.data+" ");
                // 3. add children
                if(curr.left != null)
                    qu.add(curr.left);
                if(curr.right != null)
                    qu.add(curr.right);
            }
            System.out.println();
        }
    }
    public static void iterativePrePostInTraversal(Node node) {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node,0));
        while(st.size() > 0){
            Pair p = st.peek();
            if(p.state == 0){
                // pre order + left child push
                pre.add(p.node.data);
                p.state++;
                if(p.node.left != null){   
                   st.push(new Pair(p.node.left,0)); 
                }
            }else if(p.state == 1){
                // in order + right child push
                in.add(p.node.data);
                p.state++;
                if(p.node.right != null){   
                   st.push(new Pair(p.node.right,0)); 
                }
            }else{
                //state == 2
                // post order + wipeout
                post.add(p.node.data);
                st.pop();
            }
        }
        for(int data : pre){
            System.out.print(data + " ");
        }
        System.out.println();
        for(int data : in){
            System.out.print(data + " ");
        }
        System.out.println();
        for(int data : post){
            System.out.print(data + " ");
        }
    }
    public static void recursivePrePostInTraversal(Node node) {
        if(node == null) return;
        System.out.println("Pre: "+ node.data+" "); 
        recursivePrePostInTraversal(node.left);
        System.out.println("In: " + node.data+" ");
        recursivePrePostInTraversal(node.right);
        System.out.println("Post: " + node.data+" ");
    }
    public static Node createLeftCloneTree(Node node){
        if(node == null) return null;
        Node lcn = createLeftCloneTree(node.left);
        Node rcn = createLeftCloneTree(node.right);
        Node nn = new Node(node.data,lcn,null);
        node.left = nn;
        node.right = rcn;
        return node;
    }
    public static Node transBackFromLeftClonedTree(Node node){
        if(node == null) return null;
        Node lcn = transBackFromLeftClonedTree(node.left.left);
        Node rcn = transBackFromLeftClonedTree(node.right);
        node.left = lcn;
        node.right = rcn;
        return node;
    }
    public static void printSingleChildNodes(Node node, Node parent){
        if(node == null)    return;
        if(parent != null && parent.left == node && parent.right == null){
            //i am single left child of my parent
            System.out.println(node.data);
        }
        if(parent != null && parent.right == node && parent.left == null){
            //i am single right child of my parent
            System.out.println(node.data);
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }
    static int tilt = 0;
    public static int sumForTilt(Node node){
        if(node == null)    return 0;
        int lsum = sumForTilt(node.left);
        int rsum = sumForTilt(node.right);

        //add contribuition in tilt variable
        tilt += Math.abs(lsum - rsum);
        return lsum + rsum + node.data;
    }
    public static int tilt(Node node){
        if(node == null)    return 0;
        tilt = 0;
        sumForTilt(node);
        return tilt;
    }
    public static Node removeLeaves(Node node){
        if(node == null)    return null;
        if(node.left != null && (node.left.left == null && node.left.right == null)){
            node.left = null;
        }
        if(node.right!= null && (node.right.left == null && node.right.right == null)){
            node.right = null;
        } 
        removeLeaves(node.left);
        removeLeaves(node.right);
        return node;
    }
    public static Node removeLeaves2(Node node){
        if(node == null) return null;
        if(node.left != null && node.right != null){
            node.left = removeLeaves2(node.left);
            node.right = removeLeaves2(node.right);
        }else if(node.left != null){
            node.left = removeLeaves2(node.left);
        }else if(node.right != null){
            node.right = removeLeaves2(node.right);
        }else{
            //leaf node --> removal
            node = null;
        }
        return node;
    }
    public static int diameter = 0;
    public int heightForDiameter(TreeNode root){
        if(root == null)    return -1;
        int lh = heightForDiameter(root.left);
        int rh = heightForDiameter(root.right);
        diameter = Math.max(diameter, lh+rh+2);
        return Math.max(lh,rh) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root){
        diameter = 0;
        heightForDiameter(root);
        return diameter;
    }
    public static boolean isBST1(Node node){
        // o(n^2) since we are checking traverlling through entire tree in min and max calculation
        if(node == null)    return true;
        //self check
        int lnmax = max(node.left);
        int rnmin = min(node.right); 

        if(lnmax > node.data || rnmin < node.data) return false;

        //left check && right check
        return isBST1(node.left) && isBST1(node.right);
    }
    public static class BSTPair{
        boolean isBST;
        int min;
        int max;
        int size;
        public BSTPair(){
            this.isBST = true;
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
            this.size = 0;
        }
        public BSTPair(boolean isBST, int min, int max, int size){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    //O(n)
    public static BSTPair isBST2(Node node){
        if(node == null)    return new BSTPair();
        BSTPair isleftBST = isBST2(node.left);
        BSTPair isrightBST = isBST2(node.right);
        boolean status = isleftBST.max < node.data && isrightBST.min > node.data;
        BSTPair mres = new BSTPair();
        mres.max = Math.max(node.data, Math.max(isleftBST.max, isrightBST.max));
        mres.min = Math.min(node.data, Math.min(isleftBST.min, isrightBST.min));
        mres.isBST = isleftBST.isBST && isrightBST.isBST && status;
        return mres;
    }
    public static class BPair{
        int ht;
        boolean isBalanced;
        public BPair(){
            ht = -1;
            isBalanced = true;
        }
        public BPair(int ht, boolean isBalanced){
            this.ht = ht;
            this.isBalanced = isBalanced;
        }
    }
    public static BPair isBalancedTree(Node node){
        if(node == null)    return new BPair();
        BPair ln = isBalancedTree(node.left);
        BPair rn = isBalancedTree(node.right);
        boolean status = Math.abs(ln.ht-rn.ht) <= 1;
        BPair mres = new BPair();
        mres.ht = Math.max(ln.ht, rn.ht) + 1;
        mres.isBalanced = status && ln.isBalanced && rn.isBalanced;
        return mres;
    }
    
    static int sz = 0;
    static Node bstNode = null;
    public static BSTPair bstSubtree(Node node){
        if(node == null)   return new BSTPair();
        
        BSTPair lres = bstSubtree(node.left);
        BSTPair rres = bstSubtree(node.right);

        boolean status = lres.max < node.data && rres.min > node.data;
        BSTPair mres = new BSTPair();
        mres.max = Math.max(node.data, Math.max(lres.max, rres.max));
        mres.min = Math.min(node.data, Math.min(lres.min, rres.min));
        mres.isBST = lres.isBST && rres.isBST && status;
        mres.size = lres.size + rres.size + 1;
        if()
    }
    public static void func(){
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        // Integer[] arr = {50,null};
        Node root = construct(arr);
        
        display(root);
        pathToLeafFromRoot(root,"",0,100,250);
        // System.out.println("Size: "+size(root));
        // System.out.println("Sum: "+sum(root));
        // System.out.println("Max: "+ max(root));
        // System.out.println("Height: "+ height(root));
        // levelOrder(root);
        // recursivePrePostInTraversal(root);
        iterativePrePostInTraversal(root);
        System.out.println(removeLeaves(root));
        System.out.println(isBST2(root).isBST);
    }
    public static void main(String[] args){
        func();
    }
}