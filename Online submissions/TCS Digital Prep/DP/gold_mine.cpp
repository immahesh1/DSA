#include<bits/stdc++.h>
using namespace std;

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif

	int n,m; cin >> n >> m;
	int ar[n][m];
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			cin >> ar[i][j];
		}
	}

	int dp[n][m]{0};

	for(int c=m-1; c>=0; c--){
		for(int r=0; r<n; r++){
			if(c == m-1){
				dp[r][c] = ar[r][c];
			}else if(r == 0){
				int max = std::max(dp[r][c+1], dp[r+1][c+1]);
				dp[r][c] = max + ar[r][c];
			}else if(r == n-1){
				int max = std::max(dp[r][c+1], dp[r-1][c+1]);
				dp[r][c] = max + ar[r][c];
			}else{
				int max = std::max(dp[r][c+1], std::max(dp[r+1][c+1],dp[r-1][c+1]));
				dp[r][c] = max + ar[r][c];
			}
		}
	}
	
	int max = INT_MIN;
	for(int i=0; i<n; i++){
		if(dp[i][0]>max){
			max = dp[i][0];
		}
	}
	cout << max;

}