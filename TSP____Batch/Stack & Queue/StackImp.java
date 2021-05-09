import java.util.*;
class stack{
    private int[] ar;
    
    private int size = 0;
    
    public stack(int capacity){
        ar = new int[capacity];
    }

    public void push(int val){
        if(this.size == ar.length){
            System.out.println("StackOverflow");
        }
        ar[this.size] = val;
        this.size++;
    } 
    
    public int pop(){
        if(this.size == 0){
            System.out.println("StackUnderFlow");
            return -1;
        }
        int value = ar[this.size-1];
        this.size--;
        return value;
    }

    public int peek(){
        if(this.size == 0){
            System.out.println("StackUnderFlow");
            return -1;
        }
        int value = ar[this.size];
        return value;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }
    
    public void display(){
        System.out.print("[");
        for(int i=0; i<this.size-1; i++){
            System.out.print(ar[i]+", ");
        }
        if(this.size-1>=0)
            System.out.print(ar[this.size-1]);
        System.out.println("]");
    }
}
public class StackImp{
    public static void main(String[] args){
        Ques st = new Ques(10);
        st.push(5);
        st.push(15);
        st.push(52);
        st.push(54);
        st.display();
        while(!st.isEmpty()){
            // System.out.println(st.peek());
            System.out.println("pop => "+st.pop());
            st.display();
        }

    }
}