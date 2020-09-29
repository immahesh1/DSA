#include<bits/stdc++.h>
using namespace std;

void print_decreasing(vector<int> ar, int n) {
	if (n < 0) {
		return;
	}
	cout << ar[n] << endl;
	print_decreasing(ar, n - 1);
}

int main()
{
	int n, el;
	cin >> n;

	std::vector<int> ar;
	for (int i = 0; i < n; i++) {
		cin >> el;
		ar.push_back(el);
	}

	print_decreasing(ar, ar.size() - 1);

	return 0;
}