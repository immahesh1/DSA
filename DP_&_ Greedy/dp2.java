import java.util.Collections;
import java.util.PriorityQueue;

class dp2{
    public static int fibo_rec(int n){
        if(n==0||n==1){
            return n;
        }
        int nm1 = fibo_rec(n-1);
        int nm2 = fibo_rec(n-2);
        return nm1+nm2;
    }
    public static int fibo_memo(int n,int[] dp){
        if(n==0||n==1){
            return dp[n] = n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int nm1 = fibo_rec(n-1);
        int nm2 = fibo_rec(n-2);
        return dp[n] = nm1+nm2;
    }
    public static int fibo_tab1(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int fibo_tab2(int N, int[] dp){
        for(int n=0; n<=N; n++){
            if(n==0||n==1){
                dp[n] = n;
                continue;
            }
            int nm1 = dp[n-1];
            int nm2 = dp[n-2];
            dp[n] = nm1+nm2;
        }
        return dp[N];
    }
    public static void fibonacci(){
        // int res = fibo_rec(5);
        int n = 10;
        // int res = fibo_memo(n,new int[n+1]);
        // int res = fibo_tab1(n);
        int res = fibo_tab2(n, new int[n+1]);
        System.out.println(res);
    }
    // ~~~~~~~~~~~~~~~~~~~~Climb starirs~~~~~~~~~~~~~~~~~~~~~~
    public static int climbStairs_rec(int n, String psf){
        if(n==0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i=1; i<=3; i++){
            if(n-i>=0){
                count += climbStairs_rec(n-i,psf+i+" ");
            }
        }
        return count;
    }
    public static int climbStairs_memo(int n, int[] dp){
        if(n==0){
            return dp[n] = 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int count = 0;
        for(int i=1; i<=3; i++){
            if(n-i>=0){
                count += climbStairs_memo(n-i, dp);
            }
        }
        return dp[n] = count;
    }
    public static int climbStairs_tab2(int N, int[] dp){
        for(int n=0; n<=N; n++){
            if(n==0){
                dp[n] = 1;
                continue;
            }
            
            int count = 0;
            for(int i=1; i<=3; i++){
                if(n-i>=0){
                    count += dp[n-i];//climbStairs_memo(n-i, dp);
                }
            }
            dp[n] = count;
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        return dp[N];
    }
    public static int climbStairs_tab1(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=3; j++){
                if(i-j>=0){
                    count += dp[i-j];
                }
            }
            dp[i] = count;
        }
        return dp[n];
    }
    public static int climbStairs_tab(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i >= 3){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }else if(i>=2){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }
    // ~~~~~~~~~~~~~~~~~~~~Climb stairs with variable jumps ~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int climbStairs_varJump_rec(int[] jumps, int n, int s, String psf){
        if(s == n){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int jump = 1; jump<=jumps[s] && jump+s<=n; jump++){
            count += climbStairs_varJump_rec(jumps, n, s+jump,psf+jump+" ");
        }
        return count;
    }
    public static int climbStairs_varJump_memo(int[] jumps, int n, int s, int[] dp){
        if(s == n){
            return dp[s] = 1;
        }
        if(dp[s] != 0){
            return dp[s];
        }
        int count = 0;
        for(int jump = 1; jump<=jumps[s] && jump+s<=n; jump++){
            count += climbStairs_varJump_memo(jumps, n, s+jump,dp);
        }
        return dp[s] = count;
    }
    public static int climbStairs_varJump_tab2(int[] jumps, int n, int s, int[] dp){
        for(s=n; s>=0; s--){
            if(s == n){
                dp[s] = 1;
                continue;
            }
            int count = 0;
            for(int jump = 1; jump<=jumps[s] && jump+s<=n; jump++){
                count += dp[s+jump]; //climbStairs_varJump_memo(jumps, n, s+jump,dp);
            }
            dp[s] = count;
        }
        return dp[0];
    }
    public static int climbStairs_varJump_tab1(int[] jumps, int n){
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=jumps[i] && j+i <= n; j++){
                dp[i] += dp[i+j];
            }
        }
        return dp[0];
    }
    // ~~~~~~~~~~~~~~~~~~~~Climb stairs with minimum moves~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int climbStairs_minMoves_rec(int[] jumps, int n, int s){
        if(s==n){
            return 0;
        }
        int minPath = (int)1e9;
        for(int jump=1; jump<=jumps[s] && jump + s <= n; jump++){
            minPath = Math.min(minPath,climbStairs_minMoves_rec(jumps, n, s+jump));
        }
        return minPath==1e9?minPath:minPath+1;
    }
    public static int climbStairs_minMoves_memo(int[] jumps, int n, int s, Integer[] dp){
        if(s==n){
            return dp[s] = 0;
        }
        if(dp[s] != null){
            return dp[s];
        }
        int minPath = (int)1e9;
        for(int jump=1; jump<=jumps[s] && jump + s <= n; jump++){
            minPath = Math.min(minPath,climbStairs_minMoves_memo(jumps, n, s+jump,dp));
        }
        return minPath==1e9?(dp[s] = minPath):(dp[s] = minPath+1);
    }
    public static int climbStairs_minMoves_tab1(int[] jumps, int n, Integer[] dp){
        for(int i=n; i>=0; i--){
            if(i==n){
                dp[i] = 0;
                continue;
            }
            int minPath = (int)1e9;
            for(int jump=1; jump<=jumps[i] && jump + i <= n; jump++){
                minPath = Math.min(minPath,dp[i+jump]);//climbStairs_minMoves_tab1(jumps, n, s+jump,dp));
            }
            if(minPath==1e9){
                dp[i] = minPath;
            }
            else{
                dp[i] = minPath+1;
            }
        }
        return dp[0];
    }
    public static int climbStairs_minMoves_tab2(int[] jumps, int n){
        int[] dp = new int[n+1];
        for(int i=n-1; i>=0; i--){
            int min = (int)1e9;
            for(int j=1; j<=jumps[i] && j+i <=n; j++){
                min = Math.min(min,dp[i+j]);
            }
            dp[i] = min+1;
        }
        return dp[0];
    }
    public static void climbStairs(){
        int[] jumps = {3,3,0,2,1};
        int n = jumps.length;
        int[] dp = new int[n+1];
        Integer[] dpp = new Integer[n+1];
        // int res = climbStairs_rec(n,"");
        // int res = climbStairs_memo(n, new int[n+1]);
        // int res = climbStairs_tab2(n, new int[n+1]);
        // int res = climbStairs_tab1(n);
        // int res = climbStairs_varJump_rec(jumps, n, 0,"");
        // int res = climbStairs_varJump_memo(jumps, n, 0, dp);
        // int res = climbStairs_varJump_tab1(jumps,n);
        // int res = climbStairs_varJump_tab2(jumps,n,0,dp);
        // int res = climbStairs_minMoves_rec(jumps, n,dp);
        // int res = climbStairs_minMoves_memo(jumps, n, 0, dpp);
        // int res = climbStairs_minMoves_tab1(jumps,n,dpp);
        int res = climbStairs_minMoves_tab2(jumps,n);
        System.out.println(res);
    }
    // ~~~~~~~~~~~~~~~~~~~~Maze traversal ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int minCostMazeTraversal_tab(int[][] maze){
        int row = maze.length;
        int col = maze[0].length;
        int[][] dp = new int[row][col];
        for(int c=col-1; c>=0; c--){
            for(int r=row-1; r>=0; r--){
                if(r==row-1 && c == col-1){
                    dp[r][c] = maze[r][c];
                }
                else if(r==row-1){
                    dp[r][c] = dp[r][c+1] + maze[r][c];
                }else if(c==col-1){
                    dp[r][c] = dp[r+1][c] + maze[r][c];
                }else{
                    dp[r][c] = Math.min(dp[r][c+1],dp[r+1][c])+maze[r][c];
                }
            }
        }
        return dp[0][0];
    }
    public static int minCostMazeTraversal_rec(int[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
           return maze[r][c];
        }
        int cost = (int)1e9;
        // right call
        if(r+1<maze.length){
            cost = Math.min(cost,minCostMazeTraversal_rec(maze,r+1,c));
        }
        // down call
        if(c+1<maze[0].length){
            cost = Math.min(cost,minCostMazeTraversal_rec(maze,r,c+1));
        }
        return cost==1e9?cost:cost+maze[r][c];
    }
    public static int minCostMazeTraversal_memo(int[][] maze, int r, int c, int[][] dp){
        if(r==maze.length-1 && c==maze[0].length-1){
           return dp[r][c] = maze[r][c];
        }
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        int cost = (int)1e9;
        // right call
        if(r+1<maze.length){
            cost = Math.min(cost,minCostMazeTraversal_memo(maze,r+1,c,dp));
        }
        // down call
        if(c+1<maze[0].length){
            cost = Math.min(cost,minCostMazeTraversal_memo(maze,r,c+1,dp));
        }
        return dp[r][c] = cost+maze[r][c];
    }
    public static void mazeTraversal(){
        int[][] maze = {
            {0,1,4,2,8,2},
            {4,3,6,5,0,4},
            {1,2,4,1,4,6},
            {2,0,7,3,2,2},
            {3,1,5,9,2,4},
            {2,7,0,8,5,1}
        };
        int res = minCostMazeTraversal_tab(maze);
        System.out.println(res);   
    }
    // ~~~~~~~~~~~~~~~~~~~~Count binary strings ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int countBinaryStrings_rec(int n, int le, String psf){
        if(n==0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        if(le == 1){
            count += countBinaryStrings_rec(n-1, 0,psf+"0 ");
        }
        count += countBinaryStrings_rec(n-1, 1, psf+"1 ");
        return count;
    }
    public static int countBinaryStrings_memo(int n, int le, int[][] dp){
        if(n==0){
            return dp[n][le] = 1;
        }
        if(dp[n][le] != 0){
            return dp[n][le];
        }
        int count = 0;
        if(le == 1){
            count += countBinaryStrings_memo(n-1, 0,dp);
        }
        count += countBinaryStrings_memo(n-1, 1,dp);
        return dp[n][le] = count;
    }
    public static int countBinaryString_tab(int n){
        int[][] dp = new int[2][n+1];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i=1; i<=n; i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[0][i-1] + dp[1][i-1];
        }
        return dp[1][n];
    }
    // ~~~~~~~~~~~~~~~~~~~Arrange Buildings~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static long arrangeBuilding_tab(int n){
        long bld = 1;
        long sp = 1;
        for(int i=2; i<=n; i++){
            long nbld = sp;
            long nsp = sp + bld;

            sp = nsp;
            bld = nbld;
        }
        long res = bld + sp;
        return res * res;
    }
    public static void countBinary(){
        int n = 4;
        // int res = countBinaryStrings_rec(n, 1,"");
        // int res = countBinaryStrings_memo(n,1,new int[n+1][2]);
        int res = countBinaryString_tab(n);
        System.out.println(res);
    }
    // ~~~~~~~~~~~~~~~~~~~Count Encoding~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void printEncodings(String str, String asf){
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        int n1 = str.charAt(0)-'0';
        if(n1 == 0){
            return;
        }
        char ch1 = (char)(n1+'a'-1);
        printEncodings(str.substring(1), asf+ch1);

        if(str.length()>1){
            int n = n1*10 + str.charAt(1)-'0';
            if(n<=26){
                char ch = (char)(n+'a'-1);
                printEncodings(str.substring(2), asf+ch);
            }
        }
    } 
    public static int countEncoding_rec(String str, int idx){
        if(idx==str.length()){
            return 1;
        }
        int n1 = str.charAt(idx)-'0';
        if(n1==0){
            return 0;
        }
        int count = 0;
        count += countEncoding_rec(str,idx+1);
        if(idx+1 < str.length()){
            int n = n1*10+str.charAt(idx+1)-'0';
            if(n<=26){
                count += countEncoding_rec(str, idx+2);
            }
        }
        return count;
    }
    public static int countEncoding_memo(String str, int idx, int[] dp){
        if(idx==str.length()){
            return dp[idx] = 1;
        }
        int n1 = str.charAt(idx)-'0';
        if(n1==0){
            return dp[idx] = 0;
        }
        if(dp[idx] != 0){
            return dp[idx];
        }
        int count = 0;
        count += countEncoding_memo(str,idx+1,dp);
        if(idx+1 < str.length()){
            int n = n1*10+str.charAt(idx+1)-'0';
            if(n<=26){
                count += countEncoding_memo(str, idx+2,dp);
            }
        }
        return dp[idx] = count;
    }
    public static int countEncoding_tab(String str){
        int[] dp = new int[str.length()+1];
        for(int idx=str.length(); idx>=0; idx--){
            if(idx==str.length()){
                dp[idx] = 1;
                continue;
            }
            int n1 = str.charAt(idx)-'0';
            if(n1==0){
                dp[idx] = 0;
                continue;
            }
            int count = 0;
            count += dp[idx+1];//countEncoding_memo(str,idx+1,dp);
            if(idx+1 < str.length()){
                int n = n1*10+str.charAt(idx+1)-'0';
                if(n<=26){
                    count += dp[idx+2]; //countEncoding_memo(str, idx+2,dp);
                }
            }
            dp[idx] = count;
        }
        return dp[0];
    }
    public static int countEncoding_tab1(String str) {
        int[] dp = new int[str.length() + 1];
        for(int indx = str.length(); indx >= 0; indx--) {
            if(indx == str.length()) {
                dp[indx] = 1;
                continue;
            }
            if(str.charAt(indx) == '0') {
                dp[indx] = 0;
                continue;
            }

            int count = 0;
            int n1 = str.charAt(indx) - '0';
            count += dp[indx + 1]; // countEncoding_memo(str, indx + 1, dp);
            if(indx + 1 < str.length()) {
                int n = str.charAt(indx + 1) - '0';
                int n2 = n1 * 10 + n;
                if(n2 <= 26) {
                    count += dp[indx + 2]; // countEncoding_memo(str, indx + 2, dp);
                }
            }
            dp[indx] = count;
        }
        return dp[0];
    }
    public static void countEncoding(){
        // printEncodings("12323","");
        // int res = countEncoding_rec("12323",0);
        int res = countEncoding_tab("12323");
        System.out.println(res);
    } 
    // ~~~~~~~~~~~~~~~~~~~~~~~~CountA+B+C+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int countABCSubseq(String str){
        int a_count = 0;
        int b_count = 0;
        int c_count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='a'){
                a_count = 2*a_count + 1; 
            }else if(str.charAt(i)=='b'){
                b_count = a_count + 2 * b_count;
            }else if(str.charAt(i) == 'c'){
                c_count = b_count + 2 * c_count;
            }
        }
        return c_count;
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~Tiling 2*1
    public static int tiling1(int n){
        int a = 1;
        int b = 2;
        for(int i=1; i<n; i++){
            int c = a+b;
            a = b;
            b = c;
        }
        return a;
    }
    public static long tilingMx1(int n, int m){
        long[] dp = new long[n+1];
        for(int i=0; i<=n; i++){
            if(i<m){
                dp[i] = 1;
            }else{
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        return dp[n];
    }
    // ~~~~~~~~~~~~~~~~~~Friends pairing~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int friendsPairing(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + (i-1)* dp[i-2];
        }
        return dp[n];
    }
    // ~~~~~~~~~~~~~~~~~~~~~Partition Into Subsets
    // public static long partitionKSubset(int n, int k) {
    //     int[][] dp = new int[n+1][k+1];
        
    // }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~Stock span~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int stockSpanSingleTran(int[] price){
        int minPrice = price[0];
        int maxProfit = 0;
        for(int day=0; day<price.length; day++){
            maxProfit = Math.max(maxProfit, price[day]-minPrice);
            minPrice = Math.min(minPrice,price[day]);
        }
        return maxProfit;
    }
    public static int stockSpanInfiniteTran(int[] price){
        int profit = 0;
        int bd = 0;
        int sd = 0;
        for(int i=1; i<price.length; i++){
            if(price[i-1] > price[i]){
                profit += price[sd]-price[bd];
                sd = bd = i;
            }else{
                sd = i;
            }
        }
        profit += price[sd] - price[bd];
        return profit;
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~Knapsack problems~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int knapsack01_rec(int[] values, int[] weight,int cap,int idx){
        if(idx == -1){
            return 0;
        }
        int v1 = 0;
        // yes call
        if(cap-weight[idx] >=0)
            v1 = knapsack01_rec(values, weight, cap-weight[idx], idx-1)+values[idx];
        // no call
        int v2 = knapsack01_rec(values, weight, cap, idx-1);
        return Math.max(v1, v2);
    }
    public static int knapsack01_memo(int[] values, int[] weight,int cap,int idx,int[][] dp){
        if(idx == -1){
            return dp[idx+1][cap] = 0;
        }
        if(dp[idx+1][cap] != 0){
            return dp[idx+1][cap];
        }
        int v1 = 0;
        // yes call
        if(cap-weight[idx] >=0)
            v1 = knapsack01_memo(values, weight, cap-weight[idx], idx-1,dp)+values[idx];
        // no call
        int v2 = knapsack01_memo(values, weight, cap, idx-1,dp);
        return dp[idx+1][cap] = Math.max(v1, v2);
    }
    public static int knapsack01_tab(int[] values, int[] weight, int cap, int[][] dp){
        for(int w=0; w<dp.length; w++){
            for(int c=0;c<dp[0].length; c++){
                if(w==0 || c == 0){
                    dp[w][c] = 0;
                }else{
                    if(c-weight[w-1] < 0){
                        dp[w][c] = dp[w-1][c];
                    }else{
                       dp[w][c] = Math.max(dp[w-1][c-weight[w-1]]+values[w-1], dp[w-1][c]);
                   } 
                }
            }
        }
        return dp[weight.length][cap];
    }
    public static int unboundKnapsack_rec(int[] vals, int[] wht, int cap, int idx){
        if(idx == -1){
            return 0;
        }
        int val1 = 0;
        // yes call
        if(cap-wht[idx]>=0){
            val1 = unboundKnapsack_rec(vals, wht, cap-wht[idx], idx) + vals[idx];
        }
        // no call
        int val2 = unboundKnapsack_rec(vals, wht, cap, idx-1);

        return Math.max(val1,val2);
    }
    public static int unboundKnapsack_memo(int[] vals, int[] wht, int cap, int idx, int[][] dp){
        if(cap == 0 || idx == -1){
            return dp[idx+1][cap] = 0;
        }
        if(dp[idx+1][cap] != 0){
            return dp[idx+1][cap];
        }
        int val1 = 0;
        // yes call
        if(cap-wht[idx]>=0){
            val1 = unboundKnapsack_memo(vals, wht, cap-wht[idx], idx,dp) + vals[idx];
        }
        // no call
        int val2 = unboundKnapsack_memo(vals, wht, cap, idx-1,dp);

        return dp[idx+1][cap] = Math.max(val1,val2);
    }
    public static int unboundKnapsack_tab(int[] vals, int[] wht, int cap){
        int[] dp = new int[cap+1];
        for(int i=0; i<wht.length; i++){
            for(int c=wht[i]; c<=cap; c++){
                // yes call
                dp[c] = Math.max(dp[c], vals[i] + dp[c-wht[i]]);
            }
        }
        return dp[cap];
    }
    public static class FPair implements Comparable<FPair>{
        int val;
        int wt;
        double frac;
        
        public FPair(int val, int wt){
            this.val = val;
            this.wt = wt;
            this.frac = val*1.0 / wt;
        }

        public int compareTo(FPair other){
            // this is wrong condition since return of this is double which will convert fraction to int 
            // return this.frac - other.frac;
            if(this.frac > other.frac){
                return 1;
            }else if(this.frac < other.frac){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public static void fractionalKnapsack(int[] vals, int[] whts, int cap){
        PriorityQueue<FPair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<vals.length; i++){
            pq.add(new FPair(vals[i], whts[i]));
        }
        double profit = 0;
        while(pq.size()>0 && cap>0){
            FPair rem = pq.remove();

            if(rem.wt<=cap){
                profit += rem.val;
                cap -= rem.wt;
            }else{
                profit += rem.frac * cap;
                cap = 0;
            }
        }
        System.out.println(profit);
    }
    public static void knpasack(){
        int[] values = {15,14,10,45,30};
        int[] weight = {2,5,1,3,4};
        int cap = 7;
        // int res = knapsack01_rec(values, weight,cap,4);
        int[][] dp = new int[weight.length+1][cap+1];
        // int res = knapsack01_tab(values,weight,cap,dp);
        // int res = unboundKnapsack_tab(values,weight,cap);
        // System.out.println(res);
        fractionalKnapsack(values, weight, cap);
    }
    public static void singleQues(){
        // int res = countABCSubseq("abcabc");
        // int res = friendsPairing(6);
    }
    
    public static void ques(){
        // fibonacci();
        // climbStairs();
        // mazeTraversal();
        // countBinary();
        // singleQues();
        // countEncoding();
        knpasack();
    }
    public static void main(String[] args){
        ques();        
    }
}