import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j * j <= i; j++){
                int dpijs = dp[i-j*j];
                if(dpijs<min){
                    min = dpijs;
                }
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}