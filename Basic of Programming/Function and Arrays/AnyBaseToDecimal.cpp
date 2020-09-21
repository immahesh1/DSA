#include<bits/stdc++.h>
using namespace std;

int main()
{
	//Number and base of that number is provided
	//convert it to decimal
	
	int n, b;
	cin >> n >> b;
	
	int decimal_value = 0;
	int p = 0;
	while(n>0){
		int rem = n%10;
		decimal_value = decimal_value + rem * pow(b,p++);
		n = n / 10;
	}
	cout << decimal_value << endl;
	

	return 0;
}
