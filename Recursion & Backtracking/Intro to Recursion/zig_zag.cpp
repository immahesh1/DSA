#include<bits/stdc++.h>
using namespace std;

int reverse_array(int ar[], int first, int last) {
	while (first < last) {
		int tmp = ar[first];
		ar[first] = ar[last];
		ar[last] = tmp;
		first++;
		last--;
	}
}
int rotate_array(int ar[], int k, int n) {
	//reverse 1:
	reverse_array(ar, 0, n - k - 1);

	//reverse 2:
	reverse_array(ar, n - k, n - 1);

	//reverse 3:
	reverse_array(ar, 0, n - 1);
}


int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int n, m;
	cin >> n >> m;
	int ar[n][m];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> ar[i][j];
		}
	}
	int s, rot;
	cin >> s >> rot;



	int a1_size = 2 * (m - (s - 1)) + 2 * (n - (s - 1)) - 4 * s;
	if (a1_size < 0) {
		a1_size = 0;
	}

	rot = rot % a1_size;
	if (rot < 0) {
		rot = rot + a1_size;
	}
	//1. take shell s element in array

	int a1[a1_size];
	int minr = s - 1;
	int minc = s - 1;
	int maxr = n - s;
	int maxc = m - s;
	int k = 0;

	//left wall
	for (int i = minr, j = minc; i <= maxr; i++) {
		// cout << ar[i][j] << " ";
		a1[k++] = ar[i][j];
	}
	minc++;
	//bottom wall
	for (int i = maxr, j = minc; j <= maxc; j++) {
		// cout << ar[i][j] << " ";
		a1[k++] = ar[i][j];
	} maxr--;

	//right
	for (int i = maxr, j = maxc; i >= minr; i--) {
		// cout << ar[i][j] << " ";
		a1[k++] = ar[i][j];
	} maxc--;

	//top
	for (int i = minr, j = maxc; j >= minc; j--) {
		// cout << ar[i][j] << " ";
		a1[k++] = ar[i][j];
	} minr++;

	for (int e : a1) {
		cout << e << " ";
	}

	//2. rotate the array by rotation rot.
	rotate_array(a1, rot, a1_size);

	for (int e : a1) {
		cout << e << " ";
	}


	return 0;
}