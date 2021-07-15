import java.util.*;
import java.io.*;

class Main{
    public static class Envelope implements Comparable<Envelope>{
        int w,h;
        public int compareTo(Envelope o){
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Envelope env[] = new Envelope[n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            env[i] = new Envelope();
            env[i].w = Integer.parseInt(str.split(" ")[0]);
            env[i].h = Integer.parseInt(str.split(" ")[1]);
        }
        Arrays.sort(env);
        int dp[] = new int[n];
        int omax = 0;
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(env[j].h <= env[i].h){
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