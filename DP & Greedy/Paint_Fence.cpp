#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, k; cin >> n >> k;

	int ltsame = k;
	int ltdiff = k * (k - 1);
	int total = ltsame + ltdiff;
	for (int i = 3; i <= n; i++) {
		ltsame = ltdiff;
		ltdiff = total * (k - 1);
		total = ltdiff + ltsame;
	}

	cout << total;

	return 0;
}