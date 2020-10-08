#include<bits/stdc++.h>
using namespace std;


int count_staircase_ways(int n) {
	if (n < 0) {
		return 0;
	}
	if (n == 0) {
		count++;
	}
	for (int i = 1; i <= 3; i++) {
		count_staircase_ways(n - i);
	}
	return count % 10000000007;
}

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int t;
	cin >> t;
	while (t-- > 0) {
		int n;
		cin >> n;
		cout << count_staircase_ways(n) << endl;
	}

	return 0;
}