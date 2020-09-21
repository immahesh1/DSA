#include<bits/stdc++.h>
using namespace std;


int base_to_decimal(int n, int b) {
	int decima_val = 0;
	int p = 0;

	while (n > 0) {
		int tmp = n % 10;
		decima_val = decima_val + tmp * pow(b, p++);
		n = n / 10;
	}
	return decima_val;
}

int decimal_to_base(int n, int b) {
	int final_val = 0;
	int p = 0;

	while (n > 0) {
		int tmp = n % b;
		final_val = final_val + tmp * pow(10, p++);
		n = n / b;
	}
	return final_val;
}

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int b, n1, n2;
	cin >> b >> n1 >> n2;

	int n11 = base_to_decimal(n1, b);
	int n22 = base_to_decimal(n2, b);

	cout << decimal_to_base(n11 - n22, b);



	return 0;
}
