#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;

	int coins[n];
	for(int i=0; i<n; i++){
		cin >> coins[i];
	}

	int tar; cin >> tar;
	int dp[tar+1]{0};

	dp[0] = 1;
	for(int amt=1; amt <= tar; amt++){
		for(auto coin:coins){
			if(coin <= amt){
				dp[amt] += dp[amt-coin];
			}
		}
	}
	cout << dp[tar];

	return 0;
}