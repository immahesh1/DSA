#include<bits/stdc++.h>
using namespace std;

int len;
int* print_indices(int ar[], int s, int idx, int fsf) {
	if (idx == len) {
		return new int[fsf];
	}

	if (ar[idx] == s) {
		int* iar = print_indices(ar, s, idx + 1, fsf + 1);
		iar[fsf] = idx;
		return iar;
	} else {
		int* iar = print_indices(ar, s, idx + 1, fsf);
		return iar;
	}
}

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int n, s;
	cin >> n;
	len = n;

	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	cin >> s;
	int* out = print_indices(ar, s, 0, 0);

	for (int i = 0; i < sizeof(out) / sizeof(out[0]); i++) {
		cout << out[i] << endl;
	}

	return 0;
}