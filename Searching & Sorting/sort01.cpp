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

void sort01(int* ar) {
	int i = 0;
	int j = 0;
	while (i < n) {
		if (ar[i] == 1) {
			i++;
		} else {
			swap(ar, i, j);
			i++;
			j++;
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
	sort01(ar);
	print(ar);

	return 0;
}