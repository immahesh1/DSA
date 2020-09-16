#include<bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int n1, n2;
	cin >> n1 >> n2;

	int tn1 = n1, tn2 = n2;

	while (n1 % n2 != 0) {
		int rem = n1 % n2;
		n1 = n2;
		n2 = rem;
	}
	int gcd = n2;

	int lcm = (tn1 * tn2) / gcd;

	cout << gcd << endl;
	cout << lcm << endl;


	return 0;
}