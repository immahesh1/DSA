#include<bits/stdc++.h>
using namespace std;

string ascii_diff(string s) {
	string out_str;
	out_str += s.at(0);

	for (int i = 1; i < s.size(); i++) {
		char curr = s[i];
		char prev = s[i - 1];
		out_str += to_string((int)curr - (int)prev) + curr;
	}
	return out_str;
}

int main()
{
	string s;
	cin >> s;

	cout << ascii_diff(s);

	return 0;
}