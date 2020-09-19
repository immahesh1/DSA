// *						*
// *						*
// *						*
// *			*			*
// *		*		*		*
// *	*				*	*
// *						*


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

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (j == 1 || j == n) {
				cout << "*\t";
			} else {
				if (i > n / 2 && (i == j || i + j == n + 1)) {
					cout << "*\t";
				} else {
					cout << "\t";
				}

			}
		}
		cout << endl;
	}


	return 0;
}