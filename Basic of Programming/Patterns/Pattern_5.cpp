// 				*
// 			*	*	*
// 		*	*	*	*	*
// 	*	*	*	*	*	*	*
// 		*	*	*	*	*
// 			*	*	*
// 				*


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

	int sp = n / 2;
	int st = 1;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= sp; j++) {
			cout << "\t";
		}
		for (int j = 1; j <= st; j++) {
			cout << "*\t";
		}

		if (i <= n / 2) {
			sp--;
			st += 2;
		} else {
			sp++;
			st -= 2;
		}
		cout << endl;
	}



	return 0;
}