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

	int j = 0;
	while (j < n) {
		for (int i = n - 1; i >= 0; i--) {
			cout << ar[i][j] << " ";
		}
		j++;
		cout << endl;
	}


	return 0;
}