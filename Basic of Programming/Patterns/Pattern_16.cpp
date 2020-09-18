// 	1												1
// 	1	2										2	1
// 	1	2	3								3	2	1
// 	1	2	3	4						4	3	2	1
// 	1	2	3	4	5				5	4	3	2	1
// 	1	2	3	4	5	6		6	5	4	3	2	1
// 	1	2	3	4	5	6	7	6	5	4	3	2	1
#include<bits/stdc++.h>
using namespace std;

int main()
{

	int n;
	cin >> n;

	int st = 1;
	int sp = 2 * n - 3; // a/c to pattern
	int val = 1;
	for (int i = 1; i <= n; i++) {
		int val2 = val;
		for (int j = 1; j <= st; j++) {
			cout << val2 << "\t";
			val2++;
		}
		for (int j = 1; j <= sp; j++) {
			cout << "\t";
		}
		if (i == n) {
			st--;
			val2--;
		}
		for (int j = 1; j <= st; j++) {
			val2--;
			cout << val2 << "\t";
		}

		sp -= 2;
		st++;
		cout << endl;
	}


	return 0;
}