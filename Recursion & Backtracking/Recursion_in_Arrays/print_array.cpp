#include<bits/stdc++.h>
using namespace std;

void print_element(vector<int> ar, int n) {
	if (n < 0) {
		return;
	}
	print_element(ar, n - 1);
	cout << ar[n] << endl;
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

	print_element(ar, ar.size() - 1);

	return 0;
}