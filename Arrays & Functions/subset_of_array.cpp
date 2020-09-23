#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}

	int len = pow(2, n);
	for (int i = 0; i < len; i++) {
		//create binary number to find if blank will print or array element
		int temp = i;
		string set = "";
		for (int j = n - 1; j >= 0; j--) {
			int r = temp % 2;
			temp = temp / 2;
			if (r == 0) {
				set = "-\t" + set;
			} else {
				set = to_string(ar[j]) + "\t" + set;
			}
		}
		cout << set;
		cout << endl;
	}



	return 0;
}