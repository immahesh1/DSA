#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
	cin >> n;
	long min = INT_MAX;
	long max = INT_MIN;
	for (int i = 0; i < n; i++) {
		long ele;
		cin >> ele;
		if (ele > max) {
			max = ele;
		}
		if (ele < min) {
			min = ele;
		}
	}
	cout << max - min << endl;
	return 0;
}