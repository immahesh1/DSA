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
		return true;
	} else {
		return false;
	}
}
void selection_sort(int *ar) {
	for (int i = 0; i < arsize - 1; i++) {
		int min_i = i;
		for (int j = i + 1; j < arsize; j++) {
			if (isSmaller(ar, j, min_i) == true) {
				min_i = j;
			}
		}
		swap(ar, i, min_i);
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
	selection_sort(ar);
	for (int i = 0; i < n; i++) {
		cout << ar[i] << endl;
	}


	return 0;
}
