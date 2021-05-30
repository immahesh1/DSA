import java.util.*;
class Revision{
    public static int[] nge(int[] ar){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] res = new int[ar.length];
        for(int i=1; i<ar.length; i++){
            if(ar[i]<ar[st.peek()]){
                st.push(i);
            }else{
                while(st.size()> 0 && ar[st.peek()]<ar[i]){
                    res[st.pop()] = ar[i];
                }
                st.push(i);
            }
        }
        while(st.size()>0){
            res[st.pop()] = -1;
        }
        return res;
    }
    public static void fun(){
        int[] ar = {2,5,9,3,1,12,6,8,7};
        int[] res = nge(ar);
        for(int r:res){
            System.out.print(r+" ");
        }
    }
    public static void main(String[] args){
        fun();
    }
}