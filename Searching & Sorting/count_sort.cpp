#include<bits/stdc++.h>
using namespace std;
int ar_size;
void count_sort(int* ar, int min, int max) {
	//creating freq array
	int farr_size = max - min + 1;
	// cout << farr_size << endl;
	int farr[farr_size] {0};
	for (int i = 0; i < ar_size; i++) {
		int ari = ar[i];
		farr[ari - min]++;
	}

	//creating freq_count sum array
	for (int i = 1; i < sizeof(farr) / sizeof(farr[0]); i++) {
		farr[i] = farr[i] + farr[i - 1];
	}

	int res[ar_size] {0};
	for (int i = ar_size - 1; i >= 0; i--) {
		int ari = ar[i];
		res[farr[ari - min] - 1] = ari;
		farr[ari - min]--;
	}

	for (int i = 0; i < ar_size; i++) {
		ar[i] = res[i];
	}

int main()
{
	int n;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	ar_size = n;

	int min = INT_MAX;
	int max = INT_MIN;
	for (int i = 0; i < n; i++) {
		min = std::min(min, ar[i]);
		max = std::max(max, ar[i]);
	}

	// cout << min << " " << max << endl;

	count_sort(ar, min, max);

	for (int i = 0; i < n; i++) {
		cout << ar[i] << endl;
	}
	return 0;
}