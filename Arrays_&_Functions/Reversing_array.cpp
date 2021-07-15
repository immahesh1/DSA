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

	int ar_size = sizeof(ar) / sizeof(ar[0]);
	//Printing array in reverse order
	// for (int i = ar_size - 1; i >= 0; i--) {
	// 	cout << ar[i] << endl;
	// }

	// Reversing the array using swap
	int i = 0;
	int j = ar_size - 1;
	while (i < j) {
		int tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
		i++;
		j--;
	}
	for (int e : ar) {
		cout << e << " ";
	}


	return 0;
}