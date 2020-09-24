#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n1, n2, m1, m2;
	cin >> n1 >> m1;
	int ar1[n1][m1];
	for (int i = 0; i < n1; i++) {
		for (int j = 0; j < m1; j++) {
			cin >> ar1[i][j];
		}
	}
	cin >> n2 >> m2;
	int ar2[n2][m2];
	for (int i = 0; i < n2; i++) {
		for (int j = 0; j < m2; j++) {
			cin >> ar2[i][j];
		}
	}

	if (m1 != n2) {
		cout << "Invalid input" << endl;
		return 0;
	} else {
		int ar3[n1][m2];
		int ar3_row_size = sizeof(ar3) / sizeof(ar3[0]);
		int ar3_col_size = sizeof(ar3[0]) / sizeof(ar3[0][0]);
		for (int i = 0; i < ar3_row_size; i++) {
			for (int j = 0; j < ar3_col_size; j++) {
				int sum = 0;
				for (int k = 0; k < m1; k++) {	//m1 or n2 no. of times it is multiplying and adding
					sum += ar1[i][k] * ar2[k][j];
					ar3[i][j] = sum;
				}
			}
		}

		for (int i = 0; i < ar3_row_size; i++) {
			for (int j = 0; j < ar3_col_size; j++) {
				cout << ar3[i][j] << " ";
			} cout << endl;
		}
	}
	// cout << sizeof(ar2) / sizeof(ar2[0]) << endl;
	// cout << sizeof(ar2[0]) / sizeof(ar2[0][0]);
	return 0;
}
