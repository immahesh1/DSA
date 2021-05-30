import java.util.*;
public class gentree{
    public static class Node{
        int data;
        ArrayList<Node> children;

        public Node(){
            data = 0;
            this.children = new ArrayList<>();
        }
        public Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    public static Node construct(Integer[] arr){
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            Integer data = arr[i];
            if(data != null){
                Node nn = new Node(data);
                if(st.size() == 0){
                    root = nn;
                    st.push(nn);
                }else{
                    st.peek().children.add(nn);
                    st.push(nn);
                }
            }else{
                st.pop();
            }
        }
        return root;
    }
    public static void display(Node root){
        String str = "["+root.data+"]->";
        for(Node child:root.children){
            str += child.data +", ";
        }
        System.out.println(str+". ");
        for(int i=0; i<root.children.size(); i++){
            Node child = root.children.get(i);
            display(child);
        }
    }
    public static int size(Node root){
        int sz = 0;
        for(Node child: root.children){
            sz+=size(child);
        }
        return sz + 1;
    }
    public static int max(Node root){
        int mx = Integer.MIN_VALUE;
        for(Node child:root.children){
            mx = Math.max(mx, max(child));
        }
        return Math.max(mx, root.data);
    }
    public static int min(Node root){
        int mn = Integer.MAX_VALUE;
        for(Node child:root.children){
            mn = Math.min(mn, min(child));
        }
        return Math.max(mn, root.data);
    }
    public static int height(Node node) {
        // write your code here
        int ht = -1;
        for(Node child:node.children){
            ht = Math.max(ht,height(child));
        }
        return ht+1;
    }
    public static void traversals(Node node){
        //node pre
        System.out.println("Node Pre "+node.data);

        for(Node child : node.children){
            //pre call -> edge pre
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            //call
            traversals(child);
            //post call -> edge post
            System.out.println("Edge Post "+node.data+"--"+child.data);
        }

        //node post
        System.out.println("Node Post "+node.data);
    }
    public static void levelOrder(Node node){
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while(qu.size() > 0){
            //1. get and remove
            Node rem = qu.remove();
            //2. Print
            System.out.print(rem.data+" ");
            //3. add children
            for(Node child : rem.children){
                qu.add(child);
            }
        }
        System.out.println(".");
    }
    //level order using two queue
    public static void levelOrderLinewise(Node node){
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();
        mainQ.add(node);
        while(mainQ.size() > 0){
            Node rem = mainQ.remove();
            System.out.print(rem.data+" ");
            for(Node child:rem.children){
                childQ.add(child);
            }
            if(mainQ.size() == 0){
                System.out.println();
                Queue<Node> tmp;
                tmp = mainQ;
                mainQ = childQ;
                childQ = tmp;
            }
        }
    }
    //level order using delimiter (null)
    public static void levelOrderLinewiseDelimiter(Node node){
        Queue<Node> qu = new LinkedList<>();
        qu.add(node);
        qu.add(null);
        while(qu.size() > 0){
            // 1. get + remove
            Node rem = qu.remove();
            if(rem == null){
                //2. hit enter
                System.out.println();
                //3. if size more than zero add null
                if(qu.size() > 0){
                    qu.add(null);
                }
            }else{
                //2. print data
                System.out.println(rem.data+" ");
                //3. add children
                for(Node child : rem.children){
                    qu.add(child);
                }
            }
        }
    }
    public static void levelOrderLinewiseZZ(Node node){
        Stack<Node> mainS = new Stack<>();
        Stack<Node> childS = new Stack<>();
        mainS.push(node);
        int lvl = 1;
        while(mainS.size() > 0){
            while(mainS.size() > 0){
                Node rem = mainS.pop();
                System.out.println(rem.data+" ");
                if(lvl % 2 == 1){
                    //odd level -> left to right
                    for(Node child : rem.children){
                        childS.push(child);
                    }
                }else{
                    //even level -> right to left
                    
                }
            }
        }
    }
    public static void levelOrderLinewiseZZ2(Node node){
        System.out.println("Yes i am coming inside");
        Stack<Node> mainS = new Stack<>();
        Stack<Node> childS = new Stack<>();
        mainS.push(node);
        int lvl = 1;
        while(mainS.size() > 0){
            lvl++;
            while(mainS.size() > 0){
                Node cn = mainS.pop();
                System.out.print(cn.data+" ");
                //for level even: left -> right
                if(lvl % 2 == 0){
                    for(int i=0; i<cn.children.size(); i++){
                        childS.push(cn.children.get(i));
                    }
                }else{
                    for(int i=cn.children.size()-1; i>=0; i--){
                        childS.push(cn.children.get(i));
                    }
                }
            }
            System.out.println();
            Stack<Node> tmp = mainS;
            mainS = childS;
            childS = tmp;
        }
    } 
    public static void mirror(Node node){
        for(Node child : node.children){
            mirror(child);
        }
        //reverse
        int left = 0;
        int right = node.children.size() - 1;
        while(left < right){
            Node tmp = node.children.get(left);
            node.children.set(left,node.children.get(right));
            node.children.set(right, tmp);
            left++;
            right--; 
        }
    }
    public static void removeLeaves(Node node) {
        //pre order removal
        for(int i=node.children.size()-1; i>=0; i--){
            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(i);
            }
        }
        for(Node child : node.children){
            removeLeaves(child);
        }

