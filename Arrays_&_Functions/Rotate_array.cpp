#include<bits/stdc++.h>
using namespace std;

int reverse_arr(int ar[], int i, int j) {
	while (i < j) {
		int tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
		i++;
		j--;
	}
}

int rotate_arr(int ar[], int k, int n) {
	//reverse first part (0 to ar_size-k-1)
	reverse_arr(ar, 0, n - k - 1);

	//reverse second part (ar_size - k to ar_size -1)
	reverse_arr(ar, n - k, n - 1);
	//reverse all
	reverse_arr(ar, 0, n - 1);
}

int main()
{
	int n, k;
	cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	cin >> k;

	// if k>n
	k = k % n;

	//if k<0
	if (k < 0) {
		k = k + n;
	}

	rotate_arr(ar, k, n);

	for (int a : ar) {
		cout << a << " ";
	}

	return 0;
}