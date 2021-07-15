#include<bits/stdc++.h>
using namespace std;

int stair_ways(int n) {
	int dp[n + 1];
	dp[0] = 1;
	for (int i = 1; i <= n; i++) {
		if (i == 1) {
			dp[i] = dp[i - 1];
		} else if (i == 2) {
			dp[i] = dp[i - 1] + dp[i - 2];
		} else {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
	}
	return dp[n];
}
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int n;
	cin >> n;
	cout << stair_ways(n);

	return 0;
}