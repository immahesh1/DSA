#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, m;
	cin >> n >> m;
	int ar[n][m];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> ar[i][j];
		}
	}

	int minr = 0;
	int maxr = sizeof(ar) / sizeof(ar[0]) - 1;
	int minc = 0;
	int maxc = sizeof(ar[0]) / sizeof(ar[0][0]) - 1;
	int tne = n * m;
	int cnt = 0;

	while (cnt < tne) {
		//left wall
		for (int i = minr, j = minc; i <= maxr && cnt < tne; i++) {
			cout << ar[i][j] << endl;
			cnt++;
		} minc++; //for restricting duplicate corners printing

		//bottom wall
		for (int i = maxr, j = minc; j <= maxc && cnt < tne; j++) {
			cout << ar[i][j] << endl;
			cnt++;
		} maxr--;

		//right wall
		for (int i = maxr, j = maxc; i >= minr && cnt < tne; i--) {
			cout << ar[i][j] << endl;
			cnt++;
		} maxc--;

		//top wall
		for (int i = minr, j = maxc; j >= minc && cnt < tne; j--) {
			cout << ar[i][j] << endl;
			cnt++;
		} minr++;
	}

	return 0;
}