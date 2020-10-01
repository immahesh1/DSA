#include<bits/stdc++.h>
using namespace std;
int len;

int findIndex(int ar[], int idx, int s) {
	if (idx == len - 1) {
		return -1;
	}
	if (ar[idx] == s) {
		return idx;
	} else {
		int miisa = findIndex(ar, idx + 1, s);
		return miisa;
	}
}
int main()
{
	
	int n, s;
	cin >> n;
	len = n;

	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	cin >> s;

	cout << findIndex(ar, 0, s);


	return 0;
}