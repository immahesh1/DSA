#include<bits/stdc++.h>
using namespace std;

int main()
{

	int a, b, c;
	cin >> a >> b >> c;

	int largest = (a > b ? (a > c ? a : c) : (b > c ? b : c));

	if (largest == a) {
		bool r = (a * a == (b * b + c * c));
		cout << (r ? "true" : "false");
	} else if (largest == b) {
		bool r = (b * b == (a * a + c * c));
		cout << (r ? "true" : "false");
	}
	else {
		bool r = (c * c == (b * b + a * a));
		cout << (r ? "true" : "false");
	}


	return 0;
}