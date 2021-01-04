import java.util.*;
import java.io.*;

class Main{
    public static class Bridge implements Comparable<Bridge>{
        int n,s;
        public int compareTo(Bridge o){
            if(this.n != o.n){
                return this.n - o.n;
            }else{
                return this.s - o.s;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Bridge bdgs[] = new Bridge[n];
        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            bdgs[i] = new Bridge();
            bdgs[i].n = Integer.parseInt(str.split(" ")[0]);
            bdgs[i].s = Integer.parseInt(str.split(" ")[1]);
        }
        Arrays.sort(bdgs);
        int dp[] = new int[n];
        int omax = 0;
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(bdgs[j].s <= bdgs[i].s){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i] > omax){
                omax = dp[i];
            }
        }
        System.out.println(omax);
    }
}