import java.util.ArrayList;

class priorityqueue{
    private ArrayList<Integer> data;
    private boolean flag;
    
    // flag = true -> max priority
    // flag = false -> min priority
    public priorityqueue(){
        data = new ArrayList<>();
        flag = false;
    }
    public priorityqueue(boolean flag){
        this.flag = flag;
        data = new ArrayList<>();
    }

    private int checkPriority(int ci, int pi){
        // ci: child index
        // pi: parent index
        if( flag == true){
            // for max PQ
            if(data.get(ci) > data.get(pi)){
                return 1;
            }else{
                if(data.get(ci)< data.get(pi)){
                    return 1;
                }
            }
        }
        return 0;
    }
    public void swap(int i, int j){
        int tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }
    public void upheapify(int idx){
        if(idx == 0) return;
        int pi = (idx - 1) / 2;
        if(data.get(idx) < data.get(pi)){
            swap(idx, pi);
            upheapify(pi);
        }
    }
    public void add(int val){
        data.add(val);
        // maintain heap order property
        upheapify(data.size() - 1);
    }

    public void downheapify(int idx){
        int minIdx = idx;
        int lci = 2 * idx + 1;
        int rci = 2 * idx + 2;
        if(lci < data.size() && data.get(minIdx) > data.get(lci)){
            minIdx = lci;
        }
        if(rci < data.size() && data.get(minIdx) > data.get(rci)){
            minIdx = rci;
        }
        if(minIdx != idx){
            swap(idx,minIdx);
            downheapify(minIdx);
        }
    }
    public int remove(){
        if(data.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        swap(0, data.size()-1);
        int val = data.remove(data.size()-1);
        // maintain downheapify
        downheapify(0);
        return val;
    }

    public int peek(){
        if(data.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        return data.get(0);
    }

    public int size(){
        return data.size();
    }
    public void display(){
        System.out.println(data);
    }
}
public class creation {
    public static void main(String[] args){

    }    
}
