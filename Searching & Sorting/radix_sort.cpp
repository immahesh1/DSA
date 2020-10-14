#include<bits/stdc++.h>
using namespace std;
int ar_size;

void print(int* ar) {
	for (int i = 0; i < ar_size; i++) {
		cout << ar[i] << " ";
	}
}


void count_sort(int* ar, int exp) {
	// cout << farr_size << endl;
	int farr[10] {0};
	for (int i = 0; i < ar_size; i++) {
		farr[ar[i] / exp % 10]++;
	}

	//creating freq_count sum array
	for (int i = 1; i < sizeof(farr) / sizeof(farr[0]); i++) {
		farr[i] = farr[i] + farr[i - 1];
	}

	int res[ar_size] {0};
	for (int i = ar_size - 1; i >= 0; i--) {
		res[farr[ar[i] / exp % 10] - 1] = ar[i];
		farr[ar[i] / exp % 10]--;
	}

	for (int i = 0; i < ar_size; i++) {
		ar[i] = res[i];
	}
	cout << "After sorting on " << exp << " place -> ";
	print(ar);
	cout << endl;
}

void radix_sort(int* ar) {
	int max = INT_MIN;
	for (int i = 0; i < ar_size; i++) {
		if (ar[i] > max) {
			max = ar[i];
		}
	}

	int exp = 1;
	while (exp <= max) {
		count_sort(ar, exp);
		exp *= 10;
	}
}
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif
	int n;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	ar_size = n;
	radix_sort(ar);
	print(ar);
	return 0;
}