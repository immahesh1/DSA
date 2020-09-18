//	 *	*	*	*	*	*	*
// 		*				*
// 			*		*
// 				*
// 			*	*	*
// 		*	*	*	*	*
// 	*	*	*	*	*	*	*

#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;

	int os = 0;
	int st = n;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= os; j++) {
			cout << "\t";
		}

		for (int j = 1; j <= st; j++) {
			if (i > 1 && i <= n / 2 && j > 1 && j < st) {
				cout << "\t";
			} else {cout << "*\t";}
		}

		if (i <= n / 2) {
			os++;
			st -= 2;
		} else {
			os--;
			st += 2;
		}
		cout << endl;
	}


	return 0;
}