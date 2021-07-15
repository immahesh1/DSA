#include<bits/stdc++.h>
using namespace std;

void print_increasing(int n) {
	if (n == 0) {
		return;
	}
	cout << n << endl;
	print_increasing(n - 1);
	cout << n << endl;
}

int main()
{
	int n;
	cin >> n;
	print_increasing(n);

	return 0;
}