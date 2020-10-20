#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, m;
	cin >> n >> m;
	int ar[n][m];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> ar[i][j];
		}
	}

	int dp[n][m] {0};


	for (int c = m - 1; c >= 0; c--) {
		for (int r = 0; r <= n - 1; r++) {
			if (c == m - 1) {
				dp[r][c] = ar[r][c];
			} else if (r == 0) {
				int max = std::max(dp[r][c + 1], dp[r + 1][c + 1]);
				dp[r][c] = max + ar[r][c];
				// cout << max << endl;
			} else if (r == n - 1) {
				int max = std::max(dp[r][c + 1], dp[r - 1][c + 1]);
				dp[r][c] = max + ar[r][c];
				// cout << max << endl;
			} else {
				int max = std::max(dp[r - 1][c + 1], dp[r][c + 1]);
				max = std::max(max, dp[r + 1][c + 1]);
				dp[r][c] = max + ar[r][c];
				// cout << max << endl;
			}
		}
	}

	int max = INT_MIN;
	for (int i = 0; i <= n - 1; i++) {
		if (dp[i][0] > max) {
			max = dp[i][0];
		}
	}

	cout << max << endl;
	return 0;
}