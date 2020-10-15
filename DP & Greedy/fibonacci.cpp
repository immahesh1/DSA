#include<bits/stdc++.h>
using namespace std;

long fiboMemoized(int n, long* qb) {
	if (n == 0 || n == 1) {
		return n;
	}
	if (qb[n] != 0) {
		return qb[n];
	}
	long fbnm1 = fiboMemoized(n - 1, qb);
	long fbnm2 = fiboMemoized(n - 2, qb);
	long fbn = fbnm1 + fbnm2;
	qb[n] = fbn;
	return fbn;
}
int main()
{
	int n;
	cin >> n;

	long qb[n + 1] {0};
	cout << fiboMemoized(n, qb) << endl;
	return 0;
}