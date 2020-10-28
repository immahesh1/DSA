#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}

	int inc = ar[0];
	int exc = 0;

	for (int i = 1; i < n; i++) {
		int itmp = inc;
		itmp = ar[i] + exc;
		exc = std::max(inc, exc);
		inc = itmp;
		// cout << inc << " " << exc << endl;
	}

	cout << std::max(inc, exc);

	return 0;
}