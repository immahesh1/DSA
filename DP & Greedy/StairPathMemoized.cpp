#include<bits/stdc++.h>
using namespace std;

int stair_ways(int n, int* dp) {
	if (n == 0) {
		return 1;
	}
	else if (n < 0) {
		return 0;
	}

	if (dp[n] != 0) {
		return dp[n];
	}
	int n1 = stair_ways(n - 1, dp);
	int n2 = stair_ways(n - 2, dp);
	int n3 = stair_ways(n - 3, dp);
	int cp = n1 + n2 + n3;
	dp[n] = cp;
	return cp;

}
int main()
{
	int n;
	cin >> n;
	int dp[n + 1] {0};
	cout << stair_ways(n, dp);

	return 0;
}