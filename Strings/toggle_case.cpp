#include<bits/stdc++.h>
using namespace std;

int main()
{
	string s;
	cin >> s;
	string out;

	for (int i = 0; i < s.size(); i++) {
		if (isupper(s[i])) {
			out += tolower(s[i]);
		} else {
			out += toupper(s[i]);
		}
	}

	cout << out << endl;
	return 0;
}