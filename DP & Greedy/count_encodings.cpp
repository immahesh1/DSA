#include<bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	string s;
	cin >> s;

	int dp[s.size()] {0};
	dp[0] = 1;
	for (int i = 1; i < s.size(); i++) {
		if (s[i - 1] == '0' && s[i] == '0') {
			dp[i] = 0;
		} else if (s[i - 1] == '0' && s[i] != '0') {
			dp[i] = dp[i - 1];
		} else if (s[i - 1] != '0' && s[i] == '0') {
			if (s[i - 1] == '1' || s[i - 1] == '2') {
				dp[i] = (i >= 2 ? dp[i - 2] : 1);
			} else {
				dp[i] = 0;
			}
		} else {
			if (stoi(s.substr(i - 1, 2)) <= 26) {
				dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
			} else {
				dp[i] = dp[i - 1];
			}
		}
	}

	cout << dp[s.size() - 1];



	return 0;
}