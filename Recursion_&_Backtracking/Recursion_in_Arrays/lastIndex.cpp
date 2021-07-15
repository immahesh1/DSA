#include<bits/stdc++.h>
using namespace std;
// int len;

int last_index(int ar[], int idx, int s) {
	if (idx < 0) {
		return -1;
	}
	if (ar[idx] == s) {
		return idx;
	} else {
		int lst_idx = last_index(ar, idx - 1, s);
		return lst_idx;
	}
}

int main()
{
	int n, s;
	cin >> n;

	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	cin >> s;

	cout << last_index(ar, n - 1 , s);


	return 0;
}