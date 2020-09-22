#include<bits/stdc++.h>
using namespace std;

int main()
{
	
	int n1, n2;
	cin >> n1;
	int ar1[n1];
	for (int i = 0; i < n1; i++) {
		cin >> ar1[i];
	}
	cin >> n2;
	int ar2[n2];
	for (int i = 0; i < n2; i++) {
		cin >> ar2[i];
	}

	int sum[n1 > n2 ? n1 : n2];

	int c = 0;
	// cout << s1 << " " << s2 << " " << ss << endl;
	int i = n1 - 1;
	int j = n2 - 1;
	int k = sizeof(sum) / sizeof(sum[0]) - 1;

	while (k >= 0) {
		int d = c;

		if (i >= 0) {
			d += ar1[i];
		}
		if (j >= 0) {
			d += ar2[j];
		}

		c = d / 10;
		d = d % 10;
		sum[k] = d;
		i--;
		j--;
		k--;
	}


	if (c != 0) {
		cout << c << endl;
	}
	for (int x : sum) {
		cout << x << endl;
	}

	return 0;
}