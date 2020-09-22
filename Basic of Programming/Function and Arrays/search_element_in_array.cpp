#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	int find;
	cin >> find;
	bool found = false;
	static int i;
	for (i = 0; i < n; i++) {
		if (ar[i] == find) {
			found = true;
			break;
		}

	}
	if (found) {
		cout << i;
	} else {
		cout << -1;
	}


	return 0;
}