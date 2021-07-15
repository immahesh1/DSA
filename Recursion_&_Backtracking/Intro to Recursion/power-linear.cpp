#include<bits/stdc++.h>
using namespace std;

int pow(int x, int n) {
	if (n == 0) {
		return 1;
	}
	int fnm1 = pow(x, n - 1);
	int fn = x * fnm1;
	return fn;
}
int main()
{
	int x, n;
	cin >> x >> n;

	cout << pow(x, n);


	return 0;
}