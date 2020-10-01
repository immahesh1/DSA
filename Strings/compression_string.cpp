#include<bits/stdc++.h>
using namespace std;

string compression1(string s) {
	string out_str;
	out_str = s.at(0);
	for (int i = 1; i < s.size(); i++) {
		char curr = s[i];
		char prev = s[i - 1];
		if (curr != prev) {
			out_str.push_back(curr);
		}
	}
	return out_str;
}

string compression2(string s) {
	string out_str;
	int occ = 1;
	for (int i = 1; i <= s.size(); i++) {
		char curr = s[i];
		char prev = s[i - 1];
		if (curr == prev) {
			occ++;
		} else {
			if (occ > 1) {
				out_str += prev + to_string(occ);
			} else {
				out_str += prev;
			}
			occ = 1;
		}
	}
	return out_str;
}

int main()
{
	string s;
	cin >> s;

	cout << compression1(s) << endl;
	cout << compression2(s);


	return 0;
}