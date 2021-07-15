#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;

	int dp0[n+1]{0};
	int dp1[n+1]{0};

	dp0[1] = 1;
	dp1[1] = 1;

	for(int i=2; i<=n; i++){
		dp0[i] = dp1[i-1];
		dp1[i] = dp0[i-1]+dp1[i-1]; 
	}

	cout << dp0[n] + dp1[n];

	return 0;
}