#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, k;
	cin >> n >> k;


	// Case I : for positive rotation
	int tmp = n;
	int nod = 0;
	while (tmp != 0) {
		tmp = tmp / 10;
		nod++;
	}

	// case II : for k > digits of n;
	k = k % nod;

	// Case III : for k -ve
	if (k < 0) {
		k = k + nod;
	}

	// case I continuation
	int div = 1;
	int mul = 1;
	for (int i = 1; i <= nod; i++) {
		if (i <= k) {
			div = div * 10;
		} else {
			mul = mul * 10;
		}
	}

	int remainder = n % div;
	n = n / div;
	int rotated = remainder * mul + n;

	cout << rotated;



	return 0;
}