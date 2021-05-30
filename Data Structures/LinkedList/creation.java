import java.util.*;

class linkedlist{
    private class Node{
        private int data;
        private Node next;
        
        public Node(){
            this.data = 0;
            this.next = null;
        }
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public linkedlist(){
        this.head = this.tail = null;
        this.size = 0;
    }
    public void handleAddWhenSize0(int val){
        Node nn = new Node(val);
        this.head = this.tail = nn;
        this.size++;
    }
    public void addFirst(int val){
        if(size == 0){
            handleAddWhenSize0(val);
        }else{
            Node nn = new Node(val);
            nn.next = head;
            this.head = nn;
            this.size++;
        }
    }
    public void addLast(int val){
        if(size == 0){
            handleAddWhenSize0(val);
        }else{
            Node nn = new Node(val);
            this.tail.next = nn;
            this.tail = nn;
            this.size++;
        }
    }
    private Node getNthNode(int pos){
        Node tmp = this.head;
        for(int i=0; i<pos; i++){
            tmp = tmp.next;
        }
        return tmp;
    }
    public void addAt(int val,int idx){
        if(idx<0 || idx>this.size){
            System.out.println("Invalid position");
        }else if(idx == 0){
            addFirst(val);
        }else if(idx == this.size){
            addLast(val);
        }else{
            Node nm1 = getNthNode(idx-1);
            Node nn = new Node(val);

            nn.next = nm1.next;
            nm1.next = nn;
            this.size++;
        }
    }
    public int getFirst(){
        if(this.size == 0){
            return -1;
        }
        return this.head.data;
    }
    public int getLast(){
        if(this.size == 0){
            return -1;
        }
        return this.tail.data;
    }
    public void display(){
        
    }
}

class creation{
    public static void ques(){

    }
    public static void main(String[] args) {
        ques();
    }
}