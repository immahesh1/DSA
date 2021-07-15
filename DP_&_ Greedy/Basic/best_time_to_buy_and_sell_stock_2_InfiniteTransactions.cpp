#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}

	int bd = 0;
	int sd = 0;
	int profit = 0;

	for (int i = 1; i < n; i++) {
		if (ar[i] >= ar[i - 1]) {
			sd++;
		} else {
			profit += ar[sd] - ar[bd];
			bd = sd = i;
		}
	}

	profit += ar[sd] - ar[bd];
	cout << profit;
	return 0;
}