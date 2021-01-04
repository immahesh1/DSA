#include<bits/stdc++.h>
using namespace std;

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	int n; cin >> n;
	int dp[n+1];
	dp[0] = 0;
	dp[1] = 1;
	for(int i=2; i<=n; i++){
		int min = INT_MAX;
		for(int j=1; j<i; j++){
			int dpijs = dp[i - j*j];
			if(dpijs < min){
				min = dpijs;
			}
		}
		dp[i] = min + 1;
	}
	cout << dp[n];

}