// 			1
// 		2	3	2
// 	3	4	5	4	3
// 		2	3	2
// 			1


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
	int val = 1;
	for (int i = 1; i <= n; i++) {
		// cout << sp << " " << st;
		for (int j = 1; j <= sp; j++) {
			cout << "\t";
		}
		int val2 = val;
		for (int j = 1; j <= st; j++) {
			if (j <= st / 2) {
				int r = val2++;
				cout << r << "\t";
			} else {
				int r = val2--;
				cout << r << "\t";
			}
		}
		if (i <= n / 2 ) {
			sp--;
			st += 2;
			val++;
		} else {
			sp++;
			st -= 2;
			val--;
		}
		cout << endl;
	}


	return 0;
}