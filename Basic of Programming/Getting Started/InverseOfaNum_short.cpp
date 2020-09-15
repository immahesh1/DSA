#include<bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int n;
	cin >> n;

	int inv = 0;	
	int op = 1;
	while (n != 0) {
		int od = n % 10;
		int ip = od;
		int id = op;

		inv = inv + (int)(id * pow(10, ip - 1));
		cout << id * pow(10, ip - 1) << " " << inv << endl;
		n = n / 10;
		op++;
	}
	cout << inv;

	return 0;
}