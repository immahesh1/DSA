#include<bits/stdc++.h>
using namespace std;

int any_base_add_fun(int n1, int n2, int b) {
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
int main()
{
	int b, n1, n2;
	cin >> b >> n1 >> n2;

	cout << any_base_add_fun(n1, n2, b) << endl;


	return 0;
}