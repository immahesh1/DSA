#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	int srch;
	cin >> srch;

	int low = 0;
	int high = n - 1;
	int ceil = INT_MAX;
	int floor = INT_MIN;

	while (low <= high) {
		int mid = (low + high) / 2;
		if (ar[mid] < srch) {
			low = mid + 1;
			floor = ar[mid];
		}
		else if (ar[mid] > srch) {
			high = mid - 1;
			ceil = ar[mid];
		} else {
			ceil = ar[mid];
			floor = ar[mid];
			break;
		}
	}
	cout << ceil << "\n" << floor;
	// cout << -1;

	return 0;
}