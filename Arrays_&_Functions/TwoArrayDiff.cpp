#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n1, n2;
	cin >> n1;
	int a1[n1];
	for (int i = 0; i < n1; i++) {
		cin >> a1[i];
	}
	cin >> n2;
	int a2[n2];
	for (int i = 0; i < n2; i++) {
		cin >> a2[i];
	}

	int diff[n2];

	int i = n1 - 1;
	int j = n2 - 1;
	int diff_size = sizeof(diff) / sizeof(diff[0]);
	int k = diff_size - 1;

	int c = 0;
	while (k >= 0) {
		int d = 0;
		//if a1 has less no. of elements then it will come to -1 index
		//which is not possible in array
		//so using ternary operator to make -1 index as 0.
		int a1v = i >= 0 ? a1[i] : 0;
		if (a2[j] + c >= a1v) {
			d = a2[j] + c - a1v;
			c = 0;
		} else {
			d = (c + a2[j] + 10) - a1v;
			c = -1;
		}
		diff[k] = d;
		i--;
		j--;
		k--;
	}

	//preceding zero should not be printed
	int ind = 0;
	while (ind < diff_size) {
		if (diff[ind] == 0) {
			ind++;
		} else {
			break;
		}
	}
	while (ind < diff_size) {
		cout << diff[ind] << endl;
		ind++;
	}

	return 0;
}