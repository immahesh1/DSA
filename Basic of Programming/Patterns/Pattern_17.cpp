// for n = 7
// 				*
// 				*	*
// 				*	*	*
// 	*	*	*	*	*	*	*
// 				*	*	*
// 				*	*
// 				*


#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;

	int os = n / 2;
	int st = 1;
	for (int i = 1; i <= n; i++) {
		// cout << os << " " << st << " " << is ;
		for (int j = 1; j <= os; j++) {
			if (i == (n + 1) / 2) {
				cout << "*\t";
			} else {
				cout << "\t";
			}
		}
		for (int j = 1; j <= st; j++) {
			cout << "*\t";
		}

		if (i <= n / 2) {
			st++;
		}
		else {
			st--;
		}
		cout << endl;
	}


	return 0;
}