import java.util.*;
import java.io.*;

class DateSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ar[] = new String[n];
        for(int i=0; i<n; i++){
            String s = sc.next();
            ar[i] = s;
        }
        dateSort(ar);
        print(ar);
    }
    static void countSort(String ar[], int div, int mod, int range){
        int[] far = new int[range];
        for(int i=0; i<ar.length; i++){
            far[Integer.parseInt(ar[i]) / div % mod]++;
        }
        for(int i=1; i<far.length; i++){
            far[i] += far[i-1];
        }

        String[] res = new String[ar.length];
        for(int i=ar.length-1; i>=0; i--){
            res[far[Integer.parseInt(ar[i]) / div % mod]-1] = ar[i];
            far[Integer.parseInt(ar[i]) / div % mod]--;
        }
        for(int i=0; i<res.length; i++){
            ar[i] = res[i];
        }
    }

    static void dateSort(String ar[]){
        countSort(ar,1000000,100,32);
        countSort(ar,10000,100,13);
        countSort(ar,1,10000,2501);
    }

    static void print(String ar[]){
        for(int i=0; i<ar.length; i++){
            System.out.println(ar[i]);
        }
    }
}