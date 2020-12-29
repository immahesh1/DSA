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

	for (int i = n - 1; i >= 0; i--) {
		for (int j = m - 1; j >= 0; j--) {
			if (i == n - 1 && j == m - 1) {
				dp[i][j] = ar[i][j];
			} else if (i == n - 1) {
				dp[i][j] = dp[i][j + 1] + ar[i][j];
			} else if (j == m - 1) {
				dp[i][j] = dp[i + 1][j] + ar[i][j];
			}
			else {
				int min = std::min(dp[i + 1][j], dp[i][j + 1]);
				dp[i][j] = min + ar[i][j];
			}
		}
	}
	cout << dp[0][0];

	return 0;
}