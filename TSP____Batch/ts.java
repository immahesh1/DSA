public class ts{
    public static boolean binarySearchRec(int[] arr, int lo, int hi , int data){
        int mid = lo + (hi-lo)/2;
        if(lo>hi){
            return false;
        }
        // System.out.println(mid);
        if(arr[mid] == data){
            return true;
        }
        else if(arr[mid]<data){
            return binarySearchRec(arr, mid+1, hi, data);
        }else{
            return binarySearchRec(arr, lo, mid-1, data);
        }
    }
    public static int binarySearchIdx(int[] arr, int lo, int hi, int data){
        int mid = lo + (hi-lo)/2;
        int res = -1;
        if(lo>hi){
            return -1;
        }
        // System.out.println(mid);
        if(arr[mid] == data){
            return mid;
        }
        else if(arr[mid]<data){
            res = binarySearchIdx(arr, mid+1, hi, data);
        }else{
            res = binarySearchIdx(arr, lo, mid-1, data);
        }
        return res;
    }
    public static void searching(){
        int[] arr = {1, 2, 5, 6, 7, 8, 9, 10, 15, 16};
        int lo = 0;
        int hi  = arr.length-1;
        int data = 3; 
        // boolean r = binarySearchRec(arr, lo, hi, data);
        int r = binarySearchIdx(arr, lo, hi, data);
        System.out.println(data+" found at index: "+r);
    }
    public static void sort01(int[] arr){
        int i = 0;
        int j = 0;
        while(i<arr.length){
            if(arr[i] == 1){
                i++;
            }else{
                swap(arr, i, j);
                i++; j++;
            }
        }
    }
    public static void segregateOddEven(int[] arr){
        int i=0; 
        int j=0;
        while(i<arr.length){
            if(arr[i] %2 == 0){
                i++;
            }else{
                swap(arr, i, j);
                i++; j++;
            }
        }

    }
    public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort012(int[] arr){
        int i=0; int j=0; int k = arr.length - 1;
        while(i<=k){
            if(arr[i] == 1){
                i++;
            }else if(arr[i] == 0){
                swap(arr, i, j);
                i++; j++;
            }else if(arr[i] == 2){
                swap(arr, i, k);
                k--;
            }
        }
    }
    public static int solvePoly(int x, int N){ //x = 2, n = 5
        int xval = x;
        int sum = 0;
        for(int n=N; n>=1; n--){
            sum += xval * n;
            xval *= x;
        }
        return sum;
    }
    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static int[] mergeTwoSortedArr(int[] ar1, int[] ar2){
        int i = 0;
        int j = 0;
        int k = 0;
        int ans[] = new int[ar1.length+ar2.length];
        while(i<ar1.length && j<ar2.length){
            if(ar1[i]>ar2[j]){
                ans[k] = ar2[j];
                j++; k++;
            }else{
                ans[k] = ar1[i];
                i++; k++;
            }
        }
        while(i<ar1.length){
            ans[k] = ar1[i];
            i++; k++;
        }
        while(j<ar2.length){
            ans[k] = ar2[j];
            j++; k++;
        }
        return ans;
    }
    public static int[] mergeTwoSortedArray2(int[] ar1, int[] ar2){
        int s1 = ar1.length;
        int s2 = ar2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[s1+s2];
        while(i<s1 || j<s2){
            int ival = i < s1 ? ar1[i] : Integer.MAX_VALUE;
            int jval = j < s2 ? ar2[j] : Integer.MAX_VALUE;
            if(ival<jval){
                ans[k] = ival;
                i++;
            }else{
                ans[k] = jval;
                j++;
            }
            k++;
        }
        return ans;
    }
    public static void sort(){
        // int n = 5;
        // int ar[] = {0,1,0,1,0};
        // sort01(ar);
        // int[] arr = {7,10,9,8,12,15,19,52,36,7};
        // int [] arr = {0,2,2,2,1,0,1,1,0,2,1,2,1,2,1,2,0};
        // sort012(arr);
        // System.out.println(arr.toString());
        // segregateOddEven(arr);
        // print(arr);
        int[] ar1 = {-2,5,9,11};
        int[] ar2 = {4,6,8};
        // int[] ans = mergeTwoSortedArr(ar1,ar2);
        int ans[] = mergeTwoSortedArray2(ar1,ar2);
        print(ans);
    }
    public static void ques(){
        // searching();
        sort();
        // System.out.println(solvePoly(2,5));
    }
    public static void main(String[] args){
        ques();
    }
}