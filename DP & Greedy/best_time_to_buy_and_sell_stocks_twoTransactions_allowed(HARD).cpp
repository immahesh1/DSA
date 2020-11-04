#include<bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}


	int lsf = ar[0];
	int mpist = 0;
	int dpl[n] {0};

	for (int i = 1; i < n; i++) {
		if (ar[i] < lsf) {
			lsf = ar[i];
		}
		mpist = ar[i] - lsf;
		if (mpist > dpl[i - 1]) {
			dpl[i] = mpist;
		} else {
			dpl[i] = dpl[i - 1];
		}
	}

	int mpibt = 0; //max profit if bought today
	int msf = ar[n - 1]; // max so far
	int dpr[n] {0};

	for (int i = n - 2; i >= 0; i--) {
		if (ar[i] > msf) {
			msf = ar[i];
		}
		mpibt = msf - ar[i];
		if (mpibt > dpr[i + 1]) {
			dpr[i] = mpibt;
		} else {
			dpr[i] = dpr[i + 1];
		}
	}

	int op = 0;
	for (int i = 0; i < n; i++) {
		if (dpl[i] + dpr[i] > op) {
			op = dpl[i] + dpr[i];
		}
	}

	cout << op;
	return 0;
}