#include<bits/stdc++.h>
using namespace std;

int main()
{
// 	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	int n;
	cin >> n;

	int root = sqrt(n);

	for (int i = 1; i < root + 1 ; ++i) {
		cout << i*i << endl;
	}

	return 0;
}