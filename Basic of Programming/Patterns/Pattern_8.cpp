//	 				*
//	 			*
// 			*
// 		*
// 	*


#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;


	int sp = n-1;
	for (int i = 1; i <= n; i++) {
		for (int i = 1; i <= sp; i++) {
			cout << "\t";
		} cout << "*";
		sp--;
		cout << endl;
	}

	return 0;
}