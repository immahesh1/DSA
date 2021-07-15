#include<bits/stdc++.h>
using namespace std;
int s1, s2;

int * merge_sorted_array(int *ar1, int *ar2) {
	int* merged = new int[s1 + s2];
	int i = 0, j = 0, k = 0;
	while (i < s1 && j < s2) {
		if (ar1[i] < ar2[j]) {
			merged[k++] = ar1[i++];
		} else {
			merged[k++] = ar2[j++];
		}
	}
	while (i < s1) {
		merged[k++] = ar1[i++];
	}
	while (j < s2) {
		merged[k++] = ar2[j++];
	}
	return merged;
}

int main()
{
	int n1, n2;
	cin >> n1;
	int ar1[n1];
	for (int i = 0; i < n1; i++) {
		cin >> ar1[i];
	}

	cin >> n2;
	int ar2[n2];
	for (int i = 0; i < n2; i++) {
		cin >> ar2[i];
	}

	s1 = n1;
	s2 = n2;

	int *res = merge_sorted_array(ar1, ar2);
	for (int i = 0; i < s1 + s2; i++) {
		cout << res[i] << endl;
	}

	return 0;
}