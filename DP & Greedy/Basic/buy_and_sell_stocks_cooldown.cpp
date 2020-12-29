#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	
	int obsp = -ar[0];
	int ossp = 0;
	int ocsp = 0;
	
	for (int i = 1; i < n; i++) {
		int nbsp = 0;
		int nssp = 0;
		int ncsp = 0;

		if (ocsp - ar[i] > obsp) {
			nbsp = ocsp - ar[i];
		} else {
			nbsp = obsp;
		}

		if (ar[i] + obsp > ossp) {
			nssp = ar[i] + obsp;
		} else {
			nssp = ossp;
		}

		if (ossp > ocsp) {
			ncsp = ossp;
		} else {
			ncsp = ocsp;
		}

		ossp = nssp;
		obsp = nbsp;
		ocsp = ncsp;
	}
	cout << ossp;

	return 0;
}