#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, d;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	cin >> d;

	int low = 0;
	int high = n - 1;

	int first_index = -1;
	while (low <= high) {
		int mid = (low + high) / 2;
		if (ar[mid] > d) {
			high = mid - 1;
		} else if (ar[mid] < d) {
			low = mid + 1;
		} else {
			first_index = mid;
			high = mid - 1;
		}
	}
	cout << first_index << endl;

	int l = 0;
	int h = n - 1;
	int last_index = -1;
	while (l <= h) {
		int mid = (l + h) / 2;
		if (ar[mid] > d) {
			h = mid - 1;
		} else if (ar[mid] < d) {
			l = mid + 1;
		} else {
			last_index = mid;
			l = mid + 1;
		}
	}
	cout << last_index << endl;



	return 0;
}