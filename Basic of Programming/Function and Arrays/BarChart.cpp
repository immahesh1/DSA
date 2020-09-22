#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int ar[n];
	int max = INT_MIN;
	for (int i = 0; i < n; i++) {
		int ele;
		cin >> ele;
		ar[i] = ele;
		if (ele > max) {
			max = ele;
		}
	}
	int ar2[n];
	for (int i = 0; i < n; i++) {
		ar2[i] = max - ar[i];
	}
	for (int i = 1; i <= max; i++) {
		for (int j = 0; j < n; j++) {
			if (ar2[j] != 0) {
				cout << "\t";
				ar2[j]--;
			} else {
				cout << "*\t";
			}
		} cout << endl;
	}
	return 0;
}