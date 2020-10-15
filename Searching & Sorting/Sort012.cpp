#include<bits/stdc++.h>
using namespace std;

int n;

void print(int* arr) {
	for (int i = 0 ; i < n; i++) {
		cout << arr[i] << endl;
	}
}

void swap(int* arr, int i, int j) {
	cout << "Swapping index " << i << " and index " << j << endl;
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

void sort012(int* ar) {
	int i = 0;
	int j = 0;
	int k = n - 1;
	while (i <= k) {
		if (ar[i] == 1) {
			i++;
		} else if (ar[i] == 0) {
			swap(ar, i, j);
			i++; j++;
		} else { //ar[i] == 2
			swap(ar, i, k);
			k--;
		}
	}
}

int main()
{
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	sort012(ar);
	print(ar);

	return 0;
}