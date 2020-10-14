#include<bits/stdc++.h>
using namespace std;
int size;
void swap(int* arr, int i, int j) {
	// System.out.println("Swapping " + arr[i] + " and " + arr[j]);
	cout << "Swapping " << arr[i] << " and " << arr[j] << endl;
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

int partition(int* arr, int pivot, int lo, int hi) {
	cout << "pivot -> " << pivot << endl;
	int i = lo, j = lo;
	while (i <= hi) {
		if (arr[i] <= pivot) {
			swap(arr, i, j);
			i++;
			j++;
		} else {
			i++;
		}
	}
	cout << "pivot index -> " << (j - 1) << endl;
	return (j - 1);
}

void quick_sort(int* ar, int lo, int hi) {
	if (lo > hi) {
		return;
	}
	int pivot = ar[hi];
	int pi = partition(ar, pivot, lo, hi);
	quick_sort(ar, lo, pi - 1);
	quick_sort(ar, pi + 1, hi);
}
int main()
{
	int n;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	int pivot;
	cin >> pivot;
	size = n;
	quick_sort(ar, 0, n - 1);
	for (int i = 0; i < n; i++) {
		cout << ar[i] << " ";
	}

	return 0;
}