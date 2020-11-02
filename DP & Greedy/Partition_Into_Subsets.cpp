#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, k; cin >> n >> k;

	long long int dp[k + 1][n + 1];
	for (int t = 0; t <= k; t++) {
		for (int p = 0; p <= n; p++) {
			if (t == 0 || p == 0) {
				dp[t][p] = 0;
			} else if (t == 1) {
				dp[t][p] = 1;
			} else if (p < t) {
				dp[t][p] = 0;
			} else if (t == p) {
				dp[t][p] = 1;
			} else {
				dp[t][p] = dp[t][p - 1] * t + dp[t - 1][p - 1];
			}
		}
	}

	cout << dp[k][n];

	return 0;
}