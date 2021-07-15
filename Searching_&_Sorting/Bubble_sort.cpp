#include<bits/stdc++.h>
using namespace std;
int arsize;
void swap(int *ar, int i, int j) {
	cout << "Swapping " << ar[i] << " and " << ar[j] << endl;
	int tmp = ar[i];
	ar[i] = ar[j];
	ar[j] = tmp;
}

bool isSmaller(int *ar, int i, int j) {
	cout << "Comparing " << ar[i] << " and " << ar[j] << endl;
	if (ar[i] < ar[j]) {
		return false;
	} else {
		return true;
	}
}
void bubble_sort(int *ar) {
	for (int i = 0; i < arsize - 1; i++) {
		for (int j = 0; j < arsize - 1 - i; j++) {
			if (isSmaller(ar, j + 1, j) == false) {
				swap(ar, j + 1, j);
			}
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
	arsize = n;
	bubble_sort(ar);
	for (int i = 0; i < n; i++) {
		cout << ar[i] << endl;
	}


	return 0;
}
