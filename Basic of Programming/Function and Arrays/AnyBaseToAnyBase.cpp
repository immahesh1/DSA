#include<bits/stdc++.h>
using namespace std;

int anyToDecimal(int num, int b) {
	int decimal_value = 0;
	int p = 0;
	while (num > 0) {
		int rem = num % 10;
		decimal_value = decimal_value + rem * pow(b, p++);
		num = num/10;
	}
	return decimal_value;
}
int anyToany(int n, int b2) {
	int final_value = 0;
	int p = 0;
	while (n > 0) {
		int rem = n % b2;
		final_value = final_value + rem * pow(10, p++);
		n = n / b2;
	}
	return final_value;
}

int main()
{
	int n, b1, b2;
	cin >> n >> b1 >> b2;

	int to_decimal = anyToDecimal(n, b1);
//	cout << to_decimal << endl;
	cout << anyToany(to_decimal, b2) << endl;

	return 0;
}
