#include<bits/stdc++.h>
using namespace std;

int factorial(int n) {
	int fact = 1;
	for (int i = 2; i <= n; i++) {
		fact *= i;
	}
	return fact;
}

void string_permutation(string str) {
	int n = str.size();
	int f = factorial(n);

	for (int i = 0; i < f; i++) {
		string st = str;
		int temp = i;
		for (int div = n; div >= 1; div--) {
			int q = temp / div;
			int r = temp % div;
			cout << st[r];
			st.erase(st.begin() + r);
			temp = q;
		}
		cout << endl;
	}
}

int main()
{
	string s;
	cin >> s;

	string_permutation(s);


	return 0;
}