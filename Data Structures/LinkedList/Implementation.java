

class linkedList {
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
    public linkedList(){
        this.head = this.tail = null;
        this.size = 0;
    }
    public void addWhenSize0(int data){
        Node nn = new Node(data);
        this.head = this.tail = nn;
        this.size++;
    }
    public void addFirst(int data){
        if(this.size == 0){
            addWhenSize0(data);
        }else{
            Node nn = new Node(data);
            nn.next = this.head;
            this.head = nn;
            this.size++;
        }
    }
    public void addLast(int data){
        if(this.size == 0){
            addWhenSize0(data);
        }else{
            Node nn = new Node(data);
            this.tail.next = nn;
            this.tail = nn;
            this.size++;
        }
    }
    private Node getNthPlus1Node(int pos){
        Node tmp = this.head;
        for(int i=0; i<pos; i++){
            tmp = tmp.next;
        }
        return tmp;
    }
    public void addAt(int data, int idx){
        if(idx<0 || idx>this.size){
            System.out.println("Invalid position");
        }else if(idx == 0){
            addFirst(data);
        }else if(idx == this.size){
            addLast(data);
        }else{
            Node nm1 = getNthPlus1Node(idx-1);
            Node nn = new Node(data); 
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
        if(size==0){
            System.out.println("Nothing to print");
        }else{
            Node tmp = new Node();
            tmp = this.head;
            while(tmp.next != null){
                System.out.print(tmp.data+"->");
                tmp = tmp.next;
            }
            System.out.println(tmp.data);
        }
    }

    public static void LinkedListImp(){
        linkedList ll = new linkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addAt(100, 2);
        ll.display();
        // System.out.println(ll.getNthNode(1).data);
        System.out.println(ll.size);
        System.out.println(ll.getFirst()+" "+ll.getLast());
    }
    public static void main(String[] args){
        LinkedListImp();
    }
}