        //not using remove
        // ArrayList<Node> al = new ArrayList<>();

    }
    public static Node getTail(Node node){
        Node tail = null;
        while(tail.children.size() != 0){
            tail = tail.children.get(0);
        }
         return tail;
    }
    public static void linearize(Node node){
        for(Node child : node.children){
            linearize(child);
        }
        for(int i=node.children.size()-2; i>=0; i--){
            Node last = node.children.get(i+1);
            Node slast = node.children.get(i);

            node.children.remove(i+1);
            //problem in this solution is
            //getting tail node is taking almost n^2 time
            Node tail = getTail(slast);
            tail.children.add(last);
        }
    }
    public static boolean find(Node node, int data) {
        if(node.data == data) return true;
        boolean res = false;
        for(Node child : node.children){
            res = find(child,data);
            if(res == true) return true;
            //res = res || find(child,data);
        }
        return res;
    }
    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }
        for(Node child : node.children){
            ArrayList<Integer> ret = nodeToRootPath(child, data);
            if(ret.size() > 0){
                ret.add(node.data);
                return ret;
            }   
        }
        return new ArrayList<Integer>();
    }
    public static int lca(Node node, int d1, int d2) {
        // write your code here
        ArrayList<Integer> r1 = nodeToRootPath(node,d1);
        ArrayList<Integer> r2 = nodeToRootPath(node,d2);
        int i=r1.size()-1; int j = r2.size()-1;
        int res = -1;
        while(i>=0 && j>=0 && r1.get(i) == r2.get(j)){
            res = r1.get(i);
            i--; j--;
        } 
        return res;   
    }
    public static int distanceBetweenNodes(Node node, int d1, int d2){
        ArrayList<Integer> r1 = nodeToRootPath(node, d1);
        ArrayList<Integer> r2 = nodeToRootPath(node, d2);
        int i = r1.size() - 1;
        int j = r2.size() - 1;
        while(i>=0 && j>=0 && r1.get(i) == r2.get(j)){
            i--;
            j--;
        }
        return i + j + 2;
    }
    public static boolean areSimilar(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()) return false;
        boolean res = true;
        for(int i=0; i<n1.children.size(); i++){
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(i);
            res = areSimilar(child1, child2);
            if(res == false) return false;
        }
        return res;
    }
    public static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()) return false;
        int sz = n1.children.size();
        boolean res = true;
        for(int i=0; i < sz; i++){
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(sz-i-1);

            res = areMirror(child1, child2);
            if(res == false)    return false;
        }
        return res;
    }
    public static boolean IsSymmetric(Node node) {
        return areMirror(node, node);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~ Multisolver 2
    public static class MultiSolver{
        int min;
        int max;
        int ht;
        int size;
        public MultiSolver(int min, int max, int ht, int size){
            this.min = min;
            this.max = max;
            this.ht = ht;
            this.size = size;
        }
        public MultiSolver(){
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.ht = -1;
            this.size = 0;
        }
    }

    public static MultiSolver multiSolver2(Node node){
        MultiSolver mres = new MultiSolver(node.data, node.data,-1,1);
        for(Node child : node.children){
            MultiSolver rres = multiSolver2(child);
            mres.min = Math.min(mres.min, rres.min);
            mres.max = Math.max(mres.max, rres.max);
            mres.ht = Math.max(mres.ht, rres.ht);
            mres.size += rres.size;
        }
        mres.ht += 1;
        return mres;
    }
    public static void multiSolution(Node node){
        MultiSolver ms = multiSolver2(node);
        System.out.println("Min: "+ ms.min);
        System.out.println("Max: "+ ms.max);
        System.out.println("Height: "+ ms.ht);
        System.out.println("Size: "+ ms.size);
    }
    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data) {
        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }
    
        if(node.data < data){
            if(node.data > floor){
                floor = node.data;
            }
        }
    
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }
    
    public static int kthLargest(Node node, int k){
        int data = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            floor = Integer.MIN_VALUE;
            ceilAndFloor(node,data);
            data = floor;
        }
        return data;
    }
    public static int maxSum = Integer.MIN_VALUE;
    public static int nodeData = 0;
    public static int treeSum(Node node){
        int sum = 0;
        for(Node child : node.children){
            sum += treeSum(child);
        }
        sum += node.data;
        if(sum>maxSum){
            maxSum = sum;
            nodeData = node.data;
        }
        return sum;
    }
    public static int diameter1(Node node){
        int mh = -1;
        int smh = -1;
        for(Node child : node.children){
            int ht = height(child);
            if(ht>=mh){
                smh = mh;
                mh = ht;
            }else if(ht>smh){
                smh = ht;
            }
        }
        int dfc = 0; //diameter from child
        for(Node child : node.children){
            dfc = Math.max(diameter1(child),dfc);
        }
        return Math.max(dfc, mh+smh+2);
    }
    public static int diameter = 0;
    public static int heightForDiameter(Node node){
        int maxHt = -1;     //maximum height
        int smaxHt = -1;    //second maximum height
        for(Node child : node.children){
            int ht = heightForDiameter(child);
            if(ht >= maxHt){
                smaxHt = maxHt;
                maxHt = ht;
            }else if(ht>smaxHt){
                smaxHt = ht;
            }
        }
        diameter = Math.max(diameter,maxHt+smaxHt+2);
        
        //for height
        return maxHt + 1;
    }
    public static void func(){
        Integer[] data = {10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null, null, 40, 100, null, null, null};
        Node root = construct(data);
        // display(root);
        // levelOrder(root);
        // levelOrderLinewise(root);
        // levelOrderLinewiseZZ2(root);
        // int res = distanceBetweenNodes(root, 110, 100);
        // System.out.println(res);
        multiSolution(root);
    }
    public static void main(String[] args){
        func();
    }
}