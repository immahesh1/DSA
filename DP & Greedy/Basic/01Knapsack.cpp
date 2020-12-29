#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;

	int vals[n];
	int wht[n];
	for(int i=0; i<n; i++){
		cin >> vals[i];
	}
	for(int i=0; i<n; i++){
		cin >> wht[i];
	}
	int cap; cin >> cap;

	int dp[n+1][cap+1];

	for(int i=0; i<sizeof(dp)/sizeof(dp[0]); i++){
		for(int j=0; j<sizeof(dp[0])/sizeof(dp[0][0]); j++){
			if(i==0 && j==0){
				dp[i][j] = 0;
					// cout << dp[i][j] << " ";
			}else if(i==0){
				dp[i][j] = 0;
					// cout << dp[i][j] << " ";
			}else if(j==0){
				dp[i][j] = 0;
					// cout << dp[i][j] << " ";
			}else{
				if(j < wht[i-1]){
					dp[i][j] = dp[i-1][j];
					// cout << dp[i-1][j] << " ";
				}else{
					dp[i][j] = std::max(dp[i-1][j],vals[i-1] + dp[i-1][j-wht[i-1]]);
					// cout << std::max(dp[i-1][j],vals[i-1] + dp[i-1][j-wht[i-1]]) << " ";
				}
			}
		}
	}

	cout << dp[n][cap];

	return 0;
}