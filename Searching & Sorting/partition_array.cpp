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

void partition(int * ar, int pivot) {
	int i = 0, j = 0;
	while (i < size) {
		if (ar[i] > pivot) {
			i++;
		} else { // ar[i] <= pivot
			swap(ar, i, j);
			i++; j++;
		}
	}
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
	partition(ar, pivot);
	for (int i = 0; i < n; i++) {
		cout << ar[i] << " ";
	}

	return 0;
}