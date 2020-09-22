#include<bits/stdc++.h>
using namespace std;

int singleDigitMul(int b, int n1, int d2) {
	int c = 0;
	int p = 1;
	int rv = 0;
	while (n1 > 0 || c > 0) {
		int d1 = n1 % 10;
		n1 = n1 / 10;

		int d = d1 * d2 + c;
		c = d / b;
		d = d % b;

		rv = rv + d * p;
		p = p * 10;
	}
	return rv;
}
int any_base_add_fun(int b, int n1, int n2) {
	int c = 0;
	int res = 0;
	int p = 1;
	while (n1 > 0 || n2 > 0 || c > 0) {
		int d1 = n1 % 10;
		int d2 = n2 % 10;
		n1 = n1 / 10;
		n2 = n2 / 10;
		int d = d1 + d2 + c;

		//find carry and remainder
		c = d / b;
		d = d % b;
		res += d * p;
		p *= 10;

	}
	return res;
}
int anyBaseMultiplication(int b, int n1, int n2) {
	int rv = 0;
	int p = 1;
	while (n2 > 0) {
		int d2 = n2 % 10;
		n2 = n2 / 10;
		rv = any_base_add_fun(b, rv, singleDigitMul(b, n1, d2) * p);
		p = p * 10;
	}
	return rv;
}

int main()
{
	int b, n1, n2;
	cin >> b >> n1 >> n2;

	cout << anyBaseMultiplication(b, n1, n2) << endl;


	return 0;
}