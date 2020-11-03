#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, fee; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	cin >> fee;

	int obsp = -ar[0];
	int ossp = 0;


	for (int i = 1; i < n; i++) {
		int nssp = 0;
		int nbsp = 0;
		if (ossp - ar[i] > obsp) {
			nbsp = ossp - ar[i];
		} else {
			nbsp = obsp;
		}

		if (ar[i] + obsp - fee > ossp) {
			nssp = ar[i] + obsp - fee;
		} else {
			nssp = ossp;
		}
		ossp = nssp;
		obsp = nbsp;
	}
	cout << ossp;

	return 0;
}