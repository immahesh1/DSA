#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int ar[n][n];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> ar[i][j];
		}
	}
	for (int g = 0; g < n; g++) {
		for (int i = 0, j = g; j < n; j++, i++) {
			cout << ar[i][j] << endl;
		}
	}

	return 0;
}