#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, c; cin >> n >> c;
	int ar[n][c];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < c; j++) {
			cin >> ar[i][j];
		}
	}

	long dp[n][c];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < c; j++) {
			if (i == 0) {
				dp[i][j] = ar[i][j];
			} else {
				int min = INT_MAX;
				for (int m = 0; m < c; m++) {
					if (m != j) {
						if (min > dp[i - 1][m]) {
							min = dp[i - 1][m];
						}
					}
				}
				dp[i][j] = min + ar[i][j];
			}
		}
	}

	int min = INT_MAX;
	for (int i = 0; i < c; i++) {
		// cout << dp[n - 1][i] << " ";
		if (min > dp[n - 1][i]) {
			min = dp[n - 1][i];
		}
	}

	cout << min;
	return 0;
}