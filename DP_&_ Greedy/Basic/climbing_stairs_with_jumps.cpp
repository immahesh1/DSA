#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}

	int dp[n + 1] {0};
	dp[n] = 1;
	for (int i = n - 1; i >= 0; i--) {
		for (int j = 1; j <= ar[i] && i + j < sizeof(dp) / sizeof(dp[0]); j++) {
			dp[i] += dp[i + j];
		}
	}
	cout << dp[0] << endl;
	return 0;
}