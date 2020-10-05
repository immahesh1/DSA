#include<bits/stdc++.h>
using namespace std;

std::vector<string> codes {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};


void print_kpc(string ques, string ans) {
	if (ques.size() == 0) {
		cout << ans << endl;
		return;
	}
	char f = ques[0];
	string rem = ques.substr(1, ques.size() - 1);
	string codechar = codes[f - '0'];
	for (auto c : codechar) {
		print_kpc(rem, ans + c);
	}
}

int main() {
	string s;
	cin >> s;
	print_kpc(s, "");
	return 0;
}