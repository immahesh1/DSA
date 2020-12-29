#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	int tar; cin >> tar;

	bool dp[n + 1][tar + 1] {false};
	for (int i = 0; i < sizeof(dp) / sizeof(dp[0]); i++) {
		for (int j = 0; j < sizeof(dp[0]) / sizeof(dp[0][0]); j++) {
			if (i == 0 && j == 0) {
				dp[i][j] = true;
			} else if (i == 0) {
				dp[i][j] = false;
			} else if (j == 0) {
				dp[i][j] = true;
			} else {
				if (dp[i - 1][j] == true) {
					dp[i][j] = true;
				} else {
					int val = ar[i - 1];
					if (j >= val) {
						if (dp[i - 1][j - val] == true) {
							dp[i][j] = true;
						}
					}
				}
			}
		}
	}
	bool res = dp[n][tar];
	if (res == 0) {
		cout << "false";
	} else {
		cout << "true";
	}

	return 0;
}