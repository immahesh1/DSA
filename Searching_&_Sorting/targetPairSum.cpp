#include<bits/stdc++.h>
using namespace std;

int n;
void targetSum(long* ar, long target) {
	sort(ar, ar + n);
	int i = 0, j = n - 1;
	while (i < j) {
		if (ar[i] + ar[j] > target) {
			j--;
		} else if (ar[i] + ar[j] < target) {
			i++;
		} else if (ar[i] + ar[j] == target) {
			cout << ar[i] << ", " << ar[j] << endl;
			i++; j--;
		}
	}
}


int main()
{
	cin >> n;
	long ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	long target;
	cin >> target;
	targetSum(ar, target);
	return 0;
}