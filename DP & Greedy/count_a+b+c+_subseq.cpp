#include<bits/stdc++.h>
using namespace std;

int main()
{
	string s;
	cin >> s;

	int a = 0;
	int ab = 0;
	int abc = 0;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] == 'a') {
			a = 2 * a + 1;
		} else if (s[i] == 'b') {
			ab = 2 * ab + a;
		} else if (s[i] == 'c') {
			abc = 2 * abc + ab;
		}
	}

	cout << abc;


	return 0;
}