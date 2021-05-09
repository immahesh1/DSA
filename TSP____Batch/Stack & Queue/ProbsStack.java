import java.util.Stack;

public class ProbsStack {
    
    //Next greater index to the right
    public static int[] ngir(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1; i<arr.length; i++){
            while(st.size() > 0 && arr[i]>arr[st.peek()]){
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()] = arr.length;
        }
        return res;
    }
    public static int[] ngil(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2; i>=0; i--){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()] = -1;
        }
        return res;
    }
    public static int[] nlir(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1; i<arr.length; i++){
            while(st.size() > 0 && arr[i]<arr[st.peek()]){
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()] = -1;
        }
        return res;
    }
    public static int[] nlil(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2; i>=0; i--){
            while(st.size()>0 && arr[i]<arr[st.peek()]){
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()] = -1;
        }
        return res;
    }
    public static void display1DArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int largestAreaHistogram(int[] arr){
        int area = 0;
        int[] lsi = leftSmallerIndex(arr);
        int[] rsi = rightSmallerIndex(arr);
        for(int i=0; i<arr.length; i++){
            int width = rsi[i] - lsi[i] - 1;
            int height = arr[i];
            
            area = Math.max(area,width*height);
        }
        return area;
    }
    public static int[] leftSmallerIndex(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);

        for(int i = arr.length - 2; i >= 0; i--) {
            while(st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size() > 0) {
            res[st.pop()] = -1;
        }
        return res;
    }
    public static int[] rightSmallerIndex(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i = 1; i < arr.length; i++) {
            while(st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size() > 0) {
            res[st.pop()] = arr.length;
        }
        return res;
    }
    //Leetcode 85. Maximal Rectangle
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int[] arr = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    arr[j] = 0;
                }else{
                    arr[j] += matrix[i][j] - '0';
                }
            }
            res = Math.max(res, largestAreaHistogram(arr));
        }
        return res;
    }
    
    public static void ques(){
        int[] arr = {9,2,6,8,4,3,1,8};
        // int[] ret = ngir(arr);
        // int[] ret = ngil(arr);
        // int[] ret = nlir(arr);
        int[] ret = nlil(arr);
        display1DArr(ret);
    }
    public static void main(String[] args){
        ques();
    }    
}
