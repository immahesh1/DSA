#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, d;
	cin >> n >> d;

	int count = 0;
	while (n != 0) {
		int tmp = n % 10;
		if ( tmp == d)
			count++;
		n = n / 10;
	}
	cout << count << endl;


	return 0;
}