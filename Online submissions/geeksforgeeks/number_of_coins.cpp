#include<bits/stdc++.h>
using namespace std;

int minCoins(int* coins, int m, int tar){
	int dp[tar+1];
    for(int i=0; i<=tar; i++)
        dp[i] = INT_MAX;
    dp[0] = 0;
    for(int i=1; i<=tar; i++){
        for(int j=0; j<m; j++){
            if(i>=coins[j]){
                int dpiv = dp[i - coins[j]];
	            if(dpiv != INT_MAX && dp[i] > dpiv + 1){
	                dp[i] = dpiv + 1;
	            }
            }
        }
    }
    if(dp[tar] == INT_MAX)
        return -1;
    return dp[tar];
}

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	int tar,m; cin >> tar >> m;
	int coins[m];
	for(int i=0; i<m; i++)
		cin >> coins[i];

	cout << minCoins(coins,m,tar);

}