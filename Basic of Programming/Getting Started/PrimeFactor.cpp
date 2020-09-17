#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;

	for (int div = 2; div * div <= n; div++) {
		while (n % div == 0) {
			cout << div << " ";
			n = n / div;
		}
	}

	if (n != 1) {
		cout << n;
	}


	return 0;
}

