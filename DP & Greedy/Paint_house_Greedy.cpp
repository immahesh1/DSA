#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n; cin >> n;
	int ar[n][3];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> ar[i][j];
		}
	}

	long r = ar[0][0];
	long b = ar[0][1];
	long g = ar[0][2];

	for (int i = 1; i < n; i++) {
		long tr = r;
		long tb = b;
		long tg = g;
		tr = std::min(b, g) + ar[i][0];
		tb = std::min(r, g) + ar[i][1];
		tg = std::min(r, b) + ar[i][2];
		r = tr; b = tb; g = tg;
	}

	cout << (r < b ? (r < g ? r : g) : (b < g ? b : g));
	return 0;
}