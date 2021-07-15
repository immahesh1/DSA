import java.util.*;

class dp {

    public static int fibo_rec(int n){
        if(n==0 || n==1){
            return n;
        }

        int fnm1 = fibo_rec(n-1);
        int fnm2 = fibo_rec(n-2);
        
        int fn = fnm1+fnm2;
        
        return fn;
    }
    public static int fibo_memo(int n, int[] dp){
        if(n==0 || n==1){
            return dp[n] = n;
        }

        if(dp[n] != 0){
            return dp[n];
        }
        int fnm1 = fibo_memo(n-1,dp);
        int fnm2 = fibo_memo(n-2,dp);
        
        int fn = fnm1+fnm2;
        
        return dp[n] = fn;
    }
    public static int fibo_tab(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n;  i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void fibo() {
        int n = 10;
        // int res = fibo_rec(n);
        int[] dp = new int[n+1];
        // int res = fibo_memo(n, dp);
        int res = fibo_tab(n, dp);
        System.out.println(res);
    }

    public static int climbStairs_rec(int n){
        if(n == 0){
            return 1;
        }
        int count = 0;
        for(int i=1; i<=3; i++){
            if(n-i>=0){
                count += climbStairs_rec(n-i);
            }
        }
        return count;
    }
    public static int climbStairs_memo(int n, int[] dp){
        if(n == 0){
            return dp[0] = 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int count = 0;
        for(int i=1; i<=3; i++){
            if(n-i>=0){
                count += climbStairs_rec(n-i);
            }
        }
        return dp[n] = count;
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
    public static int climbStairsVarJump_rec(int s, int n, int[] jumps){
        if(s == n){
            return 1;
        }
        int count = 0;
        for(int jump=1; jump <= jumps[s] && jump+s <=n; jump++){
            count += climbStairsVarJump_rec(s+jump, n, jumps);
        }
        return count;
    }
    public static int climbStairsVarJump_memo(int s, int n, int[] jumps, int[] dp){
        if(s == n){
           return dp[s] = 1;
        }
        if(dp[s] != 0){
            return dp[s];
        }
        int count = 0;
        for(int jump=1; jump <= jumps[s] && jump+s <=n; jump++){
            count += climbStairsVarJump_memo(s+jump, n, jumps,dp);
        }
        return dp[s] = count;
    }
    public static int climbStairsWithMinMoves_rec(int s, int n, int[] jumps){
        if(s == n){
            return 0;
        }
        int minJumps = (int)1e9;
        for(int jump=1; jump <= jumps[s] && jump+s <= n; jump++){
            minJumps = Math.min(minJumps, climbStairsWithMinMoves_rec(s+jump, n, jumps));
        }
        return minJumps==1e9 ? minJumps : minJumps+1;
    }
    public static int climbStairsWithMinMoves_memo(int s, int n, int[] jumps, int[] dp){
        if(s == n){
            return dp[s] = 0;
        }
        if(dp[s] != 0){
            return dp[s];
        }
        int minMoves = (int)1e9;
        for(int jump=1; jump<=jumps[s] && jump+s <= n; jump++){
            minMoves = Math.min(minMoves,climbStairsWithMinMoves_memo(s+jump, n, jumps, dp));
        }
        return minMoves == 1e9 ? (dp[s] = minMoves) : (dp[s] = minMoves+1);
    }
    public static int climbStairsWithMinMoves_tab(int[] jumps, int n){
        Integer[] dp = new Integer[n+1];
        dp[n]=0;
        for(int i=n-2; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int jump=1; jump<=jumps[i] && jump+i <= dp.length; jump++){
                if(dp[i+jump] != null){
                    min = Math.min(min, dp[jump+i]);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }
    public static void climbStairs(){
        int n = 4;
        // int res = climbStairs_rec(n);
        int[] dp = new int[n+1];
        // int res = climbStairs_memo(n,dp);
        // int[] jumps = {3,3,2,0,1};
        int[] jumps = {3,3,0,2,1};
        // int res = climbStairsVarJump_rec(0, 5, jumps);
        // int res = climbStairsWithMinMoves_rec(0,10,jumps);
        int res = climbStairsWithMinMoves_tab(jumps,jumps.length);
        System.out.println(res);
    }

    // ~~~~~~~~~~~~~~~~~~~~~Min cost path~~~~~~~~~~~~~~~~~~~~~~~
    // public static int minCostPath_rec(int x, int y, int[][] maze){
    //     if(x==maze.length-1 && y == maze[0].length-1){
    //         return maze[x][y];
    //     }
    //     int minCost = (int)1e9;
    //     // right
    //     if(y+1 < maze[0].length){
    //         minCost = Math.min(minCost, minCostPath_rec(x,y+1, maze));
    //     }

    //     // down
    //     if(x+1 < maze.length){
    //         minCost = Math.min(minCost, minCostPath_rec(x+1, y, maze));
    //     }
    // }

    // public static int goldmin_tab1(int[][] mine){

    // }

    public static boolean targetSum_rec(int[] arr, int tar, int idx){
        if(tar == 0){
            return true;
        }
        if(idx == arr.length){
            return false;
        }
        boolean res = false;
        // no call
        res = targetSum_rec(arr, tar, idx+1);
        
        // yes call
        if(tar-arr[idx]>=0){
            res =res||targetSum_rec(arr, tar-arr[idx], idx+1);
        }

        return res;
    }

    public static boolean targetSum_memo(int[] arr, int tar, int idx){
        if(tar == 0){
            return true;
        }
        if(idx == arr.length){
            return false;
        }
        boolean res = false;
        // no call
        res = targetSum_rec(arr, tar, idx+1);
        
        // yes call
        if(tar-arr[idx]>=0){
            res =res||targetSum_rec(arr, tar-arr[idx], idx+1);
        }

        return res;
    }
    // public static void mazePath(){

    // }
    
    public static void targetSum(){
        int[] arr = {4,2,7,1,3};
        int tar = 10;
        boolean res = targetSum_rec(arr,tar,0);
        System.out.println(res);
    }
    
    public static int coinChange_permutation_rec(int[] coins, int target){
        if(target == 0){
            return 1;
        }
        int ways=0;
        for(int coin : coins){
            if(target-coin>=0){
                ways += coinChange_permutation_rec(coins, target-coin);
            }
        }
        return ways;
    }
    public static int coinChange_permutation_memo(int[] coins, int target, int[] dp){
        if(target == 0){
            return dp[target] = 1;
        }
        if(dp[target] != 0){
            return dp[target];
        }
        int ways=0;
        for(int coin : coins){
            if(target-coin>=0){
                ways += coinChange_permutation_memo(coins, target-coin, dp);
            }
        }
        return dp[target] = ways;
    }
    public static int coinChange_permutation_tab(int[] coins, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1; i<=target; i++){
            for(int coin : coins){
                if(i-coin >= 0){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[target];
    }
    public static void coinChange(){
        int[] coins = {2,3,5,6};
        // int res = coinChange_permutation_rec(coins,7);
        // int res = coinChange_permutation_rec(coins,7);
        int res = coinChange_permutation_memo(coins, 7, new int[7+1]);
        System.out.println(res);
    }
    public static void ques() {
        // fibo();
        // climbStairs();
        // targetSum();
        coinChange();
    }

    public static void main(String[] args) {
        ques();
    }
}
