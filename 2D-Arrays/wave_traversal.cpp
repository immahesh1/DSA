#include<bits/stdc++.h>
using namespace std;

int main()
{
	int r, c;
	cin >> r >> c;
	int ar[r][c];

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> ar[i][j];
		}
	}

	for (int j = 0; j < c; j++) {
		if (j % 2 == 0) {
			for (int i = 0; i < r; i++) {
				cout << ar[i][j] << endl;
			}
		}
		else {
			for (int i = r - 1; i >= 0 ; i--) {
				cout << ar[i][j] << endl;
			}
		}
	}
	return 0;
}