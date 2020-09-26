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

	//transpose
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++) { // if j = 0 then matrix will return to normal form
			int tmp = ar[i][j];
			ar[i][j] = ar[j][i];
			ar[j][i] = tmp;
		}
	}

	//swap last col with first col value.
	for (int i = 0; i < n; i++) {
		int li = 0;
		int ri = sizeof(ar[i]) / sizeof(ar[i][0]) - 1;
		while (li < ri) {
			int tmp = ar[i][li];
			ar[i][li] = ar[i][ri];
			ar[i][ri] = tmp;
			li++;
			ri--;
		}
	}

	//display
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << ar[i][j] << " ";
		}
		cout << endl;
	}


	return 0;
}