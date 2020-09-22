#include<bits/stdc++.h>
using namespace std;

int main()
{

	int n, b;
	cin >> n >> b;

	int sum = 0;
	int p = 0;
	while (n > 0) {
		int rem = n % b;
		sum = sum + rem * pow(10, p++);
//		cout << sum<< endl;
		n = n / b;
	}

	cout << sum;

	return 0;
}
