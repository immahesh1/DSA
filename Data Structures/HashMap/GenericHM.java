import java.util.ArrayList;
import java.util.LinkedList;
class hash_map<K,V>{
    private class Node{
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Node>[] bucket;
    private int size = 0;

    public void init(int cap){
        bucket = new LinkedList[cap];
        // initialize every location of bucket because it is a linked list
        for(int i=0; i<cap; i++){
            bucket[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    public hash_map(){
        init(4);
    }
    
    private int hashFunc(K key){
        int bi = Math.abs(key.hashCode()) % bucket.length;
        return bi;
    }

    private int searchInBucket(K key, int bi){
        int di = 0;
        for(Node node : bucket[bi]){
            if(node.key.equals(key) == true){
                return di;
            }
            di++;
        }
        return -1;
    }

    public void hashmapView() {
        for(int bi = 0; bi < bucket.length; bi++) {
            System.out.print("bucket : " + bi + " -> ");
            for(Node node : bucket[bi]) {
                System.out.print("[" + node.key + " = " + node.value + "], ");
            }
            System.out.println(".");
        }
    }

    public void put(K key, V value){
        // first get the bucket index (bi)
        int bi = hashFunc(key);

        // search if key is present in that index
        int di = searchInBucket(key, bi);

        if(di == -1){
            // key is not present
            Node nn = new Node(key,value);
            bucket[bi].addLast(nn);
            this.size++;
        }else{
            // key is present -> update value
            bucket[bi].get(di).value = value;
        }
    }

    public V get(K key){
        // first get the bucket index (bi)
        int bi = hashFunc(key);

        // search if key is present in that index
        int di = searchInBucket(key, bi);

        if(di == -1){
            return null;
        }else{
            // get node from linkedlist
            Node node = bucket[bi].get(di);
            return node.value;
        }
    }

    public V remove(K key){
        int bi = hashFunc(key);
        int di = searchInBucket(key, bi);
        if(di == -1){
            // System.out.println("Queue underflow");
            return null;
        }else{
            Node node = bucket[bi].remove(di);
            size--;
            return node.value;
        }
    }
    public boolean containsKey(K key){
        // first get the bucket index (bi)
        int bi = hashFunc(key);

        // search if key is present in that index
        int di = searchInBucket(key, bi);

        if(di == -1){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<K> keySet(){
        ArrayList<K> al = new ArrayList<>();

        for(int bi=0; bi<bucket.length; bi++){
            for(Node node : bucket[bi]){
                al.add(node.key);
            }
        }
        return al;
    }
    public int size(){
        return this.size;
    }

    public void display(){
        for(int bi=0; bi<bucket.length; bi++){
            for(Node node : bucket[bi]){
                System.out.println("[" + node.key + " : " + node.value + "]");
            }
        }
        System.out.println(" .");
    }
}

public class GenericHM{
    public static void func(){
        hash_map<String, Integer> map = new hash_map<>();
        map.put("india", 140);
        map.put("pak", 40);
        map.put("US", 80);
        map.put("Aus", 36);
        map.display();
        map.hashmapView();
        System.out.println("*******");
        map.put("india", 150);
        map.put("NZ", 10);
        System.out.println(map.containsKey("india"));
        System.out.println("Remove: "+map.remove("pak"));
        map.display();
        map.hashmapView();
    }
    public static void main(String[] args){
        func();
    }
}