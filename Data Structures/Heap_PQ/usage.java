import java.util.*;
class usage{
    public static void kLargestElement(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 1. add k elements
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        // 2. process rest elements
        for(int i=k; i<arr.length; i++){
            if(arr[i]>pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        // 3. print
        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }
    public static void sortKsorted(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        for(int i=k; i<arr.length; i++){
            pq.add(arr[i]);
            System.out.println(pq.remove());
        }
        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }
    public static void demo(){
        // Min PQ -- Default PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(7);
        pq.add(40);
        pq.add(17);
        while(pq.size() > 0){
            int rem = pq.remove();
            System.out.println(rem);
        }
        System.out.println("***********************");
        // Max PQ
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq1.add(10);
        pq1.add(20);
        pq1.add(7);
        pq1.add(40);
        pq1.add(17);
        while(pq1.size() > 0){
            int rem = pq1.remove();
            System.out.println(rem);
        }
    }
    public static void main(String[] args){
        // demo();
    }
}