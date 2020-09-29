#include<bits/stdc++.h>
using namespace std;

void tower_of_hanoi(int n, int A, int B, int C) {
	if (n == 0) {
		return;
	}
	tower_of_hanoi(n - 1, A, C, B);
	cout << n << "[" << A << " -> " << B << "]" << endl;
	tower_of_hanoi(n - 1, C, B, A);
}

int main()
{
	int n, t1, t2, t3;
	cin >> n >> t1 >> t2 >> t3;
	tower_of_hanoi(n, t1, t2, t3);

	return 0;
}