#include<bits/stdc++.h>
using namespace std;
int arrsize;

void swap(int* arr, int i, int j) {
	cout << "Swapping " << arr[i] << " and " << arr[j] << endl;
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

// return true if jth element is greater than ith element
bool isGreater(int* arr, int j, int i) {
	cout << "Comparing " << arr[i] << " and " << arr[j] << endl;
	if (arr[i] < arr[j]) {
		return true;
	} else {
		return false;
	}
}

void insertion_sort(int* arr) {
	for (int i = 1; i < arrsize; i++) {
		for (int j = i - 1; j >= 0; j--) {
			if (isGreater(arr, j, j + 1)) {
				swap(arr, j, j + 1);
			} else {
				break;
			}
		}
	}
}

int main()
{
    int n;
	cin >> n;
	arrsize = n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	insertion_sort(ar);
	for (int i = 0; i < n; i++) {
		cout << ar[i] << endl;
	}

	return 0;
}