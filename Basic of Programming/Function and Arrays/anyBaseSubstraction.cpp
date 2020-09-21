#include<bits/stdc++.h>
using namespace std;

int any_base_sub_fun(int n1, int n2, int b) {
	int c = 0;
	int rv = 0;
	int p = 1;
	while (n2 > 0) {
		int d1 = n1 % 10;
		int d2 = n2 % 10;
		n1 = n1 / 10;
		n2 = n2 / 10;

		int d = 0;
		d2 = d2 + c;
		if (d2 >= d1) {
			c = 0;
			d = d2 - d1;
		} else {
			c = -1;
			d = d2 + b - d1;
		}
		rv = rv + d * p;
		p  = p * 10;

		// cout << rv << endl;
	}
	return rv;
}
int main()
{
	int b, n1, n2;
	cin >> b >> n1 >> n2;

	cout << any_base_sub_fun(n1, n2, b) << endl;


	return 0;
}