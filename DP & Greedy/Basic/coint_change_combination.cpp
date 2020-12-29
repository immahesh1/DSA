#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;

	int ar[n];
	for(int i=0; i<n; i++){
		cin >> ar[i];
	}

	int tar; cin >> tar;
	int dp[tar+1]{0};

	dp[0] = 1;
	for(int i=0; i<n; i++){
		for(int j=ar[i]; j<=tar; j++){
			dp[j] += dp[j-ar[i]];
		}
	}
	cout << dp[tar];

	return 0;
}